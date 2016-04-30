<#include "../template/template.ftl">
<@mainTemplate title="BookStore" styles=["css/own/product.css","css/own/error.css"]/>
<#macro m_body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 class="error_code">404</h1>
            <img src="/resources/images/error.jpg" class="error_img">
            <h1 style="text-align: center">Server error. <br/>
                Return to <a href="/" class="homepage_css">homepage.</a> </h1>

        </div>
    </div>
</div>
</#macro>