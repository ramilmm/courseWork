$(document).ready(function () {

    // $(document).on('click', '.send_btn', function () {
    //
    //     var authors = $('.author input:checked');
    //     var authorsArray = '';
    //     var count = authors.size()-1;
    //     while (count >=0){
    //         authorsArray += authors[count].value+';';
    //         count -= 1;
    //     }
    //     var cost = $('#cost')[0].value;
    //     var costArray =  cost.split(';');
    //     var max =  costArray[0];
    //     var min = costArray[1];
    //     // var authors = $('.author input:checked').serialize();
    //     // console.log(authors);
    //     // var country = $('.country input:checked').serialize();
    //     // console.log(country);
    // });

    // $(document).on('click', '.js_addToCart', function () {
    //     var goodId = $(this).data('id');
    //     var input = $('#goods');
    //     input.value = input.value + ';' + goodId;
    //     console.log(input.value)
    // });
    
    $("#carousel").owlCarousel({
        autoPlay: 2000,
        items: 1,
        itemsDesktop: [1199, 1],
        itemsDesktopSmall: [979, 1],
        stopOnHover: true,
        responsive: true,
        navigation: true
    });


    $('#accordion-js').find('h3').click(function () {
        $(this).next().stop().slideToggle();
    }).next().stop().hide();


    var k = function () {
        var a = document.querySelector('.left_menu'), b = null, P = 10;  // если ноль заменить на число, то блок будет прилипать до того, как верхний край окна браузера дойдёт до верхнего края элемента. Может быть отрицательным числом
        window.addEventListener('scroll', Ascroll, false);
        document.body.addEventListener('scroll', Ascroll, false);
        function Ascroll() {
            if (b == null) {
                var Sa = getComputedStyle(a, '');
                var s = '';
                for (var i = 0; i < Sa.length; i++) {
                    if (Sa[i].indexOf('overflow') == 0 || Sa[i].indexOf('padding') == 0 || Sa[i].indexOf('border') == 0 || Sa[i].indexOf('outline') == 0 || Sa[i].indexOf('box-shadow') == 0 || Sa[i].indexOf('background') == 0) {
                        s += Sa[i] + ': ' + Sa.getPropertyValue(Sa[i]) + '; '
                    }
                }
                b = document.createElement('div');
                b.style.cssText = s + ' box-sizing: border-box; width: ' + a.offsetWidth + 'px;';
                a.insertBefore(b, a.firstChild);
                var l = a.childNodes.length;
                for (var i = 1; i < l; i++) {
                    b.appendChild(a.childNodes[1]);
                }
                a.style.height = b.getBoundingClientRect().height + 'px';
                a.style.padding = '0';
                a.style.border = '0';
            }
            var Ra = a.getBoundingClientRect(),
                R = Math.round(Ra.top + b.getBoundingClientRect().height - document.querySelector('footer').getBoundingClientRect().top + 0);  // селектор блока, при достижении верхнего края которого нужно открепить прилипающий элемент;  Math.round() только для IE; если ноль заменить на число, то блок будет прилипать до того, как нижний край элемента дойдёт до футера
            if ((Ra.top - P) <= 0) {
                if ((Ra.top - P) <= R) {
                    b.className = 'stop';
                    b.style.top = -R + 'px';
                } else {
                    b.className = 'sticky';
                    b.style.top = P + 'px';
                }
            } else {
                b.className = '';
                b.style.top = '';
            }
            window.addEventListener('resize', function () {
                a.children[0].style.width = getComputedStyle(a, '').width
            }, false);
        }
    };
    
    k();


    $('.filter').click(function () {
        $(this).parent('div').toggleClass('active');
    });

    $("#slider").ionRangeSlider({
        type: "double",
        min: 0,
        max: 500,
        from: 0,
        to: 500,
        prefix: "$",
        grid: true,
        force_edges: true
    });

    $("#slider").on("change", function () {
        var $this = $(this);
        $('#cost').val($this.prop("value"));
    });

    simpleCart({
        cartColumns: [
            {attr: "name", label: "Item"},
            {view: "decrement", label: " ↓", text: "-"},
            {view: "input", attr: "quantity", label: "Quantity"},
            {view: "increment", label: " ↑", text: "+"},
            {view: "currency", attr: "price", label: "Cost"},
            {view: "remove", text: "X", label: "Delete item"}
        ],
        cartStyle: "table"
    });
    simpleCart.currency({
        code: "US",
        symbol: "$",
        name: "Dollars",
        delimiter: " ",
        after: true,
        accuracy: 0
    });

    $(".clearbasket_link").click(function () {
        simpleCart.empty();
    });


});