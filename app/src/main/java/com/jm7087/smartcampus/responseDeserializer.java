package com.jm7087.smartcampus;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by JM7087-Notbook on 25/09/2017.
 */
class responseDeserializer implements JsonDeserializer<response> {
    @Override
    public response deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement resp = json.getAsJsonObject();
//        if(json.getAsJsonObject().get("response") != null){
//            locations = json.getAsJsonObject().get("response");
//        }
        return (new Gson().fromJson(resp, response.class));    }
}
