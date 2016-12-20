/**
 * Created by wangjianxin on 2016/10/28.
 */
function a(){location.href='/'}
function b(){location.href='/about.html'}
function c(){location.href='/star.html'}
function d(){location.href='/login.html'}
function m(){location.href='/music.html'}



//++访问量
$.ajax({
    url:"/about/countY.json",
    type:"get",
    success:function(data){
    }

})

getWord();
getPaihang();

$.ajax({
    url:"/getName.json",
    type:"get",
    success: function (data) {
        if(data.a == 1){
            $('#login_name').hide();
            $("#username").text(data.b);
            $("#username").addClass("text-primary");
        }else{
            $('#user_id').val(data.c);
            $('#login_names').hide();
            $('#login_name').show();
            $("#username").text(data.b)
        }
    }
})
function getWord(){
    $.ajax({
        url:"/getWord.json",
        type:"get",
        success: function (data) {
            $('#word').text(data);
        }
    })
}
function getPaihang(){
    $.ajax({
        url:"/paihang.json",
        type:"get",
        success: function (data) {
            var innerHtml = $("#paihang_div");
            innerHtml.empty();
            for (var i = 0; i < data.length; i++) {
                var divques = '<div class="paihang_div">';
                divques += data[i].name;
                divques += "&nbsp共获得<code>"+data[i].COUNT+"</code>个赞";
                innerHtml.append(divques);
            }
        }
    })
}
function show(pagenum,size){
    $.ajax({
        url:"/artic/show.json",
        type:"get",
        data:{
          pagenum:pagenum,
          pagesize:size
        },
        success: function (data) {
            var innerHtml = $("#context");
            innerHtml.empty();
            for (var i = 0; i < data.length; i++) {
                var divques = '<div class="Input_Foots" style="float: left;">';
                divques += data[i].content;
                divques += '<div class="likeCount" id="likeCount1_'+data[i].id+'" style="float: right;">'+data[i].zan+'</div>';
                divques += '<div id="heart_'+data[i].id+'" rel="like" class="heart" style="float: right;" onclick="heart('+data[i].id+',this);">';
                divques += '</div>';
                divques += '</div>';
                divques += '<div style="float: none;"class="index_time" id="name_">'+data[i].time+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+data[i].name+'</div>';
                if($('#user_id').val().length>0){
                    checks(data[i].id);
                }
//                $('#name_').mousemove(function(){
//                });
                innerHtml.append(divques);
            }
        }
    })
}

function quit(){
    $.ajax({
        url:"/quit.json",
        type:"get",
        success:function(){
            location.href=location.href;
        }
    })
}
function heart(article_id,obj){
    if($('#user_id').val().length>0){
        $.ajax({
            url:"/artic/zan.json",
            type:"get",
            data:{
                article_id:article_id,
                user_id:$('#user_id').val()
            },
            success:function(data){
                $('#likeCount1_'+article_id+'').html(data.c);
                getPaihang();
            }
        })
        check(article_id,obj);
    }else{
        swal("请先登录哦");
    }
}
function check(article_id,obj){
        $.ajax({
            url:"/artic/checkzan.json",
            type:"get",
            data:{
                article_id:article_id,
                user_id:$('#user_id').val()
            },
            success: function (data) {
                if(data ==99){//赞过
                    $(obj).removeClass("heartAnimation").attr("rel","like");
                    $(obj).css("background-position","left");
                }else{
                    $(obj).addClass("heartAnimation").attr("rel","unlike");
                }
            }
        })
}
function checks(id){
        $.ajax({
        url:"/artic/checkzan.json",
        type:"get",
        data:{
            article_id:id,
            user_id:$('#user_id').val()
        },
        success: function (data) {
            if(data ==99){//赞过
                $('#heart_'+id+'').addClass("heartAnimation").attr("rel","unlike");

            }else{
                $('#heart_'+id+'').removeClass("heartAnimation").attr("rel","like");
                $('#heart_'+id+'').css("background-position","left");

            }
        }
        })
}

