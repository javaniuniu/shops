$(function () {
    $("#sub-nav-news").attr("class", "active");

    $(".del-news-btn").click(function () {
        var newsId = $(this).parent().parent().attr("pid");
        $.ajax({
            url: "/admin/news/delete/" + newsId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("公告删除成功...");
                    $("tr[pid="+newsId+"]").remove();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误");
            }
        })
    });


    //保存News
    $("#addNewsBtn").click(function () {
        var addressId = $(this).attr("pid");
        $.ajax({
            url: "/admin/news/add/",
            method:"post",
            data:{
                "id":$("#id").val(),
                "title":$("#title").val(),
                "content":$("#content").val()
            },
            success: function (result) {
                if(result.status=="SUCCESS"){
                    $('#addNewsSuccess').show();
                    toastr.info("添加成功");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误...");
            }
        })
    });

})