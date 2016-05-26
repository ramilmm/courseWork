<#-- @ftlvariable name="populars" type="java.util.List<mvc.comon.GoodInfo>" -->
<#-- @ftlvariable name="good" type="mvc.common.GoodInfo" -->
<div class="col-md-3">
    <div class="popular_column">
        <p>You may also like</p>
    <#list populars as goods>
        <#--<#if good.id!=goods.id>-->
            <div class="popular_books">
                <a href="/good/${goods.id}"><img src="${goods.image}" alt="good.name"></a>
                <a href="/good/${goods.id}"><h4>${goods.name} <br/>
                    <span>$${(goods.cost*goods.discount)?int}</span></h4></a>
                    <hr/>
            </div>
        <#--</#if>-->
    </#list>
    </div>
</div>