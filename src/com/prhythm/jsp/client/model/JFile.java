package com.prhythm.jsp.client.model;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Bruce on 2014/8/19.
 */
public class JFile extends JListItem {

    protected JFile(JClientContext context, JWeb web, JList list) {
        super(context, web, list);
    }

    protected JFile(JListItem item) {
        super(item.getContext(), item.getWeb(), item.getList());
        this.attributes = item.attributes;
    }

    @Override
    public String getTitle() {
        String name = getFileLeafRef();
        if (name == null) return null;
        if (name.contains("."))
            return name.substring(0, name.lastIndexOf("."));
        else
            return name;
    }

    public String getExtension() {
        String name = getFileLeafRef();
        if (name == null) return null;
        if (name.contains("."))
            return name.substring(name.lastIndexOf(".") + 1);
        else
            return null;
    }

    public String getFileLeafRef() {
        if (attributes.containsKey("ows_FileLeafRef")) {
            JLookupValue lookup = attributes.get("ows_FileLeafRef").getValue();
            if (lookup == null)
                return null;
            else
                return lookup.getValue();
        } else {
            return null;
        }
    }

    public String getFileRef() {
        if (attributes.containsKey("ows_FileRef")) {
            JLookupValue lookup = attributes.get("ows_FileRef").getValue();
            if (lookup == null)
                return null;
            else
                return lookup.getValue();
        } else {
            return null;
        }
    }

    public String getUrl() {
        String path = getFileRef();
        if (path == null) {
            return null;
        } else {
            return getWeb().getUrl() + "/" + getFileRef();
        }
    }

    public String getDownloadUrl() {
        String url = getUrl();

        try {
            URL uri = new URL(url);
            url = url.substring(url.indexOf(uri.getHost()) + uri.getHost().length());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            url = String.format("%s/_layouts/download.aspx?SourceUrl=%s", web.getUrl(), URLEncoder.encode(url, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return url;
    }

    public String getIconPath() {
        String path = getFileRef();
        path = new File(path).getName();
        if (path.contains(".")) {
            return String.format("/_layouts/images/ic%s.gif", path.substring(path.lastIndexOf(".") + 1));
        } else {
            return "/_layouts/images/icgen.gif";
        }
    }

    public String getIconUrl() {
        String iconUrl = getIconPath();
        URL url;
        try {
            url = new URL(web.getUrl());
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        String port = "";
        if (url.getPort() != -1) {
            port = ":" + url.getPort();
        }
        return String.format("%s://%s%s%s", url.getProtocol(), url.getHost(), port, iconUrl);
    }
}
