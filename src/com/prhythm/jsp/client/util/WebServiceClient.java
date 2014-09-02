package com.prhythm.jsp.client.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public abstract class WebServiceClient {

    protected Credential credential;

    public WebServiceClient() {
    }

    public WebServiceClient(String userName, String password, String domain) {
        this.credential = new Credential(userName, password, domain);
    }

    public WebServiceResponse execute(String url, String soapEntity) {
        if (credential == null)
            return execute(url, soapEntity, null, null, null);
        else
            return execute(url, soapEntity, credential.userName, credential.password, credential.domain);
    }

    protected String getAction(String xml) {
        if (xml == null) return null;
        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        Element element = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            element = (Element) childNodes.item(i);
        }
        if (element == null) return null;
        childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            element = (Element) childNodes.item(i);
        }
        if (element == null) return null;
        return element.getTagName();
    }

    abstract public WebServiceResponse execute(String url, String soapEntity, String userName, String password, String domain);

    public static class Credential {
        public String userName;
        public String password;
        public String domain;

        public Credential(String userName, String password, String domain) {
            this.userName = userName;
            this.password = password;
            this.domain = domain;
        }
    }

    public static class WebServiceResponse {
        int statusCode;
        String reason;
        String responseBody;

        public WebServiceResponse(int statusCode, String reason, String responseBody) {
            this.statusCode = statusCode;
            this.responseBody = responseBody;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getReason() {
            return reason;
        }

        public String getResponseBody() {
            return responseBody;
        }
    }
}