/**
 * Created by wangjianxin on 2017/1/9.
 */
isEdit();


function isEdit(){
$.ajax({
    url:'/star/isEdit.json',
    type:'post',
    data:{username:$('#star_username').text()},
    success:function (date){
        if(date ==99){
            $('#edit').show();
            $("#edit").css("cursor","pointer");
            }else{

        }
    }

})
}

function editstar(){
    alert("创建者可以修改星座信息，暂未修改")
}
