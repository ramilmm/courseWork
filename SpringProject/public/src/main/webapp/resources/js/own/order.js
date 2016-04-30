$(document).ready(function() {
    
    $('.summary').on('click',function () {
        var total_count = $('.simpleCart_quantity').text();
        console.log(total_count.slice(total_count.length/2));
        total_count = total_count.slice(total_count.length/2);
        $('.total_quantity').val(total_count);
        var total_sum = $('.simpleCart_total').text();
        total_sum = total_sum.slice(total_sum.length/2);
        total_sum = total_sum.replace(' ','');
        total_sum = total_sum.replace('$','');
        console.log(total_sum);
        $('.total_sum').val(total_sum);
    });

});