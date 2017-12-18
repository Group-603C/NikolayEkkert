package com.company;

import com.company.options.JsonConvertOptions;
import com.company.types.JObject;

public interface IJsonConvert {

    String serializeObject(Object obj);

    String serializeObject(Object obj, JsonConvertOptions options);

    JObject deserialize(String data);

    <TResult> TResult deserializeTyped(String data);
}
