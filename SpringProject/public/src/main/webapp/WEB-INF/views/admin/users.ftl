<#-- @ftlvariable name="users" type="java.util.List<mvc.common.UsersInfo>" -->
<#-- @ftlvariable name="errorMsg" type="java.lang.String" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>

    <title>Admin page</title>
    <script src="/resources/js/jquery-1.9.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/own/ajax.js"></script>

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/own/adminPage.css"/>
</head>
<body>

<div class="container">
    <div class="row">
    <#include "left-menu.ftl">
        <div class="col-md-9">
            <div class="info-block">
                <div class="content">
                    <p class="tittle">Book<span>Store</span> admin page</p>
                <#if errorMsg??>
                    <p style="color: red;font-size: 20px;text-align: center;">${errorMsg}</p>
                </#if>
                    <table class="order-table-css">
                        <tr>
                            <th>Login</th>
                            <th>Name</th>
                            <th>Role</th>
                            <th>Email</th>
                            <th>Activated</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    <#include "user.ftl">

                    <#list users as ord>
                        <@user user=ord/>
                    </#list>

                    </table>


                </div>
            </div>
        </div>
    </div>
</body>
</html>