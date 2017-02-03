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
    var ma =  $('#reg_ma').val();
    if(email.length>0 && pass.length>0 && name.length>0 && ma.length>0){
        if(emailCheck(email)){
            $.ajax({
                url:"/reg.json",
                type:"get",
                data:{
                    email:$('#reg_email').val(),
                    pass:$('#reg_pass').val(),
                    name:$('#reg_name').val(),
                    ma:$('#reg_ma').val()
                },
                success: function (data) {
                    if(data == 1){
                        swal("注册成功");
                            $.ajax({
                                url:"/mail/send.json",
                                type:"get",
                                data:{
                                    email:email,
                                    type:1
                                }
                            })
                        window.location.href="/";
                        return ;
                    }if(data == 98){
                        swal("此邮箱已被注册");
                        return ;
                    }if(data == 97){
                        swal("昵称已被用");
                        return ;
                    }if(data == 96){
                        swal("验证码错误");
                        return ;
                    }
                    else {
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
function sendMa(){
    secs = 35;
    $('#sendMa').disabled=true;
    var email = $('#reg_email').val();
    if(emailCheck(email)) {
        $.ajax({
            url:"/mail/send.json",
            type:"get",
            data:{
                email:email,
                type:2,
                user_ip:returnCitySN["cip"]
            }
        })
        for (var i = 1; i <= secs; i++) {
            window.setTimeout("update(" + i + ")", i * 1000);
        }

    }
}
function update(num) {
    if(num == secs) {
        $('#sendMa').text("发送验证码");
        $('#sendMa').attr({ "onclick": "sendMa()" });
    }
    else {
        var printnr = secs-num;
        $('#sendMa').text("重新发送("+printnr+")");
        $('#sendMa').attr({ "onclick": null });
    }
}

function goReg(){
    window.location.href="/reg.html";
}

function emailCheck(obj) {
    var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{3,3}$/;
    if (!pattern.test(obj)) {
        swal("请输入正确的邮箱地址");
        obj.focus();
        return false;
    }
    return true;
}
