package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.util.Pair;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class ProductDeserializer implements JsonDeserializer<Product> {
    @Override
    public Product deserialize (JsonElement jElement, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jObject = jElement.getAsJsonObject();

        int id = jObject.get("id").getAsInt();
        String category = jObject.get("productCategory").getAsString();


        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(Position.class, new PositionDeserializer());

        Position pos = gsonBldr.create().fromJson(jObject.get("position").toString(), new TypeToken<Position>() { }.getType());


        String date = jObject.get("admissionDate").getAsString();
        String stage = jObject.get("productStage").getAsString();
        String desc = jObject.get("description").getAsString();
        boolean empty = jObject.get("isEmpty").getAsBoolean();


        return new Product(id, category,pos,date, stage, desc ,  empty);
    }
}
