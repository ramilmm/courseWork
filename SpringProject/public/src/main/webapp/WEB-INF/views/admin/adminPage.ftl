<#-- @ftlvariable name="good_list" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="category_list" type="java.util.List<mvc.common.CategoryInfo>" -->
<#-- @ftlvariable name="errorMsg" type="java.lang.String" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>

    <title>Admin page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script src="/resources/js/bootstrap.min.js"></script>

    <script src="/resources/js/jquery-1.9.1.min.js"></script>
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
                        <li>Show all goods</li>
                        <li>Show all users</li>
                        <li>Show all orders</li>
                        <li><a href="/">Go to home page</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="info-block">
                <div class="content">
                    <p class="tittle">Book<span>Store</span> admin page</p>
                    <#if errorMsg??>
                        <p style="color: red;font-size: 20px;text-align: center;">${errorMsg}</p>
                    </#if>
                    <div class="sales">
                        <form action="/admin/sale/add" method="POST">
                            <label for="Goods">К товару </label>
                            <select name="Goods" id="goods" required>
                                <#list good_list as good>
                                    <option value="${good.name}">${good.name}</option>
                                </#list>
                            </select>
                            <label for="discount"> добавляем скидку в </label>
                            <input type="number" name="discount" placeholder="40">%
                            <input type="submit" value="Добавить" />
                            <input type="hidden" name="username" value="<@sec.authentication property="principal.username"/>">
                        </form>
                        <hr>
                        <form action="/admin/sale/addToCategory" method="POST">
                            <label for="Categories">К категории </label>
                            <select name="Categories" id="categories" required>
                                <#list category_list as category>
                                    <option value="${category.name}">${category.name}</option>
                                </#list>
                            </select>
                            <label for="discount"> добавляем скидку в </label>
                            <input type="number" name="discount" placeholder="40">%
                            <input type="submit" value="Добавить"/>
                            <input type="hidden" name="username" value="<@sec.authentication property="principal.username"/>">
                        </form>
                    </div>
                    <span class="star-text">*Скидка не может превышать 100%</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>