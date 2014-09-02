package com.prhythm.jsp.client.model;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JFieldCollection extends JClientContext.BaseList implements Collection<JField> {

    HashSet<JField> fields;

    protected JFieldCollection(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
        fields = new HashSet<JField>();
    }

    public JField getFieldById(UUID id) {
        if (id == null) return null;
        for (JField field : fields) {
            if (id.equals(field.getId())) return field;
        }
        return null;
    }

    public JField getFieldByDisplayName(String displayName) {
        if (displayName == null) return null;
        for (JField field : fields) {
            if (displayName.equals(field.getDisplayName())) return field;
        }
        return null;
    }

    public JField getFieldByStaticName(String staticName) {
        if (staticName == null) return null;
        for (JField field : fields) {
            if (staticName.equals(field.getStaticName())) return field;
        }
        return null;
    }

    void parse(Element element) {
        if (element == null || !"Fields".equals(element.getTagName())) return;

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Element item = (Element) childNodes.item(i);
            JField field = getFieldById(UUID.fromString(item.getAttribute("ID").replace("{", "").replace("}", "")));
            if (field == null) {
                field = new JField(context, web, list);
                field.parse(item);
                add(field);
            } else {
                field.parse(item);
            }
        }
    }

    @Override
    public void onDispose() {
        if (fields != null) {
            fields.clear();
            fields = null;
        }
        super.onDispose();
    }

    @Override
    public int size() {
        return fields.size();
    }

    @Override
    public boolean isEmpty() {
        return fields.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return fields.contains(o);
    }

    @Override
    public Iterator<JField> iterator() {
        return fields.iterator();
    }

    @Override
    public Object[] toArray() {
        return fields.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return fields.toArray(a);
    }

    @Override
    public boolean add(JField field) {
        if (fields.contains(field))
            return false;
        else
            return fields.add(field);
    }

    @Override
    public boolean remove(Object o) {
        return fields.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return fields.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JField> c) {
        boolean v = true;
        for (JField f : c) {
            if (!add(f)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return fields.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return fields.retainAll(c);
    }

    @Override
    public void clear() {
        fields.clear();
    }
}
