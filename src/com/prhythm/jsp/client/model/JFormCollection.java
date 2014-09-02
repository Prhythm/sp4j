package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/29/2014.
 */
public class JFormCollection extends JClientContext.BaseList implements Collection<JForm>, JClientContext.Loadable<JFormCollection> {

    HashSet<JForm> forms;

    boolean loaded;

    protected JFormCollection(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
        forms = new HashSet<JForm>();
    }

    @Override
    public JFormCollection load() {
        if (loaded) return this;

        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Forms.URL,
                WebServiceUtil.Forms.GetFormCollection.replace("{listName}", list.getId().toString())
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

        NodeList nodes = document.getElementsByTagName("Form");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            String url = node.getAttribute("Url");

            if (url == null) continue;
            JForm form = getFormByUrl(url);
            if (form == null) {
                form = new JForm(context, web, list);
                form.putAttributes(node.getAttributes());
                add(form);
            } else {
                form.putAttributes(node.getAttributes());
            }
        }

        // Find default
        for (JForm form : forms) {
            if (!"DisplayForm".equalsIgnoreCase(form.getType())) continue;
            if (form.load().isDefault()) break;
        }

        loaded = true;
        return this;
    }

    JForm getFormByUrl(String url) {
        if (url == null) return null;
        for (JForm form : forms) {
            if (url.equalsIgnoreCase(form.getUrl())) return form;
        }
        return null;
    }

    @Override
    public int size() {
        return forms.size();
    }

    @Override
    public boolean isEmpty() {
        return forms.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return forms.contains(o);
    }

    @Override
    public Iterator<JForm> iterator() {
        return forms.iterator();
    }

    @Override
    public Object[] toArray() {
        return forms.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return forms.toArray(a);
    }

    @Override
    public boolean add(JForm field) {
        if (forms.contains(field))
            return false;
        else
            return forms.add(field);
    }

    @Override
    public boolean remove(Object o) {
        return forms.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return forms.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JForm> c) {
        boolean v = true;
        for (JForm f : c) {
            if (!add(f)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return forms.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return forms.retainAll(c);
    }

    @Override
    public void clear() {
        forms.clear();
    }
}
