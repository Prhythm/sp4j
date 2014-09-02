package com.prhythm.jsp.client.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Bruce on 8/29/2014.
 */
public class JLookupValueCollection implements Collection<JLookupValue> {

    HashSet<JLookupValue> values;

    public JLookupValueCollection() {
        this.values = new HashSet<JLookupValue>();
    }

    public JLookupValueCollection(String values) {
        this();
        if (values == null) return;
//            values.split(";");
        // todo : split value
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<JLookupValue> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(JLookupValue jLookup) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends JLookupValue> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
