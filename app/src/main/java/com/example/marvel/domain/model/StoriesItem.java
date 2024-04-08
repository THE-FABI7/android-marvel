package com.example.marvel.domain.model;

public class StoriesItem {
    private String resourceURI;
    private String name;
    private Type type;

    public String getResourceURI() { return resourceURI; }
    public void setResourceURI(String value) { this.resourceURI = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Type getType() { return type; }
    public void setType(Type value) { this.type = value; }
}
