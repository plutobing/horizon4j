<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <!--区域-->
        <div class="area-distribution">
            <div class="area_change">
                <a href="javascript:void(0)" class="current-area">
                    <span>广东1区</span>
                    <i class="right_arrow"></i>
                </a>
                <ul class="area-select" style="display: none;">
                    <li><a data-value="pek2">
                        <span class="label-unchecked"></span>北京2区
                        <span class="en">(PEK2)</span>
                        <span class="zone-label zone-label-0"></span>
                    </a></li>
                    <li>
                        <a data-value="gd1">
                            <span class="label-current"></span>广东1区
                            <span class="en">(GD1)</span>
                            <span class="zone-label zone-label-1"></span>
                        </a>
                    </li>
                    <li>
                        <a data-value="ap1">
                            <span class="label-unchecked"></span>亚太1区
                            <span class="en">(AP1)</span>
                            <span class="zone-label zone-label-2"></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div><!--area end-->

        <!--菜单栏-->
        <ul class="sidebar-menu">
            <li class="treeview active">
                <a href="#">
                    <i class="fa fa-dashboard"></i>
                    <span>基础数据</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="currentli"><a href="dcManage.html">DC管理</a></li>
                    <li ><a href="rackManage.html">机架管理</a></li>
                    <li ><a href="projectManage.html">项目管理</a></li>
                </ul>
            </li>
            <li class=" treeview ">
                <a href="#">
                    <i class="fa fa-openid"></i>
                    <span>资源规划</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="agentConfig.html">agent采集配置</a> </li>
                    <li class=""><a href="physicalResourcePlan.html">物理资源规划</a></li>
                    <li ><a href="systemResource.html">系统规划</a></li>
                    <li ><a href="installPlan.html">装机规划</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cubes"></i>
                    <span>计算资源管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li ><a href="#">物理计算资源管理</a></li>
                    <li ><a href="#">虚拟计算资源管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-share-alt"></i>
                    <span>流程管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="pages/alarms.html">资源申请</a></li>
                    <li><a href="pages/operationLog.html">申请管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-object-group"></i>
                    <span>节点管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="pages/nodeManage.html">节点部署</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-sellsy"></i>
                    <span>系统功能</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="pages/nodeManage.html">用户管理</a></li>
                    <li><a href="pages/nodeManage.html">权限管理</a></li>
                    <li><a href="pages/nodeManage.html">资源维护</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->

    <!--用户管理模块-->
    <div class="user-fold">
        <div class="user-fold-first">
            <span class="fold-line"></span>
            <p>超级管理员</p>
            <ul class="user-fold-list">
                <li>
                    <i class=" fa fa-envelope-o"></i><strong>29</strong>

                </li>
                <li>
                    <i class=" fa fa-bell-o"></i><strong>17</strong>
                </li>
            </ul>
        </div>
        <div class="user-opeater" style="display:none">
            <ul>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
    <!--用户管理模块 end-->
</aside>