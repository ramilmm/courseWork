<#-- @ftlvariable name="cart" type="java.util.List<mvc.common.Cart>"-->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="orders">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <table class="order-list">
                    <tr class="top">
                        <td colspan="2">Items</td>
                        <td></td>
                        <td>Cost</td>
                        <td>Qty</td>
                        <td>Total</td>
                    </tr>

                <#if cart??>
                    <#list cart as good>
                        <tr class="order">
                            <td class="book_view">
                                <a href="/good/${good.good_id.id}"><img src="${good.good_id.image}" alt="${good.good_id.name}"></a>
                            </td>
                            <td class="description">
                                <p><a href="/good/${good.good_id.id}">${good.good_id.author} : ${good.good_id.name}</a>
                                    <br/>
                            <span class="delete_btn">
                                <p class="js_deleteGood" data-id="${good.good_id.id}"><img
                                        src="/resources/images/icons/delete_icon.png">
                                    <span>Remove</span>
                                </p>
                                </span>
                                </p>
                            </td>
                            <td></td>
                            <td class="cost">
                                <span data-id="${good.good_id.cost}">$${good.good_id.cost}</span>
                            </td>
                            <td class="item-quantity">
                            <#--<input type="text" class="form-control count simpleCart_input" value="${Session.cart.getCount(good)}"-->
                                       <#--name="count"/>-->
                            </td>
                            <td class="cost">
                                <span class="total"></span>
                            </td>
                        </tr>
                    </#list>
                <#else>
                    <tr>
                        <td>
                            <span>cart is empty.</span>
                        </td>
                    </tr>
                </#if>
                </table>
            <#--<div class="simpleCart_items"></div>-->
                <div class="back_link">
                    <a href="/">
                        <img src="/resources/images/icons/back_icon.png" alt="back">
                        <span>Continue shopping</span>
                    </a>
                </div>
            </div>
            <div class="right-order-block">
                <div class="col-md-3">
                    <div class="summary">
                        <h3>Summary</h3>
                        <hr/>
                        <p>Items <span id="items" class="simpleCart_quantity"></span></p>
                        <hr/>
                        <p id="subtotal">SUBTOTAL <br/>
                            <span class="simpleCart_total"></span></p>
                        <form action="/cart/interval" method="post">
                            <input type="text" style="display: none" class="total_quantity" name="total_quantity" value="1">
                            <input type="text" style="display: none" class="total_sum" name="total_sum" value="1">
                            <input type="submit" class="btn btn-default checkout" value="CHECKOUT">
                        </form>
                        <div class="dop_inf">
                            <p> 2 Million Experiences Sold <br/>
                                Free Exchange on Vounchers <br/>
                                Refuns Within 14 Days</p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
