<!DOCTYPE html>
<html>
<head>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible' />
    <meta content='text/html; charset=utf-8' http-equiv='Content-Type' />
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <#include "horizon4j/_custom_meta.ftl"/>
    <title><@block name="title">This is project title.</@block></title>
    <@block name="css">
        <#include "_stylesheets.ftl"/>
    </@block>
    <#include "horizon4j/_conf.ftl"/>
    <#include "horizon4j/client_side/_script_loader.ftl"/>
    <#include "horizon4j/_custom_head_js.ftl"/>
</head>
<body class="<@block name="body-class">skin-blue</@block>">
<@block name="content">

<div class="wrapper">
    <@block name="header">
        <#include "_header.ftl"/>
    </@block>
    <@block name="sidebar">
        <!-- Left side column. contains the logo and sidebar -->
        <#include "horizon4j/commons/_sidebar.ftl"/>
    </@block>
    <!-- Content Wrapper. Contains page content  *********************************************************************************************-->
    <@block name="content_wrapper">
        <@block name="content_header">
            <!-- Content Header (Page header) -->
            <#include "horizon4j/commons/_content_header.ftl"/>
        </@block>
        <@block name="main"></@block>
    </@block>
    <footer class="main-footer">
    <@block name="footer">
        <#include "horizon4j/commons/_footer.ftl"/>
    </@block>
    </footer>
</div><!-- ./wrapper -->

</@block>

<@block name="modal_wrapper">
</@block>

<@block name="js">
    <#include "horizon4j/_scripts.ftl"/>
</@block>

</body>
</html>