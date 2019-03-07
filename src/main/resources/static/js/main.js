//remain scroll position after redirect
$(window).scroll(function () {
    sessionStorage.scrollTop = $(this).scrollTop();
});

$(document).ready(function () {
    if (sessionStorage.scrollTop !== "undefined") {
        $(window).scrollTop(sessionStorage.scrollTop);
    }
});

<!--show password when mouse is over eye icon-->
$('.show-password').hover(function () {
    $('.password').attr('type', 'text');
}, function () {
    $('.password').attr('type', 'password');
});

<!--replacing list of items by number (list length)-->
$(function() {
    var count = 0;
    $('ul').each(function(){
        if(count !== 0){
            var len = $(this).find('li').length;
            $(this).parent().find('.my-replace-by-number').html(len);
        }
        count++;
    })
});