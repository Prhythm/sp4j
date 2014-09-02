package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.WebServiceClient;
import com.prhythm.jsp.client.util.WebServiceUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by bruce_c_tsai on 8/25/2014.
 */
public class JViewCollection extends JClientContext.BaseList implements Collection<JView>, JClientContext.Loadable<JViewCollection> {

    HashSet<JView> views;
    boolean loaded;

    public JViewCollection(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
        this.views = new HashSet<JView>();
    }

    public JView getDefaultView() {
        load();
        if (views.size() == 0) return null;
        for (JView view : views) {
            if (view.isDefaultView()) return view.load();
        }
        return null;
    }

    public JView getViewByName(UUID name) {
        if (name == null) return null;
        load();
        if (views.size() == 0) return null;
        for (JView view : views) {
            if (name.equals(view.getName())) return view.load();
        }
        return null;
    }

    public JView getViewByTitle(String title) {
        if (title == null || title.trim().length() == 0) return null;
        load();
        if (views.size() == 0) return null;
        for (JView view : views) {
            if (title.trim().equalsIgnoreCase(view.getDisplayName())) return view;
        }
        return null;
    }

    public JViewCollection loadAll() {
        NodeList views;
        try {
            views = getDataFromViewWS();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < views.getLength(); i++) {
            Element node = (Element) views.item(i);
            JView view = new JView(context, web, list);
            view.putAttributes(node.getAttributes());
            this.views.add(view);
        }

        return this;
    }

    NodeList getDataFromViewWS() throws ParserConfigurationException, IOException, SAXException {
        WebServiceClient.WebServiceResponse response = WebServiceUtil.execute(
                context.getUrl() + WebServiceUtil.Views.URL,
                WebServiceUtil.Views.GetViewCollection.replace("{listName}", list.getTitle())
        );

        if (response.getStatusCode() != 200) {
            throw new RuntimeException(String.format("Http %d %s", response.getStatusCode(), response.getReason()));
        }

        Document document = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new ByteArrayInputStream(response.getResponseBody().getBytes()));

        return document.getElementsByTagName("View");
    }

    @Override
    public JViewCollection load() {
        if (!loaded) {
            loaded = true;
            loadAll();
        }
        return this;
    }

    @Override
    public void onDispose() {
        if (views != null) {
            views.clear();
            views = null;
        }
        super.onDispose();
    }

    @Override
    public int size() {
        return views.size();
    }

    @Override
    public boolean isEmpty() {
        return views.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return views.contains(o);
    }

    @Override
    public Iterator<JView> iterator() {
        return views.iterator();
    }

    @Override
    public Object[] toArray() {
        return views.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return views.toArray(a);
    }

    @Override
    public boolean add(JView jView) {
        if (views.contains(jView)) {
            return false;
        } else {
            return views.add(jView);
        }
    }

    @Override
    public boolean remove(Object o) {
        return views.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JView> c) {
        boolean v = true;
        for (JView l : c) {
            if (!add(l)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return retainAll(c);
    }

    @Override
    public void clear() {
        views.clear();
    }
}
