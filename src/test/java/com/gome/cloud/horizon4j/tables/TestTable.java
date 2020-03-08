package com.gome.cloud.horizon4j.tables;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import com.gome.cloud.horizon4j.tables.metadata.TableMetadata;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pluto on 5/31/16.
 */
@TableMetadata(name = "TestTable",
        verbose_name = "TestTable",
        table_actions = {},
        row_actions = {},
        pagination_param = "",
        status_columns = {},
        css_classes = {},
        permissions = {})
public class TestTable<T> extends Table<T> {

    static Column id = new Column("id", "ID", false, null);

    static Column name = new Column("name", "Name", true, null);

    public TestTable(List<T> T, HttpServletRequest request, boolean needsFormWrapper) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        super(T, request, needsFormWrapper);
    }

    public Column getId() {
        return id;
    }

    public Column getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        TestTable table = new TestTable(null, null, false);
        Iterator<Column> iter = table.getColumns().iterator();
        while (iter.hasNext()) {
            Column column = iter.next();
            System.out.println("=================" + column.getName());
            System.out.println(column.getTable().getClass().getName());
        }
        System.out.println(table.getDisplayName());
        System.out.println(table.getNoDataMessage());
        System.out.println(table.getTemplate());
        System.out.println(table.getVerboseName());

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setTemplateLoader(new ClassTemplateLoader(TestTable.class.getClassLoader(), "templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setSharedVariable("block", new BlockDirective());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        Template temp = cfg.getTemplate(table.getTemplate());

        Writer out = new OutputStreamWriter(System.out);
        Map<String, Object> root = new HashMap<String, Object>(16);
        root.put("table", table);
        temp.process(root, out);
    }
}