package com.hackhb19.fawadjawaidmalik.teamkaese;

import java.io.Serializable;

public class Position implements Serializable {
    private String groundPos;
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
