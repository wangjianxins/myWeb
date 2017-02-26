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
  var reg_mob = $('#reg_mob').val();
  var pass =   $('#reg_pass').val();
  var name =  $('#reg_name').val();
    var ma =  $('#reg_ma').val();
    if(reg_mob.length >0 && pass.length>0 && name.length>0){
            $.ajax({
                url:"/reg.json",
                type:"get",
                data:{
                    mob:reg_mob,
                    pass:pass,
                    name:name,
                    ma:ma
                },
                success: function (data) {
                    if(data == 1){
                        swal("注册成功");
                        window.location.href="/";
                        return ;
                    }if(data == 98){
                        swal("此手机号已被注册");
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
        swal("信息填完整哦");
    }
}
function sendMa(){
    secs = 35;
    $('#sendMa').disabled=true;
    var mob = $('#reg_mob').val();
    if(checkMobile(mob)){
        $.ajax({
            url:"/send/mob.json",
            type:"get",
            data:{
                mob:mob,
                user_ip:returnCitySN["cip"]
            },
            success :function (data){
                if(data.a == 1){
                    swal("此手机号已注册");
                    return false;
                }else{
                    if(data.c == 100){
                        swal("发送成功");
                        ma = data.b;
                    }else if(data.c ==102){
                        swal("手机格式不正确");
                    }
                    else if(data.c == 101){
                        swal("验证失败")
                    }
                    else if(data.c == 104){
                        swal("内容未审核");
                    }
                    else if(data.c == 107){
                        swal("ip限制");
                    }else if(data == 111){
                        swal("当前时间段禁止短信发送");
                    }
                    else if(data.c == 108){
                        swal("手机号发送频率持续过高，黑名单屏蔽数日");
                    }else if(data.c == 120){
                        swal("系统升级");
                    }else if(data.c == 106){
                        swal("网站账户余额不足，加QQ731461008告诉他吧");
                    }else{
                        swal("发送失败");
                    }
                    for (var i = 1; i <= secs; i++) {
                        window.setTimeout("update(" + i + ")", i * 1000);
                    }
                }
            }
        })

    }else{
        swal("手机格式不正确");
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
function
    checkMobile(str) {
    if(!(/^1[34578]\d{9}$/.test(str))){
        return false;
    }else{
        return true;
    }
}
