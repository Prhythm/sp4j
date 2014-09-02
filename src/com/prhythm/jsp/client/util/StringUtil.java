package com.prhythm.jsp.client.util;

/**
 * Created by Bruce on 8/18/2014.
 */
public final class StringUtil {

    public static String removeHtmlTag(String html) {
        return html.replaceAll("<[^>]*>", "");
    }

    public static String escapeXml(String str) {
        if (str == null || str.length() == 0) return str;
        return str.replaceAll("[\"]", "&quot;")
                .replaceAll("[']", "&apos;")
                .replaceAll("[<]", "&lt;")
                .replaceAll("[>]", "&gt;")
                .replaceAll("[&]", "&amp;");
    }

    public static String makeSpaceOfUpperCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] words = str.toCharArray();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (Character.isUpperCase(words[i])) {
                if (i + 1 < words.length && Character.isLowerCase(words[i + 1]))
                    out.append(" ");
            }
            out.append(words[i]);
        }
        return out.charAt(0) == ' ' ? out.substring(1) : out.toString();
    }
}
