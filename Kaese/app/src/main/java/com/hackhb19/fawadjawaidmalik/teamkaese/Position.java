package com.hackhb19.fawadjawaidmalik.teamkaese;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Position implements Serializable {
    @SerializedName("groundPos")
    private String groundPos;
    @SerializedName("level")
    private String level;

    public Position(String groundPos, String level) {
        this.groundPos = groundPos;
        this.level = level;
    }

    public String getGroundPos() {
        return groundPos;
    }

    public void setGroundPos(String groundPos) {
        this.groundPos = groundPos;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
