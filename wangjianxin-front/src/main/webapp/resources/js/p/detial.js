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