<#-- @ftlvariable name="orders" type="java.util.List<mvc.common.OrdersInfo>" -->
<#-- @ftlvariable name="address" type="mvc.common.AddressInfo" -->
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
    <#include "left-menu.ftl">
        <div class="col-md-9">
            <div class="info-block">
                <div class="content">
                    <p class="tittle">Book<span>Store</span> cabinet page</p>
                                <span>
                                    <p class="user_info">Name : <@sec.authentication property="principal.name" /></p>
                                    <p class="user_info">Email : <@sec.authentication property="principal.username" /></p>
                                    <p class="user_info">Role : <@sec.authentication property="principal.role" /></p>
                                </span>

                <#if address??>
                <h3>Address information</h3>
                    <span class="address_info">
                                    <p class="address">Area : ${address.area}</p>
                                    <p class="address">City : ${address.city}</p>
                                    <p class="address">House : ${address.house}</p>
                                    <#if address.flat??>
                                    <p class="address">Flat : ${address.flat}</p>
                                    </#if>
                                    <p class="address">Street : ${address.street}</p>
                                    <p class="address">Post index : ${address.post_index}</p>
                                 </span>
                <#else>
                    <p>Address info is null. Please checkout for adding information about your address</p>
                </#if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>