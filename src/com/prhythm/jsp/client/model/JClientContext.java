package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.model.port.Disposable;
import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JClientContext implements Disposable {
    static JClientContext CURRENT;
    String url;
    JSite site;
    JWeb web;
    JUser currentUser;

    protected JClientContext(String webUrl) {
        url = webUrl;
        if (url.endsWith("/")) url = url.substring(0, url.length() - 1);

        site = new JSite(this);
        web = new JWeb(this);
        getCurrentUser();

        CURRENT = this;
    }

    public static JClientContext connect(String webUrl) {
        return connect(webUrl, false);
    }

    public static JClientContext connect(String webUrl, boolean newInstance) {
        if (!newInstance && CURRENT != null && CURRENT.getUrl().equalsIgnoreCase(webUrl)) {
            return CURRENT;
        }
        clearCache();
        return new JClientContext(webUrl);
    }

    public static void clearCache() {
        if (CURRENT != null)
            try {
                CURRENT.finalize();
                CURRENT = null;
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
    }

    public String getUrl() {
        return url;
    }

    public JSite getSite() {
        return site;
    }

    public JWeb getWeb() {
        return web;
    }

    public JUser getCurrentUser() {
        if (currentUser != null) return currentUser;

        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                getUrl() + WebServiceUtil.UserGroup.URL,
                WebServiceUtil.UserGroup.GetCurrentUserInfo
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

        Node item = document.getElementsByTagName("User").item(0);
        currentUser = new JUser(this);
        currentUser.putAttributes(item.getAttributes());
        return currentUser;
    }

    @Override
    public void onDispose() {
        if (web != null) {
            web.onDispose();
            web = null;
        }
        if (site != null) {
            site.onDispose();
            site = null;
        }
        url = null;
    }

    public static interface Loadable<T> {
        T load();
    }

    public static class BaseContext implements Disposable {

        protected HashMap<String, JContentValue> attributes;
        protected JClientContext context;

        protected BaseContext(JClientContext context) {
            this.context = context;
            attributes = new HashMap<String, JContentValue>();
        }

        public JClientContext getContext() {
            return context;
        }

        protected void putAttributes(NamedNodeMap map) {
            for (int i = 0; i < map.getLength(); i++) {
                Node item = map.item(i);
                attributes.put(item.getNodeName(), new JContentValue(item.getNodeValue()));
            }
        }

        public String[] getAttributeNames() {
            String[] names = attributes.keySet().toArray(new String[attributes.size()]);
            Arrays.sort(names);
            return names;
        }

        public boolean containsAttribute(String name) {
            return attributes.containsKey(name);
        }

        public JContentValue getAttribute(String name) {
            if (attributes.containsKey(name)) {
                return attributes.get(name);
            } else {
                return null;
            }
        }

        public JContentValue findAttribute(String name) {
            for (String key : attributes.keySet()) {
                if (key.endsWith(name)) return attributes.get(key);
            }
            return null;
        }

        public void mergeAttribute(HashMap<String, JContentValue> attributes) {
            this.attributes.putAll(attributes);
        }

        @Override
        public void onDispose() {
            if (attributes != null) {
                attributes.clear();
                attributes = null;
            }
            if (context != null) {
                context.onDispose();
                context = null;
            }
        }
    }

    public static class BaseWeb extends BaseContext {

        protected JWeb web;

        protected BaseWeb(JClientContext context, JWeb web) {
            super(context);
            this.web = web;
        }

        public JWeb getWeb() {
            return web;
        }

        @Override
        public void onDispose() {
            if (web != null) {
                web.onDispose();
                web = null;
            }
            super.onDispose();
        }
    }

    public static class BaseList extends BaseWeb {
        protected JList list;

        protected BaseList(JClientContext context, JWeb web, JList list) {
            super(context, web);
            this.list = list;
        }

        public JList getList() {
            return list;
        }

        @Override
        public void onDispose() {
            if (list != null) {
                list.onDispose();
                list = null;
            }
            super.onDispose();
        }
    }
}
