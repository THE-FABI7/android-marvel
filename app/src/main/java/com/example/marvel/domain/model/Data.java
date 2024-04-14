package com.example.marvel.domain.model;

public class Data {
    private long offset;
    private long limit;
    private long total;
    private long count;
    private Result[] results;

    public long getOffset() { return offset; }
    public void setOffset(long value) { this.offset = value; }

    public long getLimit() { return limit; }
    public void setLimit(long value) { this.limit = value; }

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public Result[] getResults() { return results; }
    public void setResults(Result[] value) { this.results = value; }

}
