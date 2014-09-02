package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.StringUtil;
import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JListItem extends JClientContext.BaseList implements JClientContext.Loadable<JListItem> {

    boolean loaded;

    protected JListItem(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    public int getId() {
        if (attributes.containsKey("ows_ID"))
            return (Integer) attributes.get("ows_ID").getValue();
        else
            return 0;
    }

    public String getTitle() {
        if (attributes.containsKey("ows_Title"))
            return attributes.get("ows_Title").getValue();
        else
            return null;
    }

    public Date getCreated() {
        if (attributes.containsKey("ows_Title"))
            return attributes.get("ows_Title").getValue();
        else
            return null;
    }

    public Date getModified() {
        if (attributes.containsKey("ows_Modified"))
            return attributes.get("ows_Modified").getValue();
        else
            return null;
    }

    public JLookupValue getCreatedBy() {
        if (attributes.containsKey("ows_Author"))
            return attributes.get("ows_Author").getValue();
        else
            return null;
    }

    public JLookupValue getModifiedBy() {
        if (attributes.containsKey("ows_Editor"))
            return attributes.get("ows_Editor").getValue();
        else
            return null;
    }

    @Override
    public JListItem load() {
        return load(getId());
    }

    public JListItem load(int id) {
        if (loaded) return this;

        String query = "<Query>\n" +
                "  <Where>\n" +
                "    <Eq>\n" +
                "      <FieldRef Name=\"ID\" />\n" +
                "      <Value Type=\"Counter\">" + id + "</Value>\n" +
                "    </Eq>\n" +
                "  </Where>\n" +
                "</Query>";

        StringBuilder viewFields = new StringBuilder("<ViewFields>");
        for (JField field : list.fields) {
            if (!field.isHidden())
                viewFields.append(String.format("<FieldRef Name=\"%s\" />", StringUtil.escapeXml(field.getStaticName())));
        }
        viewFields.append("</ViewFields>");

        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Lists.URL,
                WebServiceUtil.Lists.GetListItems
                        .replace("{listName}", String.format("{%s}", list.getId()))
                        .replace("{viewName}", "")
                        .replace("{query}", query)
                        .replace("{viewFields}", viewFields.toString())
                        .replace("{rowLimit}", "")
                        .replace("{queryOptions}", "")
                        .replace("{webID}", "")
        );

        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Http %d %s", response.getStatusCode(), response.getReason()));
        }

        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(response.getResponseBody().getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Element listitems = (Element) document.getElementsByTagName("listitems").item(0);
        NodeList childNodes = listitems.getChildNodes();
        Element data = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) data = (Element) item;
        }
        if (data == null) return this;


        childNodes = data.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            Element row = (Element) childNodes.item(i);
            putAttributes(row.getAttributes());
        }

        loaded = true;
        return this;
    }

    public JFile asFile() {
        if (list instanceof JDocumentLibrary && attributes.containsKey("ows_FSObjType")) {
            JLookupValue v = getAttribute("ows_FSObjType").getValue();
            if (v != null && "0".equals(v.getValue()))
                return new JFile(this);
        }
        return null;
    }

    public JFolder asFolder() {
        if (list instanceof JDocumentLibrary && attributes.containsKey("ows_FSObjType")) {
            JLookupValue v = getAttribute("ows_FSObjType").getValue();
            if (v != null && "1".equals(v.getValue()))
                return new JFolder(this);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JListItem jListItem = (JListItem) o;

        if (getId() != jListItem.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}