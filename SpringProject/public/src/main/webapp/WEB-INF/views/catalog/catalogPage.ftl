<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#-- @ftlvariable name="goods" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="category" type="mvc.common.CategoryInfo" -->
<#--@ftlvariable name="Menu" type="java.util.List<mvc.common.CategoryInfo>-->
<#include "../template/template.ftl">
<@mainTemplate title="Catalog" styles=["css/own/catalog.css"]/>
<#macro m_body>
<#include "../template/components/headerCategoryList.ftl" />
<#include "../template/components/left-menu.ftl" />
<div class="col-md-9">
    <div class="tabs">
        <div class="good_list">
            <h1>${category.name}</h1>
            <#if goods?has_content>
            <#list goods as good>
                <div class="good_item simpleCart_shelfItem">
                    <a href="/good/${good.id}"><img src="${good.image}" alt="${good.name}"></a>
                    <h4 class="item_name">${good.name}</h4>
                    <h5>${good.author}</h5>
                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                        <a class="buy_btn" style="background: rgb(280, 124, 83)" href="/cart">Go in cart</a>
                        <span class="item_price" style="border: 3px solid #ff7c53">${good.cost}</span>
                    <#else>
                        <a href="/cart/add" class="buy_btn js_addToCart item_add" data-id="${good.id}">Buy</a>
                        <span class="item_price">$${good.cost}</span>
                    </#if>
                </div>
            </#list>
            <#else>
            <h4 style="text-align: center; color: #2b2b2b; margin-top: 200px">Извините , в этой категории пока нет книг...</h4>
            </#if>
        </div>
    </div>
</div>
</#macro>