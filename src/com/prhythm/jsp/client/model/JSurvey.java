package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 8/20/2014.
 */
public class JSurvey extends JList {

    protected JSurvey(JClientContext context, JWeb web) {
        super(context, web);
    }

    protected JSurvey(JList list) {
        super(list.getContext(), list.getWeb());
        attributes = list.attributes;
        fields = list.fields;
    }
}
