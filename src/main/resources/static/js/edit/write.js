$(function(){
    //点击保存
    $(".custom .btn .save").on('click',function(){
        var targetUrl;
        var methodType;
        var value = document.getElementById('judgeAdd').innerHTML;
        if(value == '-1'){
            targetUrl = "/note/create/";
            methodType = 'POST'
        }else {
            targetUrl = "/note/" + value + "/";
            methodType = 'PUT'
        }

        var title = document.getElementById('txtTitle').value;
        var content = document.getElementById('editor').value;
        var noteVO = {
            "title": title,
            "content": content,
            "author_id": 1
        }
        var jsnStr = JSON.stringify(noteVO)

        $.ajax({
            url: targetUrl,
            type: methodType,
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: jsnStr,
            success:function (data) {
                alert('笔记保存成功')
                if(value == -1){
                    document.getElementById('judgeAdd').innerHTML = data.data
                    document.getElementById('btnDraft').setAttribute("value", "保存")
                }
            },
            error:function (data) {
                alert('笔记保存失败，请重试')
            }
        })
    });

    //点击更新
    $(".custom .btn .update").on('click',function(){
        var targetUrl;
        var methodType;
        var value = document.getElementById('judgeAdd').innerHTML;
        if(value == '-1'){
            targetUrl = "/note/create/";
            methodType = 'POST'
        }else {
            targetUrl = "/note/" + value + "/";
            methodType = 'PUT'
        }

        var title = document.getElementById('txtTitle').value;
        var content = document.getElementById('editor').value;
        var noteVO = {
            "title": title,
            "content": content,
        }
        var jsnStr = JSON.stringify(noteVO)

        $.ajax({
            url: targetUrl,
            type: methodType,
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: jsnStr,
            success:function (data) {
                alert('笔记保存成功')
                if(value == -1){
                    document.getElementById('judgeAdd').innerHTML = data.data
                    document.getElementById('btnDraft').setAttribute("value", "保存")
                }
            },
            error:function (data) {
                alert('笔记保存失败，请重试')
            }
        })
    });

    //点击删除
    $(".custom .btn .delete").on('click',function(){
        var id = document.getElementById('noteId').innerHTML;
        var targetUrl = "/note/" + id + "/";

        var xhr;
        if (window.XMLHttpRequest) { // 其他类型的浏览器
            xhr = new XMLHttpRequest();
        } else { // ie浏览器
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        // 2:配置请求信息
        xhr.open('delete', targetUrl, true);
        // 3:发送请求
        xhr.send();
        // 4:监听状态 注册onreadystatechange事件
        xhr.onreadystatechange = function() {
            // 5:判断请求和相应是否成功
            if (xhr.readyState == 4 && xhr.status == 200) {
                window.parent.location.href="/note/notes/";
            }
        }
    });

});