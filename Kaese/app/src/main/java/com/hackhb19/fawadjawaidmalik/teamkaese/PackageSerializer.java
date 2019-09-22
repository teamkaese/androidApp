package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.text.method.DateTimeKeyListener;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.util.Calendar;

import java.lang.reflect.Type;

public class PackageSerializer implements JsonSerializer<GlobalVar> {
    public JsonElement serialize(final GlobalVar globvar, final Type type, final JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        JsonObject position = new JsonObject();

        result.add("id", new JsonPrimitive(GlobalVar.ITEM_ID));
        result.add("category", new JsonPrimitive(GlobalVar.Name));
        //position.add("groundPos", new Position(GlobalVar.position.getGroundPos(), GlobalVar.position.getLevel()));
        result.add("description", new JsonPrimitive(GlobalVar.Name));
        result.add("storageNumber", new JsonPrimitive(GlobalVar.StorageNumber));
        result.add("expirationDay", new JsonPrimitive(GlobalVar.ExpirationDay));
        result.add("admissionDate", new JsonPrimitive((Calendar.getInstance().getTime()).toString()));
        result.add("productStage", new JsonPrimitive(GlobalVar.Name));
        result.add("isEmpty", new JsonPrimitive(false));

        return result;
    }

}
