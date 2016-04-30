<#-- @ftlvariable name="good" type="mvc.common.GoodInfo" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Review" styles=["css/own/review.css"] />
<#macro m_body>
<div class="review">
    <div class="container">
        <div class="row">
            <div class="contact_form">
                <h2 style="text-align: center">Write review</h2>
            <div class="col-md-8">
                <@form.form commandName="reviewForm" action="/write-review"  acceptCharset="UTF-8" method="POST">
                <div class="to">
                    <#--<@form.errors path="*" cssStyle="color: red;" />-->
                        <div class="form-group">
                            <@form.input path="firstName" name="firstName" class="form-control" placeholder="Name" />
                            <@form.errors path="firstName" cssStyle="color:red" />
                        </div>
                    <div class="form-group">
                        <@form.input path="email" name="email" class="form-control"  placeholder="Email"/>
                        <@form.errors path="email" cssStyle="color:red"/>
                    </div>
                </div>
                    <input type="hidden" value="${good.id}" name="goodId"/>
                    <div class="text form-group">
                        <@form.textarea path="review" name="comment" class="form-control" placeholder="Write review here" />
                    <@form.errors path="review" cssStryle="color:red"/>
                    </div>
                    <div class="but__center"><input type="submit" class="submit-btn btn btn-default"
                                                    value="Send message &gt;&gt;"></div>

                </@form.form>
            </div>
        </div>
        <div class="col-md-4">
            <div class="poster">
                <a href="/good/${good.id}"><img src="${good.image}"></a>
            </div>
            <p class="descr"><span id="name">${good.name}</span><br><span id="author">${good.author}</span></p>
        </div>
    </div>
</div>
</div>
</#macro>