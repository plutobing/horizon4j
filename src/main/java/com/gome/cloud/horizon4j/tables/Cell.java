package com.gome.cloud.horizon4j.tables;

/**
 * Created by pluto on 1/11/16.
 */
public class Cell<T> {

    protected T _data;

    protected Column _column;

    public Cell(T data, Column column) {
        this._data = data;
        this._column = column;
    }

    public T get_data() {
        return _data;
    }

    public Column get_column() {
        return _column;
    }

}
