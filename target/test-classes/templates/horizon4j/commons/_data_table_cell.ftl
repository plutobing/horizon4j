<#if cell.inline_edit_mod && cell.update_allowed>
<td${cell.getAttrString}>
<div class="table_cell_wrapper">
    <div class="inline-edit-error"> </div>
    <div class="inline-edit-form">
        {{ cell.value }}
        {% if cell.column.form_field.label %}
        <label class="inline-edit-label" for="{{ cell.id }}">{{ cell.column.form_field.label }}</label>
        {% endif %}
    </div>
    <div class="inline-edit-actions">
        <button class="inline-edit-submit btn btn-primary btn-xs pull-right"
                name="action" value="" type="submit">
            <span class="glyphicon glyphicon-ok"></span>
        </button>
        <button class="inline-edit-cancel btn btn-default btn-xs pull-right secondary cancel">
            <span class="glyphicon glyphicon-remove"></span>
        </button>
    </div>
    <div class="inline-edit-status inline-edit-mod"></div>
</div>
</td>
<#else>
<#if cell.inline_edit_available && cell.update_allowed>
<td{{ cell.attr_string|safe }}>
<div class="table_cell_wrapper">
    <div class="table_cell_data_wrapper">
        {%if cell.wrap_list %}<ul>{% endif %}{{ cell.value }}{%if cell.wrap_list %}</ul>{% endif %}
    </div>
    <div class="table_cell_action">
        <button class="ajax-inline-edit"><span class="glyphicon glyphicon-pencil"></span></button>
    </div>
    <div class="inline-edit-status"></div>
</div>
</td>
<#else>
<td${ cell.getAttrString}>
    <#if cell.wrap_list>
        <ul>
    </#if>
        ${cell.value }
    <#if cell.wrap_list>
        </ul>
    </#if>
</td>
</#if>
</#if>