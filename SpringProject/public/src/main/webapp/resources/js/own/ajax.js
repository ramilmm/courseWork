$(document).ready(function () {

    var force = true;
    
    $(".showMore").click(function () {
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/good/showMore",
            data: {
                id: $('.book_view').children("a").attr('id')
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '' && force) {
                $(".comment").last().after(data);
                force = false;
                $this.hide();
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
        });
    });


    $(document).on('click', '.js_addToCart', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/add',
            data: {goodId: $this.data('id')},
            success: function (data, status) {  // успешное завершение работы
                console.log('/cart/add result: data=' + data + '; status=' + status);
                if (data == 'ok') {
                    $this.removeClass('js_addToCart item_add').text('Go in cart').css('background', 'rgb(280, 124, 83)').attr('href','/cart');
                }
            },
            error: function () {    // На сервере произошла ошибка
                console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    // $(document).on('click', '.js_deleteGood', function () {
    //     event.preventDefault();
    //     var $this = $(this);
    //     $.ajax({
    //         type: 'POST',
    //         url: '/cart/delete',
    //         data: {goodId: $this.data('id')},
    //         success: function (data, status) {  // успешное завершение работы
    //             console.log('/cart/delete result: data=' + data + '; status=' + status);
    //             if (data == 'ok') {
    //                 $this.parent('tr').css('display', 'none');
    //             }
    //         },
    //         error: function () {    // На сервере произошла ошибка
    //             alert('Приносим извинения.<br/>На сервере произошла ошибка');
    //         }
    //     });
    // });

});