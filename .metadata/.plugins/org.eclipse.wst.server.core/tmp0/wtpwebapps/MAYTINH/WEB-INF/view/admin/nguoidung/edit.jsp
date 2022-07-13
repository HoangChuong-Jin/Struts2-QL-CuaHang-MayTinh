<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa người dùng</title>

</head>
<body>
	<h1>Chỉnh sửa người dùng</h1>	
	
	<s:form action="updateNguoiDungAction" method="POST" enctype="multipart/form-data" validate="true">
		<input type="hidden" name="id" value='<s:property value="nguoidung.id"/>'/>	
		
		<s:textfield label="Họ tên" id="hoten" name="hoten" value="%{nguoidung.hoten }"  /> 
		<s:textfield id="sodienthoai" name="sodienthoai" label="Số điện thoại" value="%{nguoidung.sodienthoai }" />
		<s:textfield id="tendangnhap" name="tendangnhap" label="Tên đăng nhập" value="%{nguoidung.tendangnhap }" />
		<s:textfield id="matkhau" name="matkhau" label="Mật khẩu" value="" />
		<s:textfield id="loaiquyen" name="loaiquyen" label="Loại quyền" value="%{nguoidung.loaiquyen }" />
		
		Hình: <img width='80' src='./img/<s:property value="nguoidung.hinhanh"/>'/><br/>		
		<s:file name="hinh" label="Chọn hình" accept="image/png, image/jpeg, image/gif"></s:file>
		
		<s:submit/>
	</s:form>	
	<script>
	
	</script>
</body>
</html>