<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="col-md-3">
    <div class="admin-info">
        <div class="profile-img">
            <img src="/resources/images/admin.png" class="img-circle">
        </div>
        <div class="profile-name">
            <p class="admin-name"><@sec.authentication property="principal.name" /></p>
            <ul class="admin-menu">
                <li><a href="/admin">Add sale</a></li>
                <#--<li><a href="/admin/goods">Show all goods</a></li>-->
                <li><a href="/admin/users">Show all users</a></li>
                <#--<li>Show all orders</li>-->
                <li><a href="/">Go to home page</a></li>
            </ul>
        </div>
    </div>
</div>