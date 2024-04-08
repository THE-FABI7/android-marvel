package com.example.marvel.domain.model;


public class Root {
    private long id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Comics comics;
    private Comics series;
    private Stories stories;
    private Comics events;
    private URL[] urls;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getModified() { return modified; }
    public void setModified(String value) { this.modified = value; }

    public Thumbnail getThumbnail() { return thumbnail; }
    public void setThumbnail(Thumbnail value) { this.thumbnail = value; }

    public String getResourceURI() { return resourceURI; }
    public void setResourceURI(String value) { this.resourceURI = value; }

    public Comics getComics() { return comics; }
    public void setComics(Comics value) { this.comics = value; }

    public Comics getSeries() { return series; }
    public void setSeries(Comics value) { this.series = value; }

    public Stories getStories() { return stories; }
    public void setStories(Stories value) { this.stories = value; }

    public Comics getEvents() { return events; }
    public void setEvents(Comics value) { this.events = value; }

    public URL[] getUrls() { return urls; }
    public void setUrls(URL[] value) { this.urls = value; }
}
