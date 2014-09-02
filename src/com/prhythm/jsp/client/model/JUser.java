package com.prhythm.jsp.client.model;

/**
 * Created by Bruce on 8/29/2014.
 */
public class JUser extends JClientContext.BaseContext {

    protected JUser(JClientContext context) {
        super(context);
    }

    public int getId() {
        if (attributes.containsKey("ID"))
            return (Integer) attributes.get("ID").getValue();
        else
            return 0;
    }

    public String getName() {
        if (attributes.containsKey("Name"))
            return attributes.get("Name").getValue();
        else
            return null;
    }

    public String getLoginName() {
        if (attributes.containsKey("LoginName"))
            return attributes.get("LoginName").getValue();
        else
            return null;
    }

    public String getEmail() {
        if (attributes.containsKey("Email"))
            return attributes.get("Email").getValue();
        else
            return null;
    }
}
