/**
 * Created by wangjianxin on 2017/2/26.
 */
function updateinfo(){
    var name = $('#username').text();
    var summary = $('#usersummary').text();
    var weixin = $('#userweixin').text();
    $.confirm({
        animation:'scaleY',
        content:'<form id="uploadForm" action="/me/updateinfo.json" method="post">' +
            ' <label>昵称:</label> ' +
            '<input  type="text" id="star_userid" name="star_userid" value="'+user_id+'" style="display: none">'+
            '<input  type="text" id="star_name" name="name" placeholder="昵称" class="form-control" value='+name+'>'+
            '<label>简介:</label>'+
            '<textarea rows="10" cols="4" placeholder="自我描述" class="form-control" id="star_des" name="summary">'+summary+'</textarea>'+
            '<label>微信号</label>'+
            '<input type="text" id="star_time" name="weixin" placeholder="方便联系哦，可以不填写" class="form-control" value='+weixin+'>'+
            '</form>',
        title: '修改资料',
        theme: 'white',
        contentLoaded: function(data, status, xhr){
            var self = this;
            setTimeout(function(){
            }, 1500);
        },
        confirm: function (data){
            if($('#star_name').val() ==0 || $('#star_des').val() ==0 ||
                $('#star_time').val() ==0 ){
                $.alert('请填写完整');
                return false;
            }else{
                $("#uploadForm").submit();
            }
        },
        cancel: function (){
        },
        closeAnimation: 'scaleY'
    });
}

function update(){
    $.ajax({
        ulr:'/me/updateinfo.json',
        data:{
            name:$('#star_name').val(),
            summary:$('#star_des').val(),
            weixin:$('#star_time').val()
        },
        success :function(data){
            if (data ==1 ){
                loca
            }
        }
    })
}