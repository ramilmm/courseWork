<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="col-md-3">
    <div class="admin-info">
        <div class="profile-img">
            <img src="/resources/images/admin.png" class="img-circle">
        </div>
        <div class="profile-name">
            <p class="admin-name"><a href="/cabinet"><@sec.authentication property="principal.name" /></a></p>
            <ul class="admin-menu">
                <#--<li><a href="#">Edit profile</a></li>-->
                <li><a href="/cabinet/orders">My orders</a></li>
                <li><a href="/">Go to home page</a></li>
            </ul>
        </div>
    </div>
</div>