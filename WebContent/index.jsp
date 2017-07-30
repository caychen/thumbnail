<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>	
	<div class="header">
		<h2>-----上传图片-----</h2>
	</div>
	<div class="body">
		<form action="thumbnail.action" method="post" enctype="multipart/form-data">
			<h2>请选择需要上传的图片</h2>
			<div>
				<input type="file" name="image" />
				<input type="submit" value="上传" />
			</div>
		</form>
	</div>
</body>
</html>