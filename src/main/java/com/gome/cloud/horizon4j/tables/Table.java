package com.gome.cloud.horizon4j.tables;

import com.gome.cloud.horizon4j.Renderer;
import com.gome.cloud.horizon4j.actions.Action;
import com.gome.cloud.horizon4j.exceptions.RowInitializedException;
import com.gome.cloud.horizon4j.exceptions.TableInitializedException;
import com.gome.cloud.horizon4j.tables.metadata.TableMetadata;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pluto on 1/11/16.
 */
public abstract class Table<T> implements Renderer {

    protected List<Column> columns;

    protected List<Action> rowActions;

    protected List<Action> tableActions;

    protected TableMetadata metadata;

    protected boolean needsFormWrapper;

    protected String currentItemId = "";

    protected List<T> data;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected OutputStream output;

    public Table(List<T> T, HttpServletRequest request, boolean needsFormWrapper) {
        this.data = T;
        this.request = request;
        this.needsFormWrapper = needsFormWrapper;
        this.metadata = this.getClass().getAnnotation(TableMetadata.class);

        Field[] fields = this.getClass().getDeclaredFields();
        List<Column> sortedColumns = new LinkedList<Column>();
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(Column.class)) {
                String getterName = "get".concat(field.getName().substring(0, 1).
                        toUpperCase().concat(field.getName().substring(1)));
                try {
                    Method method = this.getClass().getDeclaredMethod(getterName,
                            new Class[]{});
                    Column column = (Column) method.invoke(this, null);
                    if (! sortedColumns.contains(column)) {
                        sortedColumns.add(column);
                    }
                    column.setTable(this);
                } catch (IllegalAccessException e) {
                    throw new TableInitializedException(this.getClass().getSimpleName() + " initialized error.", e);
                } catch (NoSuchMethodException e) {
                    throw new TableInitializedException(this.getClass().getSimpleName() + " initialized error.", e);
                } catch (InvocationTargetException e) {
                    throw new TableInitializedException(this.getClass().getSimpleName() + " initialized error.", e);
                }
            }
        }
        this.columns = sortedColumns;
    }

    public String getDisplayName() {
        return this.metadata.name();
    }

    public String getVerboseName() {
        return this.metadata.verbose_name();
    }

    public String getNoDataMessage() {
        return this.metadata.no_data_message();
    }

    public String getTemplate() {
        return this.metadata.template();
    }

    public List<Column> getColumns() {
         return this.columns;
    }

    public List<Row> getRows() {
        final List<Row> rows = new LinkedList<Row>();
        if (! this.hasNoData()) {
            Row row = null;
            for (T t : this.data) {
                try {
                    row = new Row(t, this);
                    rows.add(row);
                } catch (IllegalAccessException e) {
                    throw new RowInitializedException("The row initialized error.", e);
                }
            }
        }
        return rows;
    }

    public boolean hasNoData() {
        boolean hasNoData = true;
        if (data != null && data.size() != 0) {
            hasNoData = false;
        }
        return hasNoData;
    }

    public boolean isBrowserTable() {
        return this.metadata.is_browser_table();
    }

    public void renderTableActions() {
        return ;
    }

    public void render() {

    }

}
