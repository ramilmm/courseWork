<#-- @ftlvariable name="Session.cart" type="mvc.common.CartInfo" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="orders">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
            <div class="simpleCart_items"></div>
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
