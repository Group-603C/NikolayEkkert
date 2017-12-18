package com.company;

/*
 * annotations - https://beginnersbook.com/2014/09/java-annotations/
 *             - http://tutorials.jenkov.com/java/annotations.html
 * json syntax - https://www.w3schools.com/js/js_json_syntax.asp
 * json parser - http://json.parser.online.fr/
 * data format - 2017-12-17T13:08:07Z
 *
 *
 */

import com.company.annotations.JsonIgnore;
import com.company.annotations.PropertyName;
import com.company.options.JsonConvertOptions;
import com.company.options.LineBreaks;
import com.company.types.JObject;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class JsonConvert implements IJsonConvert {

    public JsonConvert() {
    }

    @Override
    public String serializeObject(Object obj) {
        return this.serializeObject(obj, new JsonConvertOptions());
    }

    @Override
    public String serializeObject(Object obj, JsonConvertOptions options) {
        return serializeObject(obj, options, "");
    }

    private String serializeObject(Object obj, JsonConvertOptions options, String offset) {

        StringBuilder result = new StringBuilder();

        if (null == obj) {
            result.append("null");

        }
        else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) ||
                 (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Boolean)) {
            result.append(String.valueOf(obj));

        }
        else if ((obj instanceof Character) || (obj instanceof String)) {
            result.append("\"" + String.valueOf(obj) + "\"");

        }
        else if (obj instanceof Date) {
            Date date = (Date) obj;
            TimeZone utc = TimeZone.getTimeZone("UTC");
            SimpleDateFormat formatter = buildDateFormatter();
            formatter.setTimeZone(utc);
            result.append("\"" + formatter.format(date) + "\"");

        }
        else if (obj instanceof Map<?, ?>) {
            String map = serializeMap((Map<?, ?>) obj, options, offset);
            result.append(map);

        }
        else if (obj instanceof Iterable<?>) {
            String range = serializeIterable((Iterable<?>) obj, options, offset);
            result.append(range);

        }
        else {
            String object = serializeComplex(obj, options, offset);
            result.append(object);
        }

        return result.toString();
    }

    private String serializeMap(Map<?, ?> map, JsonConvertOptions options, String offset) {

        StringBuilder result = new StringBuilder();
        result.append("{");

        String newOffset = increment(offset);
        boolean hasElements = false;
        for (Object key : map.keySet()) {

            Object value = map.get(key);
            if (hasElements) {
                result.append(",");
            }

            addLineBreak(result, options);
            hasElements = true;

            //Check key for serialize
            result.append(
                    newOffset + "\"" + String.valueOf(key) + "\"" + ":" + serializeObject(value, options, newOffset));
        }

        if (hasElements) {
            addLineBreak(result, options);
            result.append(offset);
        }

        result.append("}");
        return result.toString();
    }

    private String serializeIterable(Iterable<?> range, JsonConvertOptions options, String offset) {

        StringBuilder result = new StringBuilder();
        result.append("[");

        String newOffset = increment(offset);
        boolean hasElements = false;
        for (Object element : range) {
            if (hasElements) {
                result.append(",");
            }

            addLineBreak(result, options);
            hasElements = true;

            result.append(newOffset);
            result.append(serializeObject(element, options, newOffset));
        }

        if (hasElements) {
            addLineBreak(result, options);
            result.append(offset);
        }

        result.append("]");
        return result.toString();
    }

    private String serializeComplex(Object object, JsonConvertOptions options, String offset) {

        Map<String, Object> collectedFields = new HashMap<>();
        Class<?> type = object.getClass();
        for (Field field : type.getFields()) {

            JsonIgnore ignore = field.getAnnotation(JsonIgnore.class);
            if (null != ignore) {
                continue;
            }

            String name = field.getName();
            PropertyName nameAnnotation = field.getAnnotation(PropertyName.class);
            if (null != nameAnnotation && !nameAnnotation.value().equals("")) {
                name = nameAnnotation.value();
            }

            try {
                collectedFields.put(name, field.get(object));
            }
            catch (Throwable t) {
            }
        }

        return serializeMap(collectedFields, options, offset);
    }

    private SimpleDateFormat buildDateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    private void addLineBreak(StringBuilder builder, JsonConvertOptions options) {

        if (options.lineBreaks == LineBreaks.Enable) {
            builder.append(System.lineSeparator());
        }
    }

    private String increment(String offset) {
        return offset + "    ";
    }


    @Override
    public JObject deserialize(String data) {
        return null;
    }

    @Override
    public <TResult> TResult deserializeTyped(String data) {
        return null;
    }
}
