<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>星座</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/star/baraja.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/custom.css" />
    <script type="text/javascript" src="/resources/js/star/modernizr.custom.79639.js"></script>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>


    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <script src="/resources/js/star/star.js"></script>

    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">

    <link rel="stylesheet" href="/resources/css/start_/start_.css">


    <style type="text/css">
        .container {
            margin: 10px auto;
        }
        .container .body {
            padding: 0px 10px;
            position: relative;
            padding-left: 250px;
        }
        .nav-second {
            position: fixed;
            width: 250px;
            float: left;
            margin-left: -50px;
            z-index: 100;
        }
        @media only screen and (max-width: 768px) {
            .container .body {
                padding: 0px;
            }
        }
    </style>
</head>
<body>
<a class="create_" target="_blank" onclick="test( ($('#user_id').val()) )"><i class="ic">创建星座</i></a>
<div class="container ">
<div class="nav-second">
    <div id="sui_nav2" class="sui-nav">
        <%--<button class="create_" id="show_table" onclick="test( ($('#user_id').val()) )">创建星座</button>--%>
        <%--<div  id="paihang_div">--%>
        <%--</div>--%>
        <script type="text/javascript">
            var topbar;
            $(function() {
                topbar = $('#sui_nav').SuiNav({});
                var navbar = $('#sui_nav2').SuiNav({});
                $('.MenuOpen').click(function() {
                    topbar.show();
                });
            });
            function test(user_id){
                if(user_id == ""){
                    $.confirm({
                        content:'先登录'
                    })
                    return false;
                }
                $.confirm({
                    animation:'scaleY',
                    content:'<form id="uploadForm" action="/star/create.json" method="post" enctype="multipart/form-data">' +
                            ' <label>输入星座(一个用户只能创建一个):</label> ' +
                            '<input  type="text" id="star_userid" name="star_userid" value="'+user_id+'" style="display: none">'+
                            '<input  type="text" id="star_name" name="star_name" placeholder="星座" class="form-control">'+
                            '<label>输入星座描述(描述不当内容将被删除):</label>'+
                            '<textarea rows="10" cols="4" placeholder="星座描述" class="form-control" id="star_des" name="star_des"></textarea>'+
                            '<label>输入星座时间段例如：4.21～5.20</label>'+
                            '<input type="text" id="star_time" name="star_time" placeholder="星座时间段" class="form-control">'+
                            '<label>上传星座图片:</label>'+
                            '<input  type="file" name="photo" id="photo">' +
                            '</form>',
                    title: '创建星座',
                    theme: 'white',
                    contentLoaded: function(data, status, xhr){
                        var self = this;
                        setTimeout(function(){
                        }, 1500);
                    },
                    confirm: function (){
                        if($('#star_name').val() ==0 || $('#star_des').val() ==0 ||
                                $('#star_time').val() ==0 ||  $('#photo').val() == ''){
                            $.alert('请填写完整');
                            return false;
                        }else{
                            $("#uploadForm").submit();
                            location.href="/star.html";
                        }
                    },
                    cancel: function (){
                    },
                    closeAnimation: 'scaleY'
                });
            }

        </script>
    </div>
</div>
    </div>
<div class="container">
    <section class="main">
        <nav class="actions">
            <%--<span id="nav-fanOther4">展开</span>--%>
            <%--<span id="add">Add items</span>--%>
        </nav>
        <div class="baraja-demo">
            <ul id="baraja-el" class="baraja-container">
                <c:forEach var="starlist" items="${starlist}">
                <li><img src="http://101.201.235.59:8087/pic/${starlist.photo}"/><h4>${starlist.starName}</h4><p>${starlist.starTime}</p></li>
                </c:forEach>
            </ul>
        </div>
        <nav class="actions light">
            <span id="nav-prev">下一张</span>
            <span id="nav-next">上一张</span>
            <span id="close">关闭</span>
            <span id="nav-fan5">展开</span>

        </nav>
    </section>

</div>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/resources/js/star/jquery.baraja.js"></script>
<script type="text/javascript">
$(function() {

    var $el = $( '#baraja-el' ),
            baraja = $el.baraja();

    // navigation
    $( '#nav-prev' ).on( 'click', function( event ) {
        baraja.previous();
    } );
    $( '#nav-next' ).on( 'click', function( event ) {
        baraja.next();
    } );
    // simple fan
    // playing with different origins and ranges
    $( '#nav-fan5' ).on( 'click', function( event ) {
        baraja.fan( {
            speed : 500,
            easing : 'ease-out',
            range : 100,
            direction : 'right',
            origin : { x : 50, y : 200 },
            center : true
        } );

    } );
    $( '#nav-fanOther4' ).on( 'click', function( event ) {
        baraja.fan( {
            speed : 500,
            easing : 'ease-out',
            range : 90,
            direction : 'right',
            origin : { minX : 20, maxX : 80, y : 100 },
            center : true,
            translation : 60,
            scatter : true
        } );

    } );
    // close the baraja
    $( '#close' ).on( 'click', function( event ) {
        baraja.close();
    } );
    // example of how to add more items
    $( '#add' ).on( 'click', function( event ) {

        if( $( this ).hasClass( 'disabled' ) ) {
            return false;
        }

        $( this ).addClass( 'disabled' );

        baraja.add( $('<li><img src="images/6.jpg" alt="image6"/><h4>Serenity</h4><p>Truffaut wes anderson hoodie 3 wolf moon labore, fugiat lomo iphone eiusmod vegan.</p></li><li><img src="images/7.jpg" alt="image7"/><h4>Dark Honor</h4><p>Chillwave mustache pinterest, marfa seitan umami id farm-to-table iphone.</p></li><li><img src="images/8.jpg" alt="image8"/><h4>Nested Happiness</h4><p>Minim post-ironic banksy american apparel iphone wayfarers.</p></li><li><img src="images/9.jpg" alt="image9"/><h4>Cherry Country</h4><p>Sint vinyl Austin street art odd future id trust fund, terry richardson cray.</p></li>') );

    } );

});
(function() {
    function init() {
        var speed = 330,
                easing = mina.backout;

        [].slice.call ( document.querySelectorAll( '#grid > a' ) ).forEach( function( el ) {
            var s = Snap( el.querySelector( 'svg' ) ), path = s.select( 'path' ),
                    pathConfig = {
                        from : path.attr( 'd' ),
                        to : el.getAttribute( 'data-path-hover' )
                    };

            el.addEventListener( 'mouseenter', function() {
                path.animate( { 'path' : pathConfig.to }, speed, easing );
            } );

            el.addEventListener( 'mouseleave', function() {
                path.animate( { 'path' : pathConfig.from }, speed, easing );
            } );
        } );
    }
    init();
})();
</script>
</body>
</html>