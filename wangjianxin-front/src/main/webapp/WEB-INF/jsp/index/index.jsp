<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<%--<jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>--%>
<head>
		<meta charset="UTF-8">
		<title>萤火之森</title>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/index/sui.css" />
        <!--主页输入框-->
        <link rel="stylesheet" type="text/css" href="/resources/css/myemojiPl.css" />

        <link rel="stylesheet" type="text/css" href="/resources/css/page.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/default.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/normalize.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/style.css" />


    <%--<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>--%>
        <script src="/resources/js/jquery-1.10.2.min.js"></script>
        <script src="/resources/js/index/suimin.js" type="text/javascript" charset="utf-8"></script>
        <script src="/resources/js/myemojiPl.js" ></script>
        <script src="/resources/js/index/index.js" type="text/javascript" charset="utf-8"></script>
        <script src="/resources/js/jquery.page.js" ></script>
        <%--<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>--%>
       <!--alert-->
        <link rel="stylesheet" href="/resources/css/alert/example.css">
        <link rel="stylesheet" href="/resources/css/alert/sweet-alert.css">
        <script src="/resources/js/alert/sweet-alert.js"></script>



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
		<div id="sui_nav" class="sui-nav horizontal">
			<div class="sui-nav-wrapper nav-border nav-line">
				<ul>
					<li><a class="text-primary" onclick="a()"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
					<li><a href="#" class="text-primary" onclick="b()"> 关于</a>
						<ul>
							<li><a href="#"><span class="glyphicon glyphicon-edit"></span> editor</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> pencil</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-saved"></span> Level23</a>
								<span class="indicator">&gt;</span>
								<ul>
									<li><a href="#">Level31</a></li>
									<li><a href="#">Level32</a></li>
									<li class="hide-in-horizontal"><a href="#">Level33</a>
										<ul>
											<li><a href="#">Level331</a></li>
											<li><a href="#">Level332</a></li>
											<li><a href="#">Level333</a></li>
											<li><a href="#">Level334</a></li>
										</ul>
										<span class="indicator">&gt;</span>
									</li>
									<li><a href="#">Level34</a></li>
								</ul>
							</li>
							<li><a href="#"><span class="glyphicon glyphicon-save"></span> Level24</a></li>
						</ul>
					</li>
					<li><a class="text-danger" onclick="c()">star</a></li>
                    <li><a class="text-danger" onclick="m()">music</a></li>

                </ul>

                <ul class="pull-right" id="login_names">
                    <li><a class="text-primary" onclick="d()">登录</a>
                    </li>
                </ul>
                <input type="text" id="user_id" style="display: none"/>
				<ul class="pull-right" id="login_name">
					<li><a id="username" class="text-primary"></a>
                            <ul>
                                <li><a onclick="quit()">注销登录</a></li>
                                <li><a>修改密码</a></li>
                                <li><a>我的消息</a></li>
                                <li><a>其他</a>
                                    <ul>
                                        <li><a>这都能找到</a></li>
                                    </ul>
                                </li>
                            </ul>
					</li>
				</ul>
			</div>
		</div>
		<br />
		<div class="container ">
			<div class="nav-second">
			<div id="sui_nav2" class="sui-nav">
                <button class="MenuOpen btn btn-success" id="show_table">单击此处显示导航</button>
                <div  id="paihang_div">

                </div>
                <script type="text/javascript">
