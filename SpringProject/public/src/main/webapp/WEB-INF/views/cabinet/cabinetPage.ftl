<#-- @ftlvariable name="orders" type="java.util.List<mvc.common.OrdersInfo>" -->
<#-- @ftlvariable name="errorMsg" type="java.lang.String" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>

    <title>Cabinet page</title>
    <script src="/resources/js/jquery-1.9.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/own/ajax.js"></script>


    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/own/cabinet.css"/>
    <link rel="stylesheet" href="/resources/css/own/adminPage.css"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="admin-info">
                <div class="profile-img">
                    <img src="/resources/images/admin.png" class="img-circle">
                </div>
                <div class="profile-name">
                    <p class="admin-name"><@sec.authentication property="principal.name" /></p>
                    <ul class="admin-menu">
                        <li><a href="#">Edit profile</a></li>
                        <li><a href="/">Go to home page</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="info-block">
                <div class="content">
                    <p class="tittle">Book<span>Store</span> cabinet page</p>
                <#if errorMsg??>
                    <p style="color: red;font-size: 20px;text-align: center;">${errorMsg}</p>
                </#if>
                    <p class="table-title-css">Your orders</p>
                    <div class="orders">
                        <table class="order-table-css">
                            <tr>
                                <th>Date</th>
                                <th>Status</th>
                                <th>Pay type</th>
                                <th>Total count</th>
                                <th>Total sum</th>
                                <th>Delete</th>
                            </tr>
                        <#include "order.ftl">
                        <#list orders as ord>
                            <#if ord??>
                                <@order order=ord/>
                            <#else >
                                <p class="no-orders">Your don`t have orders</p>
                            </#if>

                        </#list>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>