<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>图片处理结果</h4>
	<table width = "100%">
		<tr>
			<td width="50%" align="center"><img src="${pageContext.request.contextPath }${imageUrl}" width="500" title="处理前图片"/></td>
			<td width="50%" align="center"><img src="${pageContext.request.contextPath }${thumbImageUrl}" title="处理后图片"/></td>
		</tr>
	</table>
	<hr/>
	<a href="${pageContext.request.contextPath }/">返回</a>
</body>
</html>