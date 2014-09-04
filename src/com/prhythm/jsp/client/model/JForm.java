package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.JHttpClientClient;
import com.prhythm.jsp.client.util.JHttpClientUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/29/2014.
 */
public class JForm extends JClientContext.BaseList implements JClientContext.Loadable<JForm> {

    boolean loaded;

    protected JForm(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    @Override
    public JForm load() {
        if (loaded) return this;

        String body = null;
        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Forms.URL,
                    JHttpClientUtil.Forms.GetFormCollection
                            .replace("{listName}", list.getId().toString())
                            .replace("{formUrl}", getUrl()),
                    JHttpClientClient.getWebserviceSopa()
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(body.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        NodeList nodes = document.getElementsByTagName("Form");
        if (nodes.getLength() > 0) {
            Element node = (Element) nodes.item(0);
            putAttributes(node.getAttributes());
        }

        loaded = true;
        return this;
    }

    public boolean isDefault() {
        if (attributes.containsKey("Default"))
            return (Boolean) attributes.get("Default").getValue();
        else
            return false;
    }

    public String getUrl() {
        if (attributes.containsKey("Url"))
            return attributes.get("Url").getValue();
        else
            return null;
    }

    public String getType() {
        if (attributes.containsKey("Type"))
            return attributes.get("Type").getValue();
        else
            return null;
    }
}
