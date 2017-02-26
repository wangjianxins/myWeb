function star_detial(id){
    location.href="/star/detial/"+id
}


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
            '<input  type="file" name="photo" id="uploadfile">' +
            '</form>',
        title: '创建星座',
        theme: 'white',
        contentLoaded: function(data, status, xhr){
            var self = this;
            setTimeout(function(){
            }, 1500);
        },
        confirm: function (){
            alert($('#uploadfile').v())
            if($('#star_name').val() ==0 || $('#star_des').val() ==0 ||
                $('#star_time').val() ==0 ||  $('#uploadfile').val() == ''){
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