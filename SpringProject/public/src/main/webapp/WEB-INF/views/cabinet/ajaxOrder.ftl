<#include "order.ftl">
<#if orders?? && orders?has_content>
    <#list orders as ord>
        <@order order=ord />
    </#list>
</#if>