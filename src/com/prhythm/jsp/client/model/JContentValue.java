package com.prhythm.jsp.client.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by Bruce on 8/19/2014.
 */
public class JContentValue {

    final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    final static Pattern DATE_PATTERN = Pattern.compile("^\\d{8} \\d{2}:\\d{2}:\\d{2}$", Pattern.CASE_INSENSITIVE);
    final static Pattern UNIQUE_ID_PATTERN = Pattern.compile("^[{]?[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}[}]?$", Pattern.CASE_INSENSITIVE);
    final static Pattern DOUBLE_PATTERN = Pattern.compile("^\\d+\\.\\d+$", Pattern.CASE_INSENSITIVE);
    final static Pattern LONG_PATTERN = Pattern.compile("^\\d+$", Pattern.CASE_INSENSITIVE);
    Object value;
    Type type;

    public JContentValue(String value) {
        setValue(value);
    }

    public JContentValue(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public static boolean isBoolean(String value) {
        return "True".equalsIgnoreCase(value) || "False".equalsIgnoreCase(value);
    }

    public static boolean isDateTime(String value) {
        return DATE_PATTERN.matcher(value).find();
    }

    public static boolean isUniqueID(String value) {
        return UNIQUE_ID_PATTERN.matcher(value).find();
    }

    public static boolean isDouble(String value) {
        return DOUBLE_PATTERN.matcher(value).find();
    }

    public static boolean isLong(String value) {
        if (LONG_PATTERN.matcher(value).find()) {
            long v = Long.parseLong(value);
            return v > Integer.MAX_VALUE || v < Integer.MIN_VALUE;
        } else {
            return false;
        }
    }

    public static boolean isInteger(String value) {
        if (LONG_PATTERN.matcher(value).find()) {
            long v = Long.parseLong(value);
            return v <= Integer.MAX_VALUE || v >= Integer.MIN_VALUE;
        } else {
            return false;
        }
    }

    public <T> T getValue() {
        return (T) value;
    }

    public void setValue(String value) {
        if (isBoolean(value)) {
            this.value = Boolean.parseBoolean(value);
            this.type = Type.Boolean;
            return;
        }
        if (isDateTime(value)) {
            try {
                this.value = DATE_FORMAT.parse(value);
                this.type = Type.DateTime;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        if (isUniqueID(value)) {
            this.value = UUID.fromString(value.replace("{", "").replace("}", ""));
            this.type = Type.UniqueID;
            return;
        }
        if (isDouble(value)) {
            this.value = Double.parseDouble(value);
            this.type = Type.Double;
            return;
        }
        if (isLong(value)) {
            this.value = Long.parseLong(value);
            this.type = Type.Long;
            return;
        }
        if (isInteger(value)) {
            this.value = Integer.parseInt(value);
            this.type = Type.Integer;
            return;
        }
        JLookupValue lookup = JLookupValue.parse(value);
        if (lookup != null) {
            this.value = lookup;
            this.type = Type.Lookup;
            return;
        }

        this.value = value;
        this.type = Type.String;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", type, value);
    }

    public static enum Type {
        String, Boolean, DateTime, Integer, UniqueID, Long, Double, Lookup, LookupCollection
    }
}