//					document.write(document.getElementById('sui_nav').innerHTML);
					var topbar;
					$(function() {
						topbar = $('#sui_nav').SuiNav({});
						var navbar = $('#sui_nav2').SuiNav({});
						$('.MenuOpen').click(function() {
							topbar.show();
						});
					});
				</script>
			</div>
			</div>
			<div class="body"  id="max">


                    <img src="/resources/images/tishiyu.png" alt=""/>
                    <code id="word">
                        对代码不满足，是任何真正有天才的程序员的根本特征；<br />
                    </code><br/><br/><br/>
                <p>
                    <%--<button class="MenuToggle btn btn-default">单击此处显示/关闭导航</button>--%>
                </p>

                    				<%--<p class="alert alert-info">--%>

                        <%--对代码不满足，是任何真正有天才的程序员的根本特征。--%>
                    				<%--</p>--%>

                <div class="Main">
                    <div class="Input_Box">
                        <div contenteditable="true" class="Input_text" placeholder="在这输入想发表的内容"></div>
                        <%--<textarea placeholder="在这输入想发表的内容"  class="Input_text"></textarea>--%>
                        <div class="Input_Foot">
                            <a class="imgBtn" href="javascript:void(0);">'◡'</a><a class="postBtn">发表</a>
                        </div>
                    </div>
                    <div class="faceDiv">
                        <section class="emoji_container">
                        </section>
                        <section class="emoji_tab"></section>
                    </div>
                </div><br/><br/>
                <!--文字-->
                <div id="context" class="Main">

                </div>
                <div class="tcdPageCode"></div>
                <!--文字结束-->
                <!--分页-->

            </div >

		</div>

        <script>
            $.ajax({
                url:"/artic/count.json",
                type:"get",
                success: function (data){
                    var count =  Math.ceil(data/7);
                    $(".tcdPageCode").createPage({
                        pageCount:count,
                        current:1,
                        backFn:function(p){
                        }
                    });
                }
            })
            show(1,7);
        </script>

        <script>
        var emojiconfig = {
            tieba: {
                name: "贴吧表情",
                path: "/resources/images/tieba/",
                maxNum: 50,
                file: ".jpg",
                placeholder: ":{alias}:",
                alias: {
                    1: "hehe",
                    2: "haha",
                    3: "tushe",
                    4: "a",
                    5: "ku",
                    6: "lu",
                    7: "kaixin",
                    8: "han",
                    9: "lei",
                    10: "heixian",
                    11: "bishi",
                    12: "bugaoxing",
                    13: "zhenbang",
                    14: "qian",
                    15: "yiwen",
                    16: "yinxian",
                    17: "tu",
                    18: "yi",
                    19: "weiqu",
                    20: "huaxin",
                    21: "hu",
                    22: "xiaonian",
                    23: "neng",
                    24: "taikaixin",
                    25: "huaji",
                    26: "mianqiang",
                    27: "kuanghan",
                    28: "guai",
                    29: "shuijiao",
                    30: "jinku",
                    31: "shengqi",
                    32: "jinya",
                    33: "pen",
                    34: "aixin",
                    35: "xinsui",
                    36: "meigui",
                    37: "liwu",
                    38: "caihong",
                    39: "xxyl",
                    40: "taiyang",
                    41: "qianbi",
                    42: "dnegpao",
                    43: "chabei",
                    44: "dangao",
                    45: "yinyue",
                    46: "haha2",
                    47: "shenli",
                    48: "damuzhi",
                    49: "ruo",
                    50: "OK"
                },
                title: {
                    1: "呵呵",
                    2: "哈哈",
                    3: "吐舌",
                    4: "啊",
                    5: "酷",
                    6: "怒",
                    7: "开心",
                    8: "汗",
                    9: "泪",
                    10: "黑线",
                    11: "鄙视",
                    12: "不高兴",
                    13: "真棒",
                    14: "钱",
                    15: "疑问",
                    16: "阴脸",
                    17: "吐",
                    18: "咦",
                    19: "委屈",
                    20: "花心",
                    21: "呼~",
                    22: "笑脸",
                    23: "冷",
                    24: "太开心",
                    25: "滑稽",
                    26: "勉强",
                    27: "狂汗",
                    28: "乖",
                    29: "睡觉",
                    30: "惊哭",
                    31: "生气",
                    32: "惊讶",
                    33: "喷",
                    34: "爱心",
                    35: "心碎",
                    36: "玫瑰",
                    37: "礼物",
                    38: "彩虹",
                    39: "星星月亮",
                    40: "太阳",
                    41: "钱币",
                    42: "灯泡",
                    43: "茶杯",
                    44: "蛋糕",
                    45: "音乐",
                    46: "haha",
                    47: "胜利",
                    48: "大拇指",
                    49: "弱",
                    50: "OK"
                }
            },
            AcFun:{
                name : "AcFun表情",
                path : "/resources/images/AcFun/",
                maxNum : 54,
                file : ".png"
            }
        };
        $('.Main').myEmoji({emojiconfig : emojiconfig});
        $('.Main3').myEmoji();
        $('.Main2').myEmoji();
    </script>
        <script>
            $(document).ready(function()
            {

                $('body').on("click",'.heart',function()
                {

                    var A=$(this).attr("id");
                    var B=A.split("like");
                    var messageID=B[1];
                    var C=parseInt($("#likeCount"+messageID).html());
                    $(this).css("background-position","")
                    var D=$(this).attr("rel");

                    if(D === 'like')
                    {
//                        $("#likeCount"+messageID).html(C+1);
//                        $(this).addClass("heartAnimation").attr("rel","unlike");
                    }
                    else
                    {
//                        $("#likeCount"+messageID).html(C-1);
//                        $(this).removeClass("heartAnimation").attr("rel","like");
//                        $(this).css("background-position","left");
                    }


                });


            });
            $(function () {
                $('#show_table').hide();
                $(window).scroll(function () {
                    var scrollValue = $(window).scrollTop();
                    scrollValue > 100 ? $('#show_table').show() : $('#show_table').hide();
                });
            });
        </script>

    </body>

</html>