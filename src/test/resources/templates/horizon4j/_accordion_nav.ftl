<!--sidebar-menu-->
<ul class="sidebar-menu">
    {% for dashboard, panel_info in components %}
    {% if user|has_permissions:dashboard %}
    {% if dashboard.supports_tenants and request.user.authorized_tenants or not dashboard.supports_tenants %}
    <li class="treeview {% if current.slug == dashboard.slug %}active{% endif %}">
        <!--a href="pages/overview.html"-->
        {% if dashboard.check_as_alone_item %}
        <a href="{{ dashboard.get_absolute_url }}">
            <i class="fa fa-{{ dashboard.icon }}"></i>
            <span>{{ dashboard.name }}</span>
            <i class="fa fa-angle-left pull-right"></i>
            <span class="label bg-red pull-right">4</span>
        </a>
        {% else %}
        <a href="#">
            <i class="fa fa-{{ dashboard.icon }}"></i>
            <span>{{ dashboard.name }}</span>
            <i class="fa fa-angle-left pull-right"></i>
            <span class="label bg-red pull-right">4</span>
        </a>
        {% for heading, panels in panel_info.iteritems %}
        {% with panels|has_permissions_on_list:user as filtered_panels %}
        {% if filtered_panels %}
        {% if heading %}
        <div>
            <h4>
                <div>{{ heading }}</div>
            </h4>
            {% endif %}
            <ul class="treeview-menu">
                {% for panel in filtered_panels %}
                <li {% if current.slug == dashboard.slug and current_panel == panel.slug %}class="currentli"{% endif %}>
                    <a href="{{ panel.get_absolute_url }}"
                       tabindex="{{ forloop.counter }}"><i
                            class="fa fa-circle-o  more_fa"></i>{{ panel.name }}
                    </a>
                </li>
                {% endfor %}
            </ul>
            {% if heading %}
        </div>
        {% endif %}
        {% endif %}
        {% endwith %}
        {% endfor %}
        {% endif %}
    </li>
    {% endif %}
    {% endif %}
    {% endfor %}
</ul>
<!-- sidebar-menu end -->