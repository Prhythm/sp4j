package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.JHttpClientClient;
import com.prhythm.jsp.client.util.JHttpClientUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JSite extends JClientContext.BaseContext implements JClientContext.Loadable<JSite> {

    boolean loaded;

    protected JSite(JClientContext context) {
        super(context);
    }

    @Override
    public JSite load() {
        if (loaded) return this;

        String body = null;
        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Sites.URL,
                    JHttpClientUtil.Sites.GetSite.replace("{SiteUrl}", context.getUrl()),
                    JHttpClientClient.getWebserviceSopa()
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Node listElement;
        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(body.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        NodeList nodes = document.getElementsByTagName("GetSiteResult");
        if (nodes.getLength() > 0)
            listElement = nodes.item(0).getFirstChild();
        else
            return null;

        Pattern pattern = Pattern.compile("(\\w+)=\\\"([^\\\"]+)\\\"");
        Matcher matcher = pattern.matcher(listElement.getNodeValue());
        int start = 0;
        while (matcher.find(start)) {
            attributes.put(matcher.group(1), new JContentValue(matcher.group(2)));
            start = matcher.end();
        }

        loaded = true;
        return this;
    }

    public String getUrl() {
        if (attributes.containsKey("Url"))
            return attributes.get("Url").getValue();
        else
            return null;
    }

    public UUID getId() {
        if (attributes.containsKey("Id"))
            return attributes.get("Id").getValue();
        else
            return null;
    }
}