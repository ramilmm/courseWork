<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl">
<@mainTemplate title="Обратная связь" styles=["css/own/feedback.css"] />
<#macro m_body>
<div class="feedback">
    <div class="container">
        <div class="contact_form">
            <h2>Feedback</h2>
            <@form.form commandName="feedbackForm" action="/feedback"  acceptCharset="UTF-8" method="POST">
                <div class="col-md-6 to">
                        <div class="form-group">
                            <@form.input path="firstName" class="form-control" placeholder="First name"/>
                        <@form.errors path="firstName" cssStyle= "color:red"/>
                        </div>
                        <div class="form-group">
                        <@form.input path="firstName" class="form-control" placeholder="Second name"/>
                        <@form.errors path="firstName" cssStyle= "color:red"/>
                    </div>
                    <div class="form-group">
                        <@form.input path="email"class="form-control"  placeholder="Email"/>
                        <@form.errors path="email" cssStyle="color:red"/>
                    </div>
                </div>
                <div class="col-md-6 text form-group">
                    <@form.textarea path="subject" class="form-control" placeholder="Write feedback here" />
                    <@form.errors path="subject" cssStryle="color:red"/>
                </div>
                <div class="clearfix"></div>
                <div class="but__center"><input type="submit" class="submit-btn btn btn-default" value="Send message &gt;&gt;"></div>
            </@form.form>
        </div>
    </div>
</div>
</#macro>