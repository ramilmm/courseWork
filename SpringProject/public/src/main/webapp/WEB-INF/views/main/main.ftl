<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#-- @ftlvariable name="deal" type="mvc.common.GoodInfo"-->
<#-- @ftlvariable name="recommendations" type="java.util.List<mvc.common.GoodInfo>"-->
<#-- @ftlvariable name="bestSeller" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="newArrival" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="usedBook" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="exclusive" type="java.util.List<mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="user" type="mvc.common.UsersInfo"-->

<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../template/template.ftl">
<@mainTemplate title="BookStore" styles=["css/own/home_page.css", "css/ion.rangeSlider.css", "css/ion.rangeSlider.skinHTML5.css"]/>
<#macro m_body>
    <#include "../template/components/headerCategoryList.ftl" />
<div class="slider">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div id="carousel" class="carousel">
                    <div><img src="/resources/images/carousel/carousel2.jpg"></div>
                    <div><img src="/resources/images/carousel/carousel1.jpg"></div>
                </div>

            </div>
            <div class="col-md-3">
                <div class="deal_of_the_Month simpleCart_shelfItem">
                    <h1>Deal of the Month</h1>
                    <h5 class="item_name">${deal.name}</h5>
                    <a href="/good/${deal.id}" class="img-btn"><img src="${deal.image}"></a>
                    <h3 id="price item_price-css">$${deal.cost*deal.discount}</h3>
                    <a href="/cart/add" class="buy-btn js_addToCart item_add">Buy now</a>
                </div>
            </div>
            <@sec.authorize access="isAuthenticated()">
                <#if recommendations??>
                    <div class="col-md-12">
                        <div class="recommendations">
                            <h1>Dear <@sec.authentication property="principal.name" /> , we recommend you to read this
                                books</h1>
                            <ul>
                                <#list recommendations as rec>
                                    <li>
                                        <div class="recommendation simpleCart_shelfItem">
                                        <span class="descr">
                                        <p class="right_text name"><p class="item_name"><a href="/good/${rec.id}"
                                                                                           class="book_name">${rec.name}</a></p><br>
                                            <a href="/good/${rec.id}"><span class="author">${rec.author}</span></a><br>
                                            <a href="/good/${rec.id}"><span
                                                    class="cost item_price">$${(rec.cost*rec.discount)%1}</span></a>
                                            </p>
                                            <a href="/cart/add" class="rec-buy-btn js_addToCart item_add">Buy</a>
                                    </span>
                                            <a href="/good/${rec.id}" class="img-btn"><img
                                                    src="${rec.image}"></a>
                                        </div>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </#if>
            </@sec.authorize>

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
                                            <a class="buy_btn" style="background: rgb(280, 124, 83)" href="/cart">Go in
                                                cart</a>
                                            <span class="item_price item_price-css"
                                                  style="border: 3px solid #ff7c53">${good.cost}</span>
                                        <#else>
                                            <a href="/cart/add" class="buy_btn js_addToCart item_add"
                                               data-id="${good.id}">Buy</a>
                                            <#if (good.discount != 1)>
                                                <span class="js_addToCart item_add item_price-css"
                                                      style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                                <b class="item_price">$${(good.cost*good.discount)?int}</b></span>
                                            <#else>
                                                <span class="item_price item_price-css">$${good.cost}</span>
                                            </#if>
                                        </#if>
                                        <#if (good.discount!=1)>
                                            <img src="/resources/images/icons/sale.png" class="sale"/>
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
                                                <a class="buy_btn item_add" style="background: rgb(280, 124, 83)"
                                                   href="/cart">Go in cart</a>
                                                <span class="item_price-css"
                                                      style="border: 3px solid #ff7c53">$${good.cost}</span>
                                            <#else>
                                                <a href="/cart/add" class="buy_btn js_addToCart item_add"
                                                   data-id="${good.id}">Buy</a>
                                                <#if (good.discount != 1)>
                                                    <span class="js_addToCart item_add item_price-css"
                                                          style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                                        <b class="item_price">$${(good.cost*good.discount)?int}</b></span>
                                                <#else>
                                                    <span class="item_price item_price-css">$${good.cost}</span>
                                                </#if>
                                            </#if>
                                            <#if (good.discount!=1)>
                                                <img src="/resources/images/icons/sale.png" class="sale"/>
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
                                                <a class="buy_btn item_add" style="background: rgb(280, 124, 83)"
                                                   href="/cart">Go in cart</a>
                                                <span class="item_price-css"
                                                      style="border: 3px solid #ff7c53">$${good.cost}</span>
                                            <#else>
                                                <a href="/cart/add" class="buy_btn js_addToCart item_add"
                                                   data-id="${good.id}">Buy</a>
                                                <#if (good.discount != 1)>
                                                    <span class="js_addToCart item_add item_price-css"
                                                          style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                                        <b class="item_price">$${(good.cost*good.discount)?int}</b></span>
                                                <#else>
                                                    <span class="item_price item_price-css">$${good.cost}</span>
                                                </#if>
                                            </#if>
                                            <#if (good.discount!=1)>
                                                <img src="/resources/images/icons/sale.png" class="sale"/>
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
                                                <a class="buy_btn item_add" style="background: rgb(280, 124, 83)"
                                                   href="/cart">Go in cart</a>
                                                <span class="js_addToCart item_add item_price-css"
                                                      style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                                    <b>$${good.cost*good.discount}</b></span>

                                            <#else>
                                                <a href="/cart/add" class="buy_btn js_addToCart item_add"
                                                   data-id="${good.id}">Buy</a>
                                                <#if (good.discount != 1)>
                                                    <span class="js_addToCart item_add item_price-css"
                                                          style="border: 3px solid #ff7c53"><s><i>$${good.cost}</s> </i>
                                                        <b class="item_price">$${(good.cost*good.discount)?int}</b></span>
                                                <#else>
                                                    <span class="item_price item_price-css">$${good.cost}</span>
                                                </#if>
                                            </#if>
                                            <#if (good.discount!=1)>
                                                <img src="/resources/images/icons/sale.png" class="sale"/>
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