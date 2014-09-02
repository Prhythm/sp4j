package com.prhythm.jsp.client.model;

import org.w3c.dom.Element;

import java.util.UUID;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JField extends JClientContext.BaseList {

    protected JField(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    void parse(Element element) {
        if (element == null || !"Field".equalsIgnoreCase(element.getTagName())) return;
        putAttributes(element.getAttributes());
    }

    public UUID getId() {
        if (attributes.containsKey("ID"))
            return attributes.get("ID").getValue();
        else
            return null;
    }

    public String getType() {
        if (attributes.containsKey("Type"))
            return attributes.get("Type").getValue();
        else
            return null;
    }

    public boolean isReadOnly() {
        if (attributes.containsKey("ReadOnly"))
            return (Boolean) attributes.get("ReadOnly").getValue();
        else
            return false;
    }

    public boolean isHidden() {
        if (attributes.containsKey("Hidden"))
            return (Boolean) attributes.get("Hidden").getValue();
        else
            return false;
    }

    public String getDisplayName() {
        if (attributes.containsKey("DisplayName"))
            return attributes.get("DisplayName").getValue();
        else
            return null;
    }

    public String getName() {
        if (attributes.containsKey("Name"))
            return attributes.get("Name").getValue();
        else
            return null;
    }

    public String getStaticName() {
        if (attributes.containsKey("StaticName"))
            return attributes.get("StaticName").getValue();
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JField jField = (JField) o;

        if (!getId().equals(jField.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}