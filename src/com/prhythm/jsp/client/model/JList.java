package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.model.port.SiteContent;
import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JList extends JClientContext.BaseWeb implements SiteContent, JClientContext.Loadable<JList> {

    JFieldCollection fields;
    JViewCollection views;
    JFormCollection forms;

    HashSet<JListItem> temps;
    JListItemCollection items;
    UUID viewName;
    String rootFolder;

    boolean loaded;

    protected JList(JClientContext context, JWeb web) {
        super(context, web);
        fields = new JFieldCollection(context, web, this);
        views = new JViewCollection(context, web, this);
        forms = new JFormCollection(context, web, this);
        temps = new HashSet<JListItem>();
    }

    public JFieldCollection getFields() {
        return fields;
    }

    public JViewCollection getViews() {
        return views;
    }

    public JFormCollection getForms() {
        return forms;
    }

    public UUID getId() {
        if (attributes.containsKey("ID"))
            return attributes.get("ID").getValue();
        else
            return null;
    }

    public String getTitle() {
        if (attributes.containsKey("Title"))
            return attributes.get("Title").getValue();
        else
            return null;
    }

    /**
     * http://msdn.microsoft.com/en-us/library/microsoft.sharepoint.client.basetype(v=office.15).aspx
     *
     * @return
     */
    public int getBaseType() {
        if (attributes.containsKey("BaseType"))
            return (Integer) attributes.get("BaseType").getValue();
        else
            return -1;
    }

    public String getBaseTemplate() {
        if (attributes.containsKey("BaseTemplate"))
            return attributes.get("BaseTemplate").getValue().toString();
        else
            return null;
    }

    public Date getCreated() {
        if (attributes.containsKey("Created"))
            return attributes.get("Created").getValue();
        else
            return null;
    }

    public String getDescription() {
        if (attributes.containsKey("Description"))
            return attributes.get("Description").getValue();
        else
            return null;
    }

    public String getRootFolder() {
        if (attributes.containsKey("RootFolder"))
            return attributes.get("RootFolder").getValue();
        else
            return null;
    }

    public Date getModified() {
        if (attributes.containsKey("Modified"))
            return attributes.get("Modified").getValue();
        else
            return null;
    }

    public int getItemCount() {
        if (attributes.containsKey("ItemCount"))
            return (Integer) attributes.get("ItemCount").getValue();
        else
            return 0;
    }

    public String getImageUrl() {
        if (attributes.containsKey("ImageUrl"))
            return context.getUrl() + attributes.get("ImageUrl").getValue();
        else
            return null;
    }

    public String getDefaultViewUrl() {
        if (attributes.containsKey("DefaultViewUrl"))
            return attributes.get("DefaultViewUrl").getValue();
        else
            return null;
    }

    public JListItem getItemById(int id) {
        for (JListItem item : items) {
            if (item.getId() == id) return item.load();
        }
        for (JListItem item : temps) {
            if (item.getId() == id) return item.load();
        }
        JListItem item = new JListItem(context, web, this).load(id);
        temps.add(item);
        return item;
    }

    @Override
    public JList load() {
        if (loaded) return this;

        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Lists.URL,
                WebServiceUtil.Lists.GetList.replace("{listName}", String.format("{%s}", getId()))
        );

        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Http %d %s", response.getStatusCode(), response.getReason()));
        }

        Node listElement;
        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(response.getResponseBody().getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        NodeList nodes = document.getElementsByTagName("List");
        if (nodes.getLength() > 0)
            listElement = nodes.item(0);
        else
            return null;

        JList listData;
        listData = getWeb().getLists().parse((Element) listElement);

        fields = listData.fields;

        response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.SiteData.URL,
                WebServiceUtil.SiteData.GetList.replace("{strListName}", String.format("{%s}", getId()))
        );

        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Http %d %s", response.getStatusCode(), response.getReason()));
        }

        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(response.getResponseBody().getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        NodeList meta = document.getElementsByTagName("sListMetadata");

        if (meta.getLength() > 0) {
            Element data = (Element) meta.item(0);
            if (data.getElementsByTagName("BaseTemplate").getLength() > 0) {
                String baseTemplate = data.getElementsByTagName("BaseTemplate").item(0).getFirstChild().getNodeValue();

                if (Pattern.matches("[-]?\\d+", baseTemplate)) {
                    listData.attributes.put("BaseTemplate", new JContentValue(getWeb().getLists().getBaseTemplateName(Integer.parseInt(baseTemplate))));
                } else {
                    listData.attributes.put("BaseTemplate", new JContentValue(baseTemplate));
                }
            }
        }

        mergeAttribute(listData.attributes);
        loaded = true;

        return this;
    }

    public JListItemCollection getItems() {
        return getItems(null);
    }

    public JListItemCollection getItems(UUID viewName) {
        return getItems(viewName, null);
    }

    public JListItemCollection getItems(UUID viewName, String rootFolder) {
        boolean b = false;

        if ((this.viewName == null && viewName != null) || (this.viewName != null && !this.viewName.equals(viewName)))
            b = true;
        if ((this.rootFolder == null && rootFolder != null) || (this.rootFolder != null && !this.rootFolder.equals(rootFolder)))
            b = true;

        if (b)
            return items = new JListItemCollection(context, web, this).load(this.viewName = viewName, this.rootFolder = rootFolder);
        else
            return items;
    }

    public JListItemCollection items() {
        return items;
    }

    @Override
    public void onDispose() {
        if (fields != null) {
            fields.onDispose();
            fields = null;
        }
        if (views != null) {
            views.onDispose();
            views = null;
        }
        super.onDispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JList list = (JList) o;

        if (getId() != null ? !getId().equals(list.getId()) : list.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}