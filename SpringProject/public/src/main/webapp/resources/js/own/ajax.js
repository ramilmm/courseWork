var force = true;
$(document).ready(function () {

    $(document).on('click', '.filter-item', function () {
        console.log('SET VALUE');

        //get checked authors
        var authors = $('.author input:checked');
        var authorsArray = '';
        var count = authors.size()-1;
        while (count >=0){
            authorsArray += authors[count].value+';';
            count -= 1;
        }
        $('#authors').val(authorsArray);

        //get checked country
        var country = $('.country input:checked');
        var countryArray = '';
        var c = country.size()-1;
        while (c >=0){
            countryArray += country[c].value+';';
            c -= 1;
        }
        $('#country').val(countryArray);

        //get min and max cost
        var cost = $('#cost')[0].value;
        var costArray =  cost.split(';');
        var min =  costArray[0];
        var max = costArray[1];
    });

    $(document).on('click', '.deactivate', function () {
        event.preventDefault();
        var $this = $(this);
        var user = $this.data('id');
        var id = '#active' + user;
        $.ajax({
            type: 'POST',
            url: '/admin/deactivate',
            data: {
                userId: user
            },
            success: function (data, status) {  // успешное завершение работы
                console.log('status=' + status);
                console.log(id);
                var el = document.getElementById('active'+user);
                el.innerHTML = 'no';
                // $(id).innerHTML = 'no';
            },
            error: function () {    // На сервере произошла ошибка
                // console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });


    $(document).on('click', '.update_user', function () {
        event.preventDefault();
        var $this = $(this);
        var user = $this.data('id');
        var roleId = '#role'+user; 
        $.ajax({
            type: 'POST',
            url: '/admin/updateUser',
            data: {
                userId: user,
                role: $(roleId).find('option:selected').val()
            },
            success: function (data, status) {  // успешное завершение работы
                console.log('status=' + status);
            },
            error: function () {    // На сервере произошла ошибка
                // console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '.delete_user', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/admin/deleteUser',
            data: {
                userId: $this.data('id')
            },
            success: function (data, status) {  // успешное завершение работы
                console.log('status=' + status);
                var dynamicClass = '.user'+$this.data('id');
                $(dynamicClass).hide();
            },
            error: function () {    // На сервере произошла ошибка
                // console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '.delete_order', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cabinet/delete',
            data: {
                orderId: $this.data('id')
            },
            success: function (data, status) {  // успешное завершение работы
                console.log('status=' + status);
                var dynamicClass = '.order'+$this.data('id');
                $(dynamicClass).hide();
            },
            error: function () {    // На сервере произошла ошибка
                // console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '.showMore', function () {
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/good/showMore",
            data: {
                id: $('.book_view').children("a").attr('id')
            }
        }).success(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '' && force) {
                $(".comment").last().after(data);
                force = false;
                $this.hide();
            } else {
                $this.hide();
            }
        }).error(function () {
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
                    $this.removeClass('js_addToCart item_add').text('Go in cart').css('background', 'rgb(280, 124, 83)').attr('href', '/cart');
                }
            },
            error: function () {    // На сервере произошла ошибка
                console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });
    

    $(document).on('click', '.js_deleteFromCart', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/delete',
            data: {goodId: $this.data('id')},
            success: function (data, status) {  // успешное завершение работы
                console.log('/cart/add result: data=' + data + '; status=' + status);
            },
            error: function () {    // На сервере произошла ошибка
                console.log(data);
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });


    $(document).on('click', '.js_addToWishlist', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/wishlist/add',
            data: {goodId: $this.data('id')},
            success: function (data, status) {  // успешное завершение работы
                console.log('/wishlist/add result: data=' + data + '; status=' + status);
                if (data == 'ok') {
                    $this.removeClass('js_addToWishlist item_add').attr('href', '/wishlist');
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