<#--@ftlvariable name="qty" type="java.lang.Long"-->
<#--@ftlvariable name="sum" type="java.math.BigDecimal"-->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Checkout" headerBannerClass="men_banner" styles=["/css/own/reg.css"] />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <div class="row">
            <@form.form id="checkForm" commandName="checkForm" action="/cart/checkout" acceptCharset="UTF-8" method="post" class="form-horizontal">
                <div class="register-top-grid">
                    <div class="col-md-6">
                    <#--<@form.errors path="*" cssStyle="color: red;" />-->
                        <div class="form-group">
                            <span>Area<label>*</label></span>
                            <@form.input name="area" path="area" class="form-control" />
                            <@form.errors path="area" cssStyle="color: red;" />
                        </div>
                        <div class="form-group">
                            <span>City<label>*</label></span>
                            <@form.input name="city" path="city" class="form-control"/>
                            <@form.errors path="city" cssStyle="color: red;" />
                        </div>
                        <div class="form-group">
                            <span>Flat<label></label></span>
                            <@form.input name="flat" path="flat" class="form-control" />
                            <@form.errors path="flat" cssStyle="color: red;" />
                        </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <span>House<label>*</label></span>
                        <@form.input name="house" path="house" class="form-control" />
                        <@form.errors path="house" cssStyle="color: red;" />
                    </div>
                    <#--<input type="text" style="display: none" class="total_quantity" name="qty" value="${qty}">-->
                    <#--<input type="text" style="display: none" class="total_sum" name="sum" value="${sum}>-->
                    <div class="form-group">
                        <span>Street<label>*</label></span>
                        <@form.input name="street" path="street" class="form-control" />
                        <@form.errors path="street" cssStyle="color: red;" />
                    </div>
                    <div class="form-group">
                        <span>Post index<label>*</label></span>
                        <@form.input name="post_index" path="post_index" class="form-control" />
                        <@form.errors path="post_index" cssStyle="color: red;" />
                    </div>
                    <div class="form-group">
                        <i class="news-letter">
                            <label class="">
                                <@form.checkbox class="checkbox" path="accept" />
                                <i> </i>I agree to processing my information
                                <@form.errors path="accept" cssStyle="color: red;" />
                            </label>
                        </i>
                    </div>
                </div>
                </div>
                <div class="register-but">
                    <input type="submit" value="submit" class="btn btn-default submit-btn">
                </div>
            </@form.form>
        </div>
    </div>
</div>
</#macro>