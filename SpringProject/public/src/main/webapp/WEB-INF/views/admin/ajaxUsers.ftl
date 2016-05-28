<#include "user.ftl">
<#if users?? && users?has_content>
    <#list users as ord>
        <@user user=ord />
    </#list>
</#if>