package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 9/2/2014.
 */
public class JWebCollection extends JClientContext.BaseWeb implements Collection<JWeb>, JClientContext.Loadable<JWebCollection> {

    LinkedList<JWeb> webs;
    boolean loaded;

    public JWebCollection(JClientContext context, JWeb web) {
        super(context, web);
        webs = new LinkedList<JWeb>();
    }

    @Override
    public JWebCollection load() {
        if (loaded) return this;

        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Webs.URL,
                WebServiceUtil.Webs.GetWebCollection
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

        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            JWeb web = new JWeb(context);
            web.putAttributes(node.getAttributes());
            add(web);
        }

        loaded = true;
        return this;
    }

    public JWeb get(int i) {
        return webs.get(i);
    }

    @Override
    public int size() {
        load();
        return webs.size();
    }

    @Override
    public boolean isEmpty() {
        load();
        return webs.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        load();
        return webs.contains(o);
    }

    @Override
    public Iterator<JWeb> iterator() {
        load();
        return webs.iterator();
    }

    @Override
    public Object[] toArray() {
        load();
        return webs.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        load();
        return webs.toArray(a);
    }

    @Override
    public boolean add(JWeb web) {
        if (webs.contains(web)) {
            for (JWeb exists : webs) {
                if (exists.equals(web)) {
                    exists.mergeAttribute(web.attributes);
                    web.mergeAttribute(exists.attributes);
                    return true;
                }
            }
            return false;
        } else {
            return webs.add(web);
        }
    }

    @Override
    public boolean remove(Object o) {
        return webs.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return webs.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JWeb> c) {
        boolean v = true;
        for (JWeb l : c) {
            if (!add(l)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return webs.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return webs.retainAll(c);
    }

    @Override
    public void clear() {
        webs.clear();
    }

    @Override
    public void onDispose() {
        if (webs != null) {
            webs.clear();
            webs = null;
        }
        super.onDispose();
    }
}
