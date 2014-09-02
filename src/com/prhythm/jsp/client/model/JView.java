package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/25/2014.
 */
public class JView extends JClientContext.BaseList implements JClientContext.Loadable<JView> {

    String xml;
    String[] viewFields;

    boolean loaded;

    protected JView(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    public String getDisplayName() {
        if (attributes.containsKey("DisplayName"))
            return attributes.get("DisplayName").getValue();
        else
            return null;
    }

    public UUID getName() {
        if (attributes.containsKey("Name"))
            return attributes.get("Name").getValue();
        else
            return null;
    }

    public boolean isDefaultView() {
        if (attributes.containsKey("DefaultView"))
            return (Boolean) attributes.get("DefaultView").getValue();
        else
            return false;
    }

    @Override
    public JView load() {
        if (loaded) return this;
        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Views.URL,
                WebServiceUtil.Views.GetView
                        .replace("{listName}", list.getTitle())
                        .replace("{viewName}", String.format("{%s}", getName()))
        );

        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Http %d %s", response.getStatusCode(), response.getReason()));
        }

        Pattern pattern = Pattern.compile("<GetViewResult>(.+)</GetViewResult>", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(response.getResponseBody());
        if (matcher.find()) {
            xml = matcher.group(1);
        }

        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        List<String> fields = new ArrayList<String>();
        NodeList vf = document.getElementsByTagName("ViewFields");
        if (vf.getLength() > 0) {
            Element item = (Element) vf.item(0);
            NodeList childNodes = item.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (Node.ELEMENT_NODE != childNodes.item(i).getNodeType()) continue;
                Element field = (Element) childNodes.item(i);
                fields.add(field.getAttribute("Name"));
            }
        }

        viewFields = fields.toArray(new String[fields.size()]);
        loaded = true;

        return this;
    }

    public String[] getViewFields() {
        return viewFields;
    }

    @Override
    public void onDispose() {
        if (xml != null) {
            xml = null;
        }
        if (viewFields != null) {
            for (int i = 0; i < viewFields.length; i++) {
                viewFields[i] = null;
            }
            viewFields = null;
        }
        super.onDispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JView jView = (JView) o;

        if (!getName().equals(jView.getName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
