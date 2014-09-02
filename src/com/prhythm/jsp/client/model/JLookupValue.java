package com.prhythm.jsp.client.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bruce on 8/29/2014.
 */
public class JLookupValue {

    int id;
    String value;

    public JLookupValue() {
    }

    public JLookupValue(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static JLookupValue parse(Object value) {
        if (value == null) return null;
        Pattern pattern = Pattern.compile("^(\\d+);#(.+)$");
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.find()) return null;
        JLookupValue lookup = new JLookupValue();
        lookup.setId(Integer.parseInt(matcher.group(1)));
        lookup.setValue(matcher.group(2));
        return lookup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JLookupValue lookup = (JLookupValue) o;

        if (id != lookup.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}