// if(window.history.state){
//     $('.goods-list').html(window.history.state.list);
//     var page = window.history.state.page;
// }else{
//     var page = 2;
// }


//查看url中是否有cateId和type这两个参数
if(UrlParm.hasParm("cateId")){
    $('#tmpfqcid').val(UrlParm.parm("cateId"));
    $('#dc_xl_001').html(history.state.cateId);
}
if(UrlParm.hasParm("type")){
    $('#tmptpye').val(UrlParm.parm("type"));
    $('#dc_xl_002').html(history.state.type);
}

var page= 2;
// 从sessionStorage获取数据
if(UrlParm.hasParm("cateId") || UrlParm.hasParm("type")){
    var data = sessionStorage.getItem('item-list');
    if(data !=null && data != ''){
        $('.goods-list').html(data);
    }
    //分页信息
    if(history.state != null &&  history.state.page != null){
        page = history.state.page;
    }
}
// 从sessionStorage删除保存的数据
// sessionStorage.removeItem('item-list');


var isFinish = false;
var isLoading = false;
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
        getData(page);
    });


    /**
     * 异步请求数据
     * @param toPage
     */
    function getData(toPage) {
        if (isFinish) {
            return;
        }
        isLoading = true;
        var cateId = $('#tmpfqcid').val();
        var type = $('#tmptpye').val();
        $.ajax(context+"item_list",{
            data: {currentPage: toPage,pageSize:10,cateEnum:cate,cateId:cateId,type:type},
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

                    //将参数写入会话历史,改变url地址
                    window.history.replaceState(
                        {cateId:$('#dc_xl_001').html(),type: $('#dc_xl_002').html(),page:page},
                        document.title,
                        window.location.pathname+"?cateId="+cateId+"&type="+type
                    )

                    //保存list数据到sessionStorage
                    sessionStorage.setItem('item-list',  $('.goods-list').html());
                }
            }
        });
    }


    //选择条件
    $(".xl_div_001").off("click").on("click",function(){
        $(".goods-list").html('');
        var fqcid =  $(this).attr("data-id");
        $('#tmpfqcid').val(fqcid== -1 ? '': fqcid);
        var fqtxt =  $(this).html();
        $('#dc_xl_001').html(fqtxt);
        $('#xl_001').css("height","0px");
        sq_xl();
        page =1;
        getData(page);
    });

    $(".xl_div_002").off("click").on("click",function(){
        $(".goods-list").html('');
        var typename =  $(this).attr("data-id");
        $('#tmptpye').val(typename);
        var typetxt =  $(this).html();
        $('#dc_xl_002').html(typetxt);
        $('#xl_002').css("height","0px");
        sq_xl();
        page =1;
        getData(page);
    });
});

$("img.lazy").lazyload();




