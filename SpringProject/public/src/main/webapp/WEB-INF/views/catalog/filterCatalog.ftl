<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#-- @ftlvariable name="goods" type="java.util.List<mvc.common.GoodInfo>" -->
<#include "../template/template.ftl">
<@mainTemplate title="Catalog" styles=["css/own/catalog.css"] scripts=["js/own/ajax.js"]/>
<#macro m_body>
<#include "../template/components/headerCategoryList.ftl" />
<#include "../template/components/left-menu.ftl" />
<div class="col-md-9">
    <div class="tabs">
        <div class="good_list">
            <h1>Результаты подбора книг</h1>
            <#if goods?has_content>
            <#list goods as good>
                <div class="good_item simpleCart_shelfItem">
                    <a href="/good/${good.id}"><img src="${good.image}" alt="${good.name}"></a>
                    <h4 class="item_name">${good.name}</h4>
                    <h5>${good.author}</h5>

                        <a href="/cart/add" class="buy_btn js_addToCart item_add"
                           data-id="${good.id}">Buy</a>
                        <#if (good.discount != 1)>
                            <span class="js_addToCart item_add item_price-css"
                                  style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                <b class="item_price">$${(good.cost*good.discount)?int}</b></span>
                        <#else>
                            <span class="item_price item_price-css">$${good.cost}</span>
                        </#if>


                </div>
            </#list>
            <#else>
            <h4 style="text-align: center; color: #2b2b2b; margin-top: 200px">Извините , по вашему запросу книг не нашлось.</h4>
            </#if>
        </div>
    </div>
</div>
</#macro>