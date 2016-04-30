<#-- @ftlvariable name="topGoods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/template.ftl">
<@mainTemplate title="Авторизация" styles=["css/own/login.css"]/>
<#macro m_body>

<div class="account-in">
    <div class="container">
        <h3>Account</h3>
        <div class="col-md-7 account-top">
            <#if error?has_content>
                <div style="color: red;">Error! Please, check your email and password!</div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div class="form-group">
                    <span>Email</span>
                    <input class="form-control" type="text" name="j_username" />
                </div>
                <div class="form-group">
                    <span class="pass">Password</span>
                    <input class="form-control" type="password" name="j_password" />
                </div>
                <div class="form-group">
                    <input class="form-control" id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Remember me</label>
                </div>
                <input type="submit" class="submit-btn btn btn-default" value="Login" />
                <a href="/reg" style="margin-left: 15px;">Create an account</a>
            </form>
            <#--</form><form name="authForm" id="authForm" action="j_spring_security_check" method="post">-->
            <#--<div>-->
                <#--<span>Email*</span>-->
                <#--<input type="text" name="j_username" />-->
            <#--</div>-->
            <#--<div>-->
                <#--<span class="pass">Password*</span>-->
                <#--<input type="password" name="j_password" />-->
            <#--</div>-->
        <#--&lt;#&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;&gt;-->
            <#--<div>-->
                <#--<input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>-->
                <#--<label for="remember_me" class="inline">Remember me</label>-->
            <#--</div>-->
            <#--<input type="submit" value="Login" />-->
            <#--<a href="/reg" style="margin-left: 15px;">Create an account</a>-->
        <#--</form>-->
        </div>
        <div class="col-md-5 left-account "></div>
    </div>
</div>
</#macro>