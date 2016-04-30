<#macro comment comment>
<#-- @ftlvariable name="comment" type="mvc.common.ReviewInfo" -->
<#--<div class="comments">-->
<div class="comment">
    <#if comment.user.profile_img_url??>
        <img src="${comment.user.profile_img_url}"/>
    <#else>
        <img src="/resources/images/icons/noname_icon.png" alt="anon">
    </#if>
    <p><span>${comment.user.name}</span> <br/>${comment.content}</p>
    <hr/>
<#--</div>-->
</div>
</#macro>