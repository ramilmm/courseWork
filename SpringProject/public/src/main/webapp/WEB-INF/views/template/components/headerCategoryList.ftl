<#-- @ftlvariable name="Menu" type="java.util.List<mvc.common.CategoryInfo>" -->

<div class="category">
<div class="container">
<div class="row">
<div class="col-md-12">
<ul id="top-nav">
<#list Menu as menu>
        <li>
            <a href="#">${menu.name}</a>
            <ul>
                <#list menu.children as child>
                    <li>
                        <a href="/catalog/${child.id}" data-id="${child.id}">${child.name}</a>
                    </li>
                </#list>
            </ul>
        </li>
    </#list>
</div>
</div>
</div>
    <hr>
</div>