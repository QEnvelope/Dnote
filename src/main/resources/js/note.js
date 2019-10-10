$(function(){
    //菜单点击
    $(".nav-link").on('click',function(){
        var url = $(this).attr('href');
        $("#J_iframe").attr('src',url);
        return false;
    });
});