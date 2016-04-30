<#-- @ftlvariable name="Menu" type="java.util.List<mvc.common.CategoryInfo>" -->

<div class="footer_category">
    <div class="container">
        <div class="row">
            <#list Menu as menu>
            <div class="col-md-3">
                <h4>${menu.name}</h4>
                <ul>
                <#list menu.children as child>
                    <li><a href="/catalog/${child.id}" data-id="${child.id}">${child.name}</a></li>
                </#list>
                </ul>
            </div>
            </#list>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h5>We accept all major Credit Card/Debit Card/Internet Banking</h5>
                <hr>
                <h6>Ramil Makhmutov Production 2016</h6>
            </div>
        </div>
    </div>
</div>