/**
 * Created by wangjianxin on 2017/2/3.
 */
function look(p_id){
    $.ajax({
        url:'/p/look.json',
        data:{
            p_id:p_id
        },
        success:function(data){

        }
    })
}

function favour(p_id){
    var stas = $('#like_btn').text();
    var type;
    if(stas == "喜欢"){
          type = 1;
    }else{
        type =2;
    }
    if($('#user_id').val().length>0){
        $.ajax({
            url:'/p/favour.json',
            data:{
                p_id:p_id,
                type:type
            },
            success:function(data){
                if(data.a == 1 && stas == "喜欢"){
                    $('#like_btn').text("已喜");
                    $('#like_num').text(data.c);
                    $('#like').attr("style","background-color:#ea6f5a");
                    $('#like_btn').attr("style","color:#fff");
                    $('#like_num').attr("style","color:#fff");
                }else if(data.a ==1 && stas == "已喜") {
                    $('#like_btn').text("喜欢");
                    $('#like_num').text(data.c);
                    $('#like').attr("style","background-color:#fff");
                    $('#like_btn').attr("style","color:#ea6f5a");
                    $('#like_num').attr("style","color:#ea6f5a");
                }else{

                }
            }
        })
    }else{
        $.alert("未登录");
    }

}
function checkFavour(p_id){
    $.ajax({
        url:'/p/checkFavour.json',
         data:{
             p_id:p_id
         }
        ,success :function (data){
            if(data == 99){
                $('#like_btn').text("已喜");
                $('#like_num').text(data.c);
                $('#like').attr("style","background-color:#ea6f5a");
                $('#like_btn').attr("style","color:#fff");
                $('#like_num').attr("style","color:#fff");
            }else if(data == 98){
                $('#like_btn').text("喜欢");
                $('#like_num').text(data.c);
                $('#like').attr("style","background-color:#fff");
                $('#like_btn').attr("style","color:#ea6f5a");
                $('#like_num').attr("style","color:#ea6f5a");
            }else if(data == 97){
//                $.alert("未登录")
                console.log("游客未登录")
            }
        }
    })
}

function commentsend(p_id){
    var comment = $('#comment').val();
    $.ajax({
        url:'/comment/pc.json',
        type:'post',
        data:{
            p_id:p_id,
            comment:comment
        },
        success:function (data){
            if(data == 1){
                initcomment(p_id);
                $('#comment').val("");
            }else if(data == 97){
                $.alert("未登录")
                return false;
            }else if(data == 98){
                $.alert("请输入内容");
            }
        }
    })
}

function initcomment(p_id){
    $.ajax({
        url:'/comment/init.json',
        data:{
            p_id:p_id
        },
        success:function(data) {
            var innerHtml = $('#comment_detial');
            innerHtml.empty();
            for (var i = 0; i < data.length; i++) {
                var
               item =' <div class="comment_detial">';
                item +='     <div>';
                item +='<div class="comment_detauthor">';
                item +='    <a class="avatar" target="_blank">';
                item +='        <img src="http://101.201.235.59:8087/pic/'+data[i].photo+'" onclick="go('+data[i].userid+')">';
                item +='        </a>';
                item +='        <div class="comment_detinfo">';
                item +='            <a class="name" target="_blank">'+data[i].name+'</a>';
                item +='            <div class="meta">';
                item +='                <span>'+(i+1)+'楼 · '+data[i].createtime+'</span>';
                item +='            </div>';
                item +='        </div>';
                item +='    </div>';
                item +='    <div class="comment_wrap">';
                item +='        <p>'+data[i].comment+'</p>';
                item +='        <div class="tool_group">';
//                item +='            <%--<a><span>回复</span></a>--%>
                item +='            </div>';
                item +='        </div>';
                item +='    </div>';
                item +='</div>';
                innerHtml.append(item);
            }
        }
    })
}

function commentcancel(){
    $('#comment').val("");
}
function go(user_id){
    alert(user_id)
}