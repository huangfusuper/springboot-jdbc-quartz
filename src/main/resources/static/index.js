function start(obj){
    var x = $(obj).parent().parent().find("td");
    var id = x.eq(0).text()

    $.ajax({
        url:"/addTask.do",
        data:{
            id : id
        },
        type:"post",
        dataType:"json",
        success:function(data){
            if(data.code=='000'){
                alert(data.msg)
                window.location = "/findAll.html";
            }
        }
    })


}

function stop(obj){
    var x = $(obj).parent().parent().find("td");
    var id = x.eq(0).text()

    $.ajax({
        url:"/changeJobStatus.do",
        data:{
            id : id,
            cmd : "STOP"
        },
        type:"post",
        dataType:"json",
        success:function(data){
            if(data.code=='000'){
                alert(data.msg)
                window.location = "/findAll.html";
            }
        }
    })
}

function pause(obj){
    var x = $(obj).parent().parent().find("td");
    var id = x.eq(0).text()

    $.ajax({
        url:"/pauseJob.do",
        data:{
            id : id
        },
        type:"post",
        dataType:"json",
        success:function(data){
            if(data.code=='000'){
                alert(data.msg)
                window.location = "/findAll.html";
            }
        }
    })
}

function ref(obj){
    var x = $(obj).parent().parent().find("td");
    var id = x.eq(0).text()

    $.ajax({
        url:"/resumeJob.do",
        data:{
            id : id
        },
        type:"post",
        dataType:"json",
        success:function(data){
            if(data.code=='000'){
                alert(data.msg)
                window.location = "/findAll.html";
            }
        }
    })
}

$(function () {
    var win = {};
    $("#add").on("click",function () {
        win = window.open("/addJob.html",
            "_blank",
            "height=300,width=600",
            false
        );
    });


    $("#addJob").on("click",function () {
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "addDbJob.do" ,//url
            data: $('#form').serialize(),
            success: function (data) {
                alert(data)
                var dataObj = JSON.parse(data);
                console.log(dataObj)
                if(dataObj.code=='000'){
                    alert(dataObj.msg)

                    win.close();
                }
            }

        });
    });
})
