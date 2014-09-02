package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 8/25/2014.
 */
public class JIssue extends JList {

    protected JIssue(JClientContext context, JWeb web) {
        super(context, web);
    }

    protected JIssue(JList list) {
        super(list.getContext(), list.getWeb());
        attributes = list.attributes;
        fields = list.fields;
    }
}
