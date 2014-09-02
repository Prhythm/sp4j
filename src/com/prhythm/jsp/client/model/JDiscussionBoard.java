package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 8/20/2014.
 */
public class JDiscussionBoard extends JList {

    protected JDiscussionBoard(JClientContext context, JWeb web) {
        super(context, web);
    }

    protected JDiscussionBoard(JList list) {
        super(list.getContext(), list.getWeb());
        attributes = list.attributes;
        fields = list.fields;
    }
}
