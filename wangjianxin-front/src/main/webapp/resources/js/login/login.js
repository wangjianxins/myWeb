/**
 * Created by wangjianxin on 2016/10/27.
 */
function login(){
    $.ajax({
        url:"/login.json",
        type:"get",
        data:{
            email:$('#email').val(),
            pass:$('#pass').val()
        },
        success: function (data) {
            if(data == 99){
                swal("登录成功");
                window.location.href="/";
            }else{
                swal("账号密码错误");
            }
        }
    })
}
function reg(){
    var email = $('#reg_email').val();
  var pass =   $('#reg_pass').val();
  var name =  $('#reg_name').val();
    if(email.length>0 && pass.length>0 && name.length>0){
        if(emailCheck(email)){
            $.ajax({
                url:"/reg.json",
                type:"get",
                data:{
                    email:$('#reg_email').val(),
                    pass:$('#reg_pass').val(),
                    name:$('#reg_name').val()
                },
                success: function (data) {
                    if(data == 1){
                        swal("注册成功");
                            $.ajax({
                                url:"/mail/send.json",
                                type:"get",
                                data:{
                                    email:email
                                }
                            })
                        window.location.href="/";

                        return ;
                    }if(data == 98){
                        swal("此邮箱已被注册");
                        return ;
                    }else {
                        swal("网络GG");
                        return ;
                    }
                }
            })
        }else{
            swal("邮箱不正确哦");
        }
    }else{
        swal("信息填完整哦");
    }
}

function goReg(){
    window.location.href="/reg.html";
}

function emailCheck(obj) {
//    var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (!pattern.test(obj)) {
        swal("请输入正确的邮箱地址");
        obj.focus();
        return false;
    }
    return true;
}
