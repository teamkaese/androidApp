package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.util.Pair;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ProductDeserializer implements JsonDeserializer<Product> {
    @Override
    public Product deserialize (JsonElement jElement, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jObject = jElement.getAsJsonObject();
        int id = jObject.get("id").getAsInt();
        String category = jObject.get("productCategory").getAsString();
        String groundPos = jObject.get("position").getAsJsonObject().get("groundPos").getAsString();
        String level = jObject.get("position").getAsJsonObject().get("level").getAsString();
        String date = jObject.get("admissionDate").getAsString();
        String stage = jObject.get("productStage").getAsString();
        return new Product(id, category,groundPos,level,date, stage );
    }
}
