package com.example.marvel.domain.model;

public class Comics {

    private long available;
    private String collectionURI;
    private ComicsItem[] items;
    private long returned;

    public long getAvailable() { return available; }
    public void setAvailable(long value) { this.available = value; }

    public String getCollectionURI() { return collectionURI; }
    public void setCollectionURI(String value) { this.collectionURI = value; }

    public ComicsItem[] getItems() { return items; }
    public void setItems(ComicsItem[] value) { this.items = value; }

    public long getReturned() { return returned; }
    public void setReturned(long value) { this.returned = value; }

}
