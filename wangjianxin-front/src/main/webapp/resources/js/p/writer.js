function fabu(){
    var context = $('#customized-buttonpane').html();
    var title = $('#title').text();
    var tag = $("#article_tag").text();
    if(check(context,title)){
        if(checkTag(tag)){
            $.ajax({
                url:'/p/insertArticle.json',
                type:'post',
                data:{
                    title:title,
                    context:context,
                    tag:tag
                },
                success:function(data){
                    if(data == 1){
                        $.alert('发布成功');
                        location.href="/p/p.htm";
                        return false;
                    }else if(data == 2){
                        $.alert("发布过多，请稍后")
                    }
                    else{
                        $.alert('发生错误，sorry');
                    }
                }
            })
        }else{
         $.alert('标签不正确(中文四个字以内，不含符号)');
        }
    }else{
        $.alert('不能提交哦');
    }
}
function checkLogin(){
    $.ajax({
        url:'/p/checkLogin.json'
        ,success:function(data){
            if(data == 99){
            }else{
                $.alert("请登录");
                location.href = '/login.html';
            }
        }
    })

}
function checkTag(tag){
    var reg = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
    if(tag.length >4 || tag.length == 0){
        return false;
    }
    else if(!reg.test(tag)){
        return false;
    }else{
        return true;
    }
}
function check(c,t){
    if(c.length == 0 || t.length == 0 ){
        return false;//为空
    }else{
        return true;
    }
}
function loadmore(){
    var num = $('#loadmore').val();
    initP('p_item',num);
    num++;
    $('#loadmore').val(num);
}
function initP(id,num){

    $.ajax({
        url:"/p/initp.json",
        data: {
            pagenum: num,
            pagesize: 10
        },
        success: function(data){
            if(data.c.length == 0 ){
                $('#loadmore_result').text("已经到底啦")
            }
            var innerHtml = $('#'+id+'');
            for(var i = 0; i < data.c.length; i++){
                var obj = data.c[i];
                var item = '<div class="border" id="item_'+i+'">';
                    item += '<div class="author">';
                    item +=  '<a class="avatar"><img src="http://101.201.235.59:8087/pic/sss.jpg" class="author_img"/></a>';
                    item +=  '<div class="name">';
                    item +=  '<a>'+obj.name+'</a>';
                    item +=  '<span>'+formatDate(obj.time)+'</span>';
                    item +=  '</div>';
                    item +=  '</div>';
                    item += '<a class="title" onclick="detial('+obj.id+')">'+obj.p_title+'</a>';
                    item += '<p class="context">'+context(obj.p_context)+'</p>';
                    item += '<div class="meta">';
                        item +=         '<a class="context_tag">'+obj.tag+'</a>';
                        item +=     '<a target="_blank">';
                        item +=       '<i class="iconfont">游览'+obj.look+'</i>';
                        item +=      '</a>';
                        item +=     '<a target="_blank">';
                        item +=         '<i class="iconfont">喜欢'+obj.favour+'</i>';
                        item +=         '</a>';
                        item +=     '<a target="_blank">';
//                        item +=       '<i class="iconfont">10</i>';
                        item +=     '</a>';
                        item +=    '</div>';
                    item += '<div>';
                innerHtml.append(item);
            }
            console.log("q")
            console.log(data)
        }


    })

}

function formatDate(dates) {
    var date = new Date(parseInt(dates.time, 10));
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
}
function getD(json){
    var date = new Date(parseInt(json.time, 10));
    formatDate(date);
}
function context(str){
    if(str.length>10){
        s=str.substring(0,100)+"...";
        return s;
    }else{
        return str;
    }
}
function goWriter(){
    if($('#user_id').val().length>0){
        location.href="/p/writer.htm"
    }else{
        $.alert('请登录');
    }
}

function detial(id){
    location.href = '/p/detial/'+id+''
}
function howwords(user_id){

    $.ajax({
        url:'/p/howword.json',
        data:{
            user_id:user_id
        },
        success:function(data){
            console.log(data)

        }
    })

}
function remove(){
    alert();
    $('#article_tag').text().replace(/[^\u4E00-\u9FA5]/g,'')
}
