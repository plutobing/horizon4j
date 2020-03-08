package com.gome.cloud.horizon4j.tables;

import com.gome.cloud.horizon4j.Renderer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pluto on 1/11/16.
 */
public class Row<T> implements Renderer {

    protected T _data;

    protected Map<String, Column> _columns = new HashMap<String, Column>(16);

    protected List<Cell> cells;

    protected Map<String, String> _attrs = new HashMap<String, String>(16);

    protected Table table;

    protected String template = "horizon4j/commons/_data_table_row.ftl";

    public T getData() {
        return this._data;
    }

    public Row(T t, Table table) throws IllegalAccessException {
        this._data = t;

        Iterator<Column> iter = this.table.getColumns().iterator();
        Column column = null;
        while (iter.hasNext()) {
            column = iter.next();
            this._columns.put(column.getName(), column);
        }

        if (Map.class.isInstance(this._data)) {

        } else {
            final Field[] fields = this._data.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(this._data);
                        Cell cell = new Cell(value, this._columns.get(field.getName()));
                        this.cells.add(cell);
                    } finally {
                        field.setAccessible(false);
                    }
                }
            }
        }

        this.table = table;
    }

    public String getAttrString() {
        StringBuffer buffer = new StringBuffer(16);
        Iterator<Map.Entry<String, String>> iter = this._attrs.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            buffer.append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
            buffer.append(" ");
        }

        return buffer.toString();
    }

    public String getTemplate() {
        return this.template;
    }

    public void render() {
    }

}
