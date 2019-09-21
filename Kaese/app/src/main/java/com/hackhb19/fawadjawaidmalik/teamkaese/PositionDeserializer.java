package com.hackhb19.fawadjawaidmalik.teamkaese;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class PositionDeserializer implements JsonDeserializer<Position> {
    @Override
    public Position deserialize (JsonElement jElement, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jObject = jElement.getAsJsonObject();
        String groundPos = jObject.get("groundPos").getAsString();
        String level = String.valueOf(jObject.get("level").getAsInt());

        return new Position(groundPos, level );
    }
}
