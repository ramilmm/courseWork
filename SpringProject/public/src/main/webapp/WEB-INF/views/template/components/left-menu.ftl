<#-- @ftlvariable name="authors" type="java.util.List<java.lang.String>"-->
<#-- @ftlvariable name="country" type="java.util.List<java.lang.String>"-->
<div class="col-md-3">
    <div class="left_menu">
        <h2>Pick a book</h2>
        <hr>
        <div id="accordion-js" class="accordion">
            <form action="/catalog/filter" method="post">
                <div class="filter-item">
                    <img src="/resources/images/icons/right_arrow.jpg" alt="">
                    <h3 class="filter">Authors</h3>
                    <ul>
                    <#list authors as author>
                        <li class="author">
                            <input type="checkbox" value="${author}" id="${author}">
                            <label for="${author}">${author}</label>
                        </li>
                    </#list>
                    </ul>
                </div>
                <div class="filter-item">
                    <img src="/resources/images/icons/right_arrow.jpg" alt="">
                    <h3 class="filter">Country</h3>
                    <ul>
                    <#list country as c>
                        <li class="country">
                            <input type="checkbox" value="${c}" id="${c}">
                            <label for="${c}">${c}</label>
                        </li>
                    </#list>
                    </ul>
                </div>
                <div class="filter-item active">
                    <img src="/resources/images/icons/right_arrow.jpg" alt="">
                    <h3 class="filter">Cost</h3>
                    <input type="text" id="slider" name="slider" value=""/>
                </div>


                <input name="cost" id="cost" type="hidden" value="30;350">
                <input name="authors" id="authors" type="hidden" value="">
                <input name="country" id="country" type="hidden" value="">
                <button type="submit">Apply</button>
            </form>
        </div>
    </div>
</div>