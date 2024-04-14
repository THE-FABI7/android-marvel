package com.example.marvel.domain.model;

public class Welcome4 {
    private long code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private Data data;

    public long getCode() { return code; }
    public void setCode(long value) { this.code = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getCopyright() { return copyright; }
    public void setCopyright(String value) { this.copyright = value; }

    public String getAttributionText() { return attributionText; }
    public void setAttributionText(String value) { this.attributionText = value; }

    public String getAttributionHTML() { return attributionHTML; }
    public void setAttributionHTML(String value) { this.attributionHTML = value; }

    public String getEtag() { return etag; }
    public void setEtag(String value) { this.etag = value; }

    public Data getData() { return data; }
    public void setData(Data value) { this.data = value; }
}
