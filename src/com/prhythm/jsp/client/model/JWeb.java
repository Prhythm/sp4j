package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.model.port.SiteContent;
import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JWeb extends JClientContext.BaseContext implements SiteContent, JClientContext.Loadable<JWeb> {

    JListCollection lists;
    JWebCollection webs;

    protected JWeb(JClientContext context) {
        super(context);
        this.lists = new JListCollection(context, this);
        this.webs = new JWebCollection(context, this);
    }

    public JListCollection getLists() {
        return lists;
    }

    public JWebCollection getWebs() {
        return webs;
    }

    @Override
    public JWeb load() {
        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Webs.URL,
                WebServiceUtil.Webs.GetWeb.replace("{webUrl}", context.getUrl())
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

        NodeList nodes = document.getElementsByTagName("Web");
        if (nodes.getLength() > 0) {
            Element web = (Element) nodes.item(0);

            putAttributes(web.getAttributes());
        }
        return this;
    }

    public String getTitle() {
        if (attributes.containsKey("Title"))
            return attributes.get("Title").getValue();
        else
            return null;
    }

    public String getDescription() {
        if (attributes.containsKey("Description"))
            return attributes.get("Description").getValue();
        else
            return null;
    }

    public String getUrl() {
        if (attributes.containsKey("Url"))
            return attributes.get("Url").getValue();
        else
            return null;
    }

    public String getIconUrl() {
        try {
            URL url = new URL(getUrl());
            url = new URL(url, "/_layouts/images/SharePointFoundation16.png");
            return url.toString();
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public UUID getId() {
        if (attributes.containsKey("Id"))
            return attributes.get("Id").getValue();
        else
            return null;
    }

    public Date getModified() {
        return null;
    }

    @Override
    public void onDispose() {
        if (lists != null) {
            lists.onDispose();
            lists = null;
        }
        super.onDispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWeb jWeb = (JWeb) o;

        if (getId() != null ? !getId().equals(jWeb.getId()) : jWeb.getId() != null) return false;
        if (getUrl() != null ? !getUrl().equals(jWeb.getUrl()) : jWeb.getUrl() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }
}