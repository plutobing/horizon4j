<tr ${row.getAttrString}>
    <#list row.cells as cell>
        <#include "./_data_table_cell.ftl"/>
    </#list>
</tr>