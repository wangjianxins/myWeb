<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>欢迎登录</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/login/htmleaf-demo.css">
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700,700italic,600'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
	<link rel="stylesheet" href="/resources/css/login/style.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="htmleaf-container">
		<div class="cont_principal">
			<header class="htmleaf-header">
				<div class="htmleaf-links">
					<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家" target="_blank"><span> jQuery之家</span></a>
					<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/css3/ui-design/201603013167.html" title="返回下载页" target="_blank"><span> 返回下载页</span></a>
				</div>
			</header>
		  <div class="cont_join  ">
		    <div class="cont_letras">
		      <p>Login</p>
		      <p>- -</p>
		      <p>Page</p>
		    </div>

		    <div class="cont_form_join">
		      <h2>登录</h2>

		      <p>用户名:</p>    
		      <input type="text" class="input_text" />

		      <%--<p>密　码:</p>    --%>
		      <%--<input type="text" class="input_text" />--%>

		      <p>密码:</p>
		      <input type="password" class="input_text" />
		    </div>
		  
		    <div class="cont_join_form_finish">
		      <h2>Finish <i class="material-icons">&#xE5CA;</i></h2>  
		    </div>

		    <div class="cont_btn_join">
		      <a href="#" onclick='join_1()'>Login</a>
		    </div>
		  </div>
		</div>
	</div>
	
	<script src="/resources/js/login/index.js"></script>
</body>
</html>