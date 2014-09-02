package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 2014/8/19.
 */
public class JFolder extends JFile {

    protected JFolder(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    protected JFolder(JListItem item) {
        super(item.getContext(), item.getWeb(), item.getList());
        this.attributes = item.attributes;
    }

    @Override
    public String getIconPath() {
        return "/_layouts/images/folder.gif";
    }
}
