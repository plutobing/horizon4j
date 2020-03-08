package com.gome.cloud.horizon4j.tables.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pluto on 1/11/16.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableMetadata {

    String name();

    String verbose_name();

    Class[] table_actions() default {};

    Class[] row_actions() default {};

    boolean multi_select() default false;

    boolean is_browser_table() default false;

    String template() default "horizon4j/commons/_data_table.ftl";

    String pagination_param();

    String[] status_columns() default {};

    String[] css_classes();

    boolean footer() default true;

    String[] permissions();

    String no_data_message() default "";

}