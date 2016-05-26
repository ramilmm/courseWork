<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#-- @ftlvariable name="AllComments" type="java.util.List<mvc.common.ReviewInfo>" -->
<#-- @ftlvariable name="comments" type="java.util.List<mvc.common.ReviewInfo>" -->
<#-- @ftlvariable name="good" type="mvc.common.GoodInfo" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../template/template.ftl">
<@mainTemplate title="BookStore" styles=["css/own/product.css"] scripts=["js/own/ajax.j"]/>
<#macro m_body>
<#include "components/nav_way.ftl" />
<div id="test" class="container">
    <div class="product_info simpleCart_shelfItem">
        <div class="row">
            <#if good??>
            <div class="col-md-4">
                <div class="book_view">
                    <a id="${good.id}"><img src="${good.image}" alt="${good.name}"></a>
                </div>
            </div>
            <div class="col-md-8">
                <div class="book_head">
                    <h1 class="item_name">${good.name}</h1>
                </div>

                <div class="description">
                    <span>${good.description}</span>
                </div>
                <div class="pay_description">
                    <p>Our price :
                        <#if (good.discount != 1)>
                            <span>$<s><i>${good.cost}</i></s><span class="item_price">$${(good.cost*good.discount)?int}</span></span>
                        <#else>
                            <span>$<span class="item_price">${good.cost}</span></span>
                        </#if>

                        <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                            <a class="buy_btn my_button" href="/cart">Go in cart</a>
                        <#else>
                            <a href="/cart" class="buy_btn js_addToCart item_add my_button" data-id="${good.id}">Add to cart</a>
                        </#if>
                        <h6>Safe,Secure Shopping</h6><br>
                    <img src="/resources/images/paypal.png" alt="paypal">
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="mid_part">
            <div class="col-md-9">
                <div class="tabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab-1" data-toggle="tab">Interesting facts</a></li>
                        <li><a href="#tab-2" data-toggle="tab">Other Details</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab-1">
                            <p>${good.interesting_facts}</p>
                        </div>
                        <div class="tab-pane fade" id="tab-2">
                            <p>${good.description}</p>
                        </div>
                    </div>
                </div>
                <div class="comments">
                    <#if comments?has_content>
                        <h3>Book review</h3>

                        <#include "comment.ftl">
                        <#list comments as com>

                            <@comment comment=com/>

                        </#list>
                    <#if (AllComments?size > 3)>
                        <div class="showMore">
                            <h3>Show more</h3>
                        </div>
                    </#if>
                    <#else>
                        <div class="comment">
                            <h3>There is no comments.Your comment will be first.</h3>
                        </div>
                    </#if>
                    <div class="write_a_comment">
                        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                            <a href="/login" class="btn btn-default login-btn">PLEASE LOGIN</a>
                        </@sec.authorize>
                        <@sec.authorize access="isAuthenticated()">
                            <a href="/write-review?id=${good.id}" class="btn btn-default submit-btn">Click here to write review</a>
                        </@sec.authorize>
                    </div>
                </div>
                </div>
            </div>
            <#include "components/popular.ftl" />
                <#else>
                <span>Sorry, book not found.</span>
            </#if>
        </div>
    </div>
</#macro>