package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 8/20/2014.
 */
public class JCalendar extends JList {

    protected JCalendar(JClientContext context, JWeb web) {
        super(context, web);
    }

    protected JCalendar(JList list) {
        super(list.getContext(), list.getWeb());
        attributes = list.attributes;
        fields = list.fields;
    }
}
