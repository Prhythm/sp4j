package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.JHttpClientClient;
import com.prhythm.jsp.client.util.JHttpClientUtil;
import com.prhythm.jsp.client.util.StringUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/25/2014.
 */
public class JListItemCollection extends JClientContext.BaseList implements Collection<JListItem>, JClientContext.Loadable<JListItemCollection> {

    JView view;
    LinkedList<JListItem> items;
    String rootFolder;

    @Deprecated
    HashMap<Integer, String> pager;
    @Deprecated
    int currentPageIndex;

    String listItemCollectionPositionNext;

    protected JListItemCollection(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
        pager = new HashMap<Integer, String>();
        items = new LinkedList<JListItem>();
    }

    public JListItem getItemAt(int i) {
        return items.get(i);
    }

    @Deprecated
    private JListItemCollection load(JView view, String rootFolder, int pageIndex) {
        String queryOption = "";

        if (pageIndex < 0 || !(pager.containsKey(pageIndex) || pager.containsKey(pageIndex - 1)))
            pageIndex = 0;

        if (rootFolder != null)
            queryOption += String.format("<Folder>%s</Folder>", StringUtil.escapeXml(rootFolder));
        if (pageIndex > 0 && pager.containsKey(pageIndex - 1))
            queryOption += String.format("<Paging ListItemCollectionPositionNext=\"%s\"/>", StringUtil.escapeXml(pager.get(pageIndex - 1)));

        String body = null;
        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Lists.URL,
                    JHttpClientUtil.Lists.GetListItems
                            .replace("{listName}", String.format("{%s}", list.getId()))
                            .replace("{viewName}", String.format("{%s}", view.getName()))
                            .replace("{query}", "")
                            .replace("{viewFields}", "")
                            .replace("{rowLimit}", "")
                            .replace("{queryOptions}", queryOption)
                            .replace("{webID}", ""),
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

        Element listItems = (Element) document.getElementsByTagName("listitems").item(0);
        NodeList childNodes = listItems.getChildNodes();
        Element data = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() != Node.ELEMENT_NODE) continue;
            data = (Element) item;
            break;
        }
        if (data == null) return this;

        pager.put(pageIndex, data.getAttribute("ListItemCollectionPositionNext"));

        childNodes = data.getChildNodes();
        items.clear();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            Element row = (Element) childNodes.item(i);
            JListItem item = new JListItem(context, web, list);
            item.putAttributes(row.getAttributes());
            if (list instanceof JDocumentLibrary && item.attributes.containsKey("ows_FSObjType")) {
                JLookupValue v = item.getAttribute("ows_FSObjType").getValue();
                if (v != null && "1".equals(v.getValue()))
                    item = new JFolder(item);
                if (v != null && "0".equals(v.getValue()))
                    item = new JFile(item);
            }
            items.add(item);
        }

        // save current view
        this.view = view;
        // save current root
        this.rootFolder = rootFolder;
        // save current page index
        this.currentPageIndex = pageIndex;

        return this;
    }

    public JListItemCollection loadMore() {
        return loadMore(this.view, this.rootFolder);
    }

    protected JListItemCollection loadMore(JView view, String rootFolder) {
        if ("".equals(listItemCollectionPositionNext)) return this;   // No more data

        String queryOption = "";

        if (rootFolder != null)
            queryOption += String.format("<Folder>%s</Folder>", StringUtil.escapeXml(rootFolder));
        if (listItemCollectionPositionNext != null && !"".equals(listItemCollectionPositionNext))
            queryOption += String.format("<Paging ListItemCollectionPositionNext=\"%s\"/>", StringUtil.escapeXml(listItemCollectionPositionNext));

        String body = null;
        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Lists.URL,
                    JHttpClientUtil.Lists.GetListItems
                            .replace("{listName}", String.format("{%s}", list.getId()))
                            .replace("{viewName}", String.format("{%s}", view.getName()))
                            .replace("{query}", "")
                            .replace("{viewFields}", "")
                            .replace("{rowLimit}", "")
                            .replace("{queryOptions}", queryOption)
                            .replace("{webID}", ""),
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

        Element listItems = (Element) document.getElementsByTagName("listitems").item(0);
        NodeList childNodes = listItems.getChildNodes();
        Element data = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() != Node.ELEMENT_NODE) continue;
            data = (Element) item;
            break;
        }
        if (data == null) return this;

        if (listItemCollectionPositionNext == null) items.clear();
        listItemCollectionPositionNext = data.getAttribute("ListItemCollectionPositionNext");
        if (listItemCollectionPositionNext == null) listItemCollectionPositionNext = "";

        childNodes = data.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            Element row = (Element) childNodes.item(i);
            JListItem item = new JListItem(context, web, list);
            item.putAttributes(row.getAttributes());
            if (list instanceof JDocumentLibrary && item.attributes.containsKey("ows_FSObjType")) {
                JLookupValue v = item.getAttribute("ows_FSObjType").getValue();
                if (v != null && "1".equals(v.getValue()))
                    item = new JFolder(item);
                if (v != null && "0".equals(v.getValue()))
                    item = new JFile(item);
            }
            items.add(item);
        }

        // save current view
        this.view = view;
        // save current root
        this.rootFolder = rootFolder;

        return this;
    }

    @Override
    public JListItemCollection load() {
        return loadMore(list.getViews().getDefaultView(), null);
    }

    public JListItemCollection load(UUID viewName) {
        return loadMore(
                view == null ? list.getViews().getDefaultView() : list.getViews().getViewByName(viewName),
                null
        );
    }

    /**
     * first load
     *
     * @return
     */
    public JListItemCollection load(UUID viewName, String rootFolder) {
        return loadMore(
                view == null ? list.getViews().getDefaultView() : list.getViews().getViewByName(viewName),
                rootFolder
        );
    }

    @Deprecated
    public JListItemCollection nextPage() {
        return load(view, rootFolder, currentPageIndex + 1);
    }

    @Deprecated
    public JListItemCollection previousPage() {
        return load(view, rootFolder, currentPageIndex - 1);
    }

    @Deprecated
    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public boolean hasMoreItems() {
//        return !(pager.get(currentPageIndex) == null || "".equals(pager.get(currentPageIndex)));
        return listItemCollectionPositionNext != null && !"".equals(listItemCollectionPositionNext);
    }

    public JView getCurrentView() {
        return view;
    }

    @Override
    public void onDispose() {
        if (view != null) {
            view.onDispose();
            view = null;
        }
        if (items != null) {
            items.clear();
            items = null;
        }
        if (pager != null) {
            pager.clear();
            pager = null;
        }
        super.onDispose();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<JListItem> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return items.toArray(a);
    }

    @Override
    public boolean add(JListItem jListItem) {
        if (items.contains(jListItem))
            return false;
        else
            return items.add(jListItem);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JListItem> c) {
        boolean v = true;
        for (JListItem l : c) {
            if (!add(l)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return items.retainAll(c);
    }

    @Override
    public void clear() {
        items.clear();
    }
}
