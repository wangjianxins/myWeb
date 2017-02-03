<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
	<meta charset="UTF-8">
	<title>上传头像</title>
    <script src="/resources/js/jquery-1.10.2.min.js"></script>
    <link href="/resources/upload/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/upload/cropper/cropper.min.css" rel="stylesheet">
	<link href="/resources/upload/sitelogo/sitelogo.css" rel="stylesheet">
	<script src="/resources/upload/cropper/cropper.min.js"></script>
	<script src="/resources/upload/sitelogo/sitelogo.js"></script>
	<script src="/resources/upload/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="ibox-content">
		<div class="row">
			<div id="crop-avatar" class="col-md-6">
				<div class="avatar-view" title="Change Logo Picture">
			    	<img src="" alt="Logo" id="me_img">
			    </div>
			</div>
		</div>
	</div>
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form class="avatar-form" action="/me/uploadByArticle.json" enctype="multipart/form-data" method="get">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title" id="avatar-modal-label">Change Logo Picture</h4>
				</div>
				<div class="modal-body">
					<div class="avatar-body">
						<div class="avatar-upload">
							<input class="avatar-src" name="avatar_src" type="hidden">
							<input class="avatar-data" name="avatar_data" >
							<label for="avatarInput">图片上传</label>
							<input class="avatar-input" id="avatarInput" name="smal" type="file">
                        </div>
						<div class="row">
							<div class="col-md-9">
								<div class="avatar-wrapper"></div>
							</div>
							<div class="col-md-3">
								<div class="avatar-preview preview-lg"></div>
								<%--<div class="avatar-preview preview-md"></div>--%>
								<%--<div class="avatar-preview preview-sm"></div>--%>
                                <input class="avatar-input" id="sss" name="pictemplate" type="file">
                            </div>
						</div>
						<div class="row avatar-btns">
							<div class="col-md-9">
								<div class="btn-group">
									<button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>
								</div>
								<div class="btn-group">
									<button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>
								</div>
							</div>
							<div class="col-md-3">
								<button class="btn btn-success btn-block avatar-save" type="submit"><i class="fa fa-save"></i> 保存修改</button>
							</div>
						</div>
					</div>
				</div>
  		</form>
  	</div>
  </div>
</div>

<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>

<script>
    $.ajax({
     url:'/me/initPhtot.json'
        ,success:function(data){
                $('#me_img').attr('src','http://101.201.235.59:8087/pic/'+data);
        }
    })
</script>
</body>
</html>