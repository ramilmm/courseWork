<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#-- @ftlvariable name="deal" type="mvc.common.GoodInfo"-->
<#-- @ftlvariable name="bestSeller" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="newArrival" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="usedBook" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="exclusive" type="java.util.List<mvc.common.GoodInfo>" -->
<#--@ftlvariable name="user" type="mvc.common.UsersInfo"-->

<#include "../template/template.ftl">
<@mainTemplate title="BookStore" styles=["css/own/home_page.css", "css/ion.rangeSlider.css", "css/ion.rangeSlider.skinHTML5.css"]/>
<#macro m_body>
<#include "../template/components/headerCategoryList.ftl" />
<div class="slider">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div id="carousel" class="carousel">
                    <div> <img src="/resources/images/carousel/carousel2.jpg"></div>
                    <div><img src="/resources/images/carousel/carousel1.jpg" ></div>
                </div>

            </div>
            <div class="col-md-3">
                <div class="deal_of_the_Month simpleCart_shelfItem">
                    <h1>Deal of the Month</h1>
                        <h5 class="item_name">${deal.name}</h5>
                        <a href="/good/${deal.id}" class="img-btn"><img src="${deal.image}"></a>
                        <h3 id="price item_price">$${deal.cost}</h3>
                        <a href="/cart/add" class="buy-btn js_addToCart item_add">Buy now</a>
                </div>
            </div>
        </div>
    </div>
</div>
    <#include "../template/components/left-menu.ftl" />
<div class="container">
    <div class="row">
<div class="col-md-9">
    <div class="tabs">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tab-1" data-toggle="tab">Best sellers</a></li>
            <li><a href="#tab-2" data-toggle="tab">New arrivals</a></li>
            <li><a href="#tab-3" data-toggle="tab">Used Books</a></li>
            <li><a href="#tab-4" data-toggle="tab">Exclusive</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade in active" id="tab-1">
                <div class="row">
                    <div class="good_list">
                        <#list bestSeller as good>
                            <div class="good_item simpleCart_shelfItem">
                            <a href="/good/${good.id}"><img src="${good.image}"></a>
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
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-2">
                <div class="container">
                    <div class="row">
                        <div class="good_list">
                            <#list newArrival as good>
                                <div class="good_item simpleCart_shelfItem">
                                    <a href="/good/${good.id}"><img src="${good.image}"></a>
                                    <h4 class="item_name">${good.name}</h4>
                                    <h5>${good.author}</h5>
                                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                                        <a class="buy_btn item_add" style="background: rgb(280, 124, 83)" href="/cart">Go in cart</a>
                                        <span class="item_price" style="border: 3px solid #ff7c53">$${good.cost}</span>
                                    <#else>
                                        <a href="/cart/add" class="buy_btn js_addToCart item_add" data-id="${good.id}">Buy</a>
                                        <span class="item_price">$${good.cost}</span>
                                    </#if>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-3">
                <div class="container">
                    <div class="row">
                        <div class="good_list">
                            <#list usedBook as good>
                                <div class="good_item simpleCart_shelfItem">
                                    <a href="/good/${good.id}"><img src="${good.image}"></a>
                                    <h4 class="item_name">${good.name}</h4>
                                    <h5>${good.author}</h5>
                                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                                        <a class="buy_btn item_add" style="background: rgb(280, 124, 83)" href="/cart">Go in cart</a>
                                        <span class="item_price" style="border: 3px solid #ff7c53">$${good.cost}</span>
                                    <#else>
                                        <a href="/cart/add" class="buy_btn js_addToCart item_add" data-id="${good.id}">Buy</a>
                                        <span class="item_price">$${good.cost}</span>
                                    </#if>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-4">
                <div class="container">
                    <div class="row">
                        <div class="good_list">
                            <#list exclusive as good>
                                <div class="good_item simpleCart_shelfItem">
                                    <a href="/good/${good.id}"><img src="${good.image}"></a>
                                    <h4 class="item_name">${good.name}</h4>
                                    <h5>${good.author}</h5>
                                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                                        <a class="buy_btn item_add" style="background: rgb(280, 124, 83)" href="/cart">Go in cart</a>
                                        <span class="item_price" style="border: 3px solid #ff7c53">$${good.cost}</span>
                                    <#else>
                                        <a href="/cart/add" class="buy_btn js_addToCart item_add" data-id="${good.id}">Buy</a>
                                        <span class="item_price">$${good.cost}</span>
                                    </#if>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    </div>
</div>
</#macro>