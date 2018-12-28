package com.jacob.learn.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IniProps {
    public static final String defaultSection = "global";
    private static final String erasedKey = "x";
    private final static Pattern _section  = Pattern.compile("\\s*\\[([^]]*)\\]\\s*");
    private final static Pattern _keyValue = Pattern.compile("\\s*([^=]*)=(.*)");

    public static void load(String content, Map<String, Map<String, String>> _entries) {
        String[] lines = content.split(IOUtils.LINE_SEPARATOR);

        String section = null;
        for (String line : lines) {
            Matcher m = _section.matcher(line);
            if (m.matches()) {
                section = m.group(1).trim();
            } else if (section == null && _keyValue.matcher(line).matches()) {
                section = defaultSection;
            }

            if (section != null) {
                m = _keyValue.matcher(line);
                if (m.matches()) {
                    String key = m.group(1).trim();
                    String value = m.group(2).trim();
                    Map<String, String> kv = _entries.get(section);
                    if (kv == null) {
                        _entries.put(section, kv = new LinkedHashMap<>());
                    }
                    kv.put(key, value);
                }
            }
        }
    }

    public static String iniContent(Map<String, Map<String, String>> srcMap) {
        StringBuilder sb = new StringBuilder("");
        srcMap.forEach((k, v) -> {
            if (!defaultSection.equalsIgnoreCase(k)) {
                sb.append(IOUtils.LINE_SEPARATOR).append(IOUtils.LINE_SEPARATOR);
                sb.append("[").append(k).append("]").append(IOUtils.LINE_SEPARATOR);
            }
            v.forEach((k1, v1) -> {
                if (StringUtils.isNotBlank(v1) && !v1.startsWith(erasedKey)) {
                    sb.append(k1).append(" = ").append(v1).append(IOUtils.LINE_SEPARATOR);
                }
            });
        });
        return sb.toString();
    }
}
