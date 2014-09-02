package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 2014/8/19.
 */
public class JDocumentLibrary extends JList {

    protected JDocumentLibrary(JClientContext context, JWeb web) {
        super(context, web);
    }

    protected JDocumentLibrary(JList list) {
        super(list.getContext(), list.getWeb());
        attributes = list.attributes;
        fields = list.fields;
    }

}
