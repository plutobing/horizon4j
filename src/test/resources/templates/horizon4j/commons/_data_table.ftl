<section class="content">
    <div class="toolbar">
        ${table.renderTableActions()}
    </div>
    <@block name="table">
        <table class="table_data" cellpadding="0" cellspacing="0">
            <thead>
            <@block name="table_columns">
                <#if (!table.isBrowserTable())>
                    <tr>
                        <#list table.getColumns() as column>
                            <th ${column.getAttrString()}>${column}</th>
                        </#list>
                    </tr>
                </#if>
            </@block>
            </thead>
            <@block name="table_body">
                <tbody>
                    <#if table.hasNoData()>
                    <tr class="">
                        <td colspan="${table.getColumns()?size}">${table.getNoDataMessage()}</td>
                    </tr>
                    <#else>
                        <#list table.getRows() as row>
                            ${row.render}
                        </#list>
                    </#if>
                </tbody>
            </@block>
            <@block name="table_footer">
                <tfoot>
                </tfoot>
            </@block>
        </table>
    </@block>
</section>