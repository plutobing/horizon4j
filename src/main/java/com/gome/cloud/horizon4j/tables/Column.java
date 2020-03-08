package com.gome.cloud.horizon4j.tables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pluto on 1/11/16.
 */
public class Column {

    protected Table table;

    protected String name;

    protected String verbose_name;

    protected boolean empty_value;

    protected Map<String, String> attrs = new HashMap<String, String>(16);

    public Column(String name, String verbose_name, boolean empty_value, Map<String, String> attrs) {
        this.name = name;
        this.verbose_name = verbose_name;
        this.empty_value = empty_value;
        this.attrs = attrs;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public String getVerbose_name() {
        return verbose_name;
    }

    public boolean isEmpty_value() {
        return empty_value;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public String getAttrString() {
        return "";
    }

    public String toString() {
        return this.getVerbose_name();
    }

}
