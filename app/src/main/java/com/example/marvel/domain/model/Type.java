package com.example.marvel.domain.model;

import java.io.IOException;

public enum Type {
    COVER, INTERIOR_STORY;

    public String toValue() {
        switch (this) {
            case COVER: return "cover";
            case INTERIOR_STORY: return "interiorStory";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("cover")) return COVER;
        if (value.equals("interiorStory")) return INTERIOR_STORY;
        throw new IOException("Cannot deserialize Type");
    }
}
