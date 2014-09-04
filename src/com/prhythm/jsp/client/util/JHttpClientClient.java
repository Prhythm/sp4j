package com.prhythm.jsp.client.util;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public abstract class JHttpClientClient {

    protected Credential credential;

    CookieStore cookies;

    public JHttpClientClient() {
        cookies = new BasicCookieStore();
    }

    public JHttpClientClient(String userName, String password, String domain) {
        this.credential = new Credential(userName, password, domain);
        cookies = new BasicCookieStore();
    }

    public static HashMap<String, String> getWebserviceSopa() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/soap+xml; charset=utf-8");
        return headers;
    }

    public InputStream get(String url, HashMap<String, String> headers) throws Exception {
        return get(url, headers, credential.userName, credential.password, credential.domain);
    }

    public abstract InputStream get(String url, HashMap<String, String> headers, String userName, String password, String domain) throws Exception;

    public InputStream post(String url, String content, HashMap<String, String> headers) throws Exception {
        return post(url, content, headers, credential.userName, credential.password, credential.domain);
    }

    public abstract InputStream post(String url, String content, HashMap<String, String> headers, String userName, String password, String domain) throws Exception;

    public String getText(String url, HashMap<String, String> headers) {
        return getText(url, headers, credential.userName, credential.password, credential.domain);
    }

    public String getText(String url, HashMap<String, String> headers, String userName, String password, String domain) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            StringBuilder out = new StringBuilder();
            InputStream is = get(url, headers, userName, password, domain);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                out.append("\n");
                out.append(line);
            }
            return out.length() > 0 ? out.substring(1) : "";
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (isr != null)
                try {
                    isr.close();
                } catch (IOException e) {

                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {

                }
        }
    }

    public String postText(String url, String content, HashMap<String, String> headers) {
        return postText(url, content, headers, credential.userName, credential.password, credential.domain);
    }

    public String postText(String url, String content, HashMap<String, String> headers, String userName, String password, String domain) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            StringBuilder out = new StringBuilder();
            InputStream is = post(url, content, headers, userName, password, domain);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                out.append("\n");
                out.append(line);
            }
            return out.length() > 0 ? out.substring(1) : "";
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (isr != null)
                try {
                    isr.close();
                } catch (IOException e) {

                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {

                }
        }
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

    protected CookieStore getCookies() {
        return cookies;
    }

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
}