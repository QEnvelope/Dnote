$(function(){
    //点击保存
    $(".custom .btn .save").on('click',function(){
        var targetUrl;
        var methodType;
        var value = document.getElementById('judgeAdd').innerHTML;
        if(value == '-1'){
            targetUrl = window.location.host + "/note/create/";
            document.getElementById('judgeAdd').innerHTML = 'update';
            methodType = 'POST'
        }else {
            targetUrl = window.location.host + "/note/" + value + "/";
            methodType = 'PUT'
        }

        var title = document.getElementById('txtTitle').value;
        var content = document.getElementById('editor').value;
        var noteVO = {
            "title": title,
            "content": content
        }

        $.ajax({
            url: targetUrl,
            data: noteVO,
            type: methodType,
            dataType: 'json',
            success:function (data) {
                alert('笔记已保存' + data.data)
                document.getElementById('judgeAdd').innerHTML = data.data
            },
            error:function (data) {
                alert('笔记保存失败，请重试')
            }
        })
    });

});