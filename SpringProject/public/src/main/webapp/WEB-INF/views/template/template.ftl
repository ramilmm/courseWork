<#macro mainTemplate title="BookStore" styles=[] scripts=[] headerBannerClass="banner" >
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/fonts.css">
    <link rel="stylesheet" href="/resources/css/media.css">
    <link rel="stylesheet" href="/resources/css/owl.carousel.css">
    <link rel="stylesheet" href="/resources/css/owl.theme.css">
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/ion.rangeSlider.css">
    <link rel="stylesheet" href="/resources/css/ion.rangeSlider.skinHTML5.css">

    <#list styles as css>
        <link rel="stylesheet" href="/resources/${css}" type="text/css" />
    </#list>

    <script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="/resources/js/own/common.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/ion.rangeSlider.min.js"></script>
    <script type="text/javascript" src="/resources/js/own/ajax.js"></script>
    <script type="text/javascript" src="/resources/js/simpleCart.min.js"></script>
    <#--<script type="text/javascript" src="/resources/js/libs.js" ></script>-->
    <#list scripts as js>
        <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
    <#include "components/header.ftl" />
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <@m_body />
            </div>
        </div>
    </div>
    <#include "components/footer.ftl" />
</body>
</html>
</#macro>