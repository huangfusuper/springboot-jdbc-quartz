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
