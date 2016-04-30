<!-- @ftlvariable name="error" type="java.lang.String" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Registration" headerBannerClass="men_banner" styles=["css/own/reg.css"] />
<#macro m_body>
<div class="account-in">
    <div class="container">
    <div class="row">
        <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post" class="form-horizontal">
        <#if error??>
            <h2 style="text-align: center; color: red">${error}</h2>
        </#if>
            <div class="register-top-grid">
            <div class="col-md-6">
                <h2>PERSONAL INFORMATION</h2>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div class="form-group">
                    <span>First Name<label>*</label></span>
                    <@form.input path="firstName" class="form-control" />
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                    <span>Last Name<label>*</label></span>
                    <@form.input name="lastName" path="lastName" class="form-control"/>
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                    <span>Email Address<label>*</label></span>
                    <@form.input name="email" path="email" class="form-control" />
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                    <span>Phone<label>*</label></span>
                    <@form.input name="phone" path="phone" class="form-control" />
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>
            </div>
            </div>
            <div class="col-md-6">
            <div class="register-bottom-grid">
                <h2>LOGIN INFORMATION</h2>
                <div class="form-group">
                    <span>Password<label>*</label></span>
                    <@form.password name="password" path="password" class="form-control" />
                    <@form.errors path="password" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                    <span>Confirm Password<label>*</label></span>
                    <@form.password path="confirmPassword" class="form-control" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                </div>
                <div class="clearfix"> </div>
            </div>
            </div>
            <div class="clearfix"> </div>
            <div class="register-but">
                <input type="submit" value="submit" class="btn btn-default submit-btn">
                <div class="clearfix"> </div>
            </div>
        </@form.form>
        </div>
    </div>
</div>
</#macro>