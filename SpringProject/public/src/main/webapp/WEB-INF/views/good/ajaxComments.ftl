<#include "comment.ftl">
<#if comments?? && comments?has_content>
    <#list comments as review>
        <@comment comment=review />
    </#list>
</#if>