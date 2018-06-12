if(window.history.state){
    $('.goods-list').html(window.history.state.list);
    var page = window.history.state.page;
}else{
    var page = 2;
}

var isFinish = false;
var isLoading = false;
var $pullUp = null;
var needLoadMore = false;


var maxScrollY = 0;
var windowHeight = 0;
$(function(){
    maxScrollY = $(document).height();
    windowHeight = $(window).height();
    $(window).on('resize', function () {
        windowHeight = $(window).height();
    });

    $(window).scroll(function (e) {
        if (isFinish || isLoading) {
            return;
        }
        var y = $(document).scrollTop();
        maxScrollY = $(document).height();
        windowHeight = $(window).height();
        if (Math.abs(maxScrollY - windowHeight - y) > 100) {
            return;
        }
        var $wrapper = $(this);
        if (!$pullUp) {
            $pullUp = $wrapper.find('.pullup-goods');
        }
        var data = null;
        getData($wrapper, data, 1);
    });

    function getData($wrapper, data, direction) {
        if (isFinish) {
            return;
        }
        isLoading = true;
        if (!$pullUp) {
            $pullUp = $wrapper.find('.pullup-goods');
        }
        var labelTag = $($pullUp).find('.label');
        $.ajax(context+"/item_list",{
            data: {currentPage: page,pageSize:10,cateEnum:"nine"},
            type: 'post',
            error: function (xhr, type, errorThrown) {
                getData($wrapper, data, direction);
            },
            success: function (result, status, xhr) {
                needLoadMore  = false;
                if(result==null || result ==""){
                    isLoading = false;
                    $('.pullup-goods .label').html('没有更多商品啦');
                    isFinish = true;
                }else{
                    $('.goods-list').append(result);
                    $("img.lazy").lazyload();
                    maxScrollY = $(document).height();
                    isLoading = false;
                    page++;
                    $('.goods-list').attr('data-page',page);
                }
            }
        });
    }
});

$("img.lazy").lazyload();