<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm người dùng</title>

</head>
<body>
	<h1>Thêm người dùng</h1>	
	
	<s:form action="storeNguoiDungAction" method="POST" enctype="multipart/form-data" validate="true">
			
	    <s:textfield label="Họ tên" id="hoten" name="hoten"  /> 
		<s:textfield id="sodienthoai" name="sodienthoai" label="Số điện thoại"  />
		<s:textfield id="tendangnhap" name="tendangnhap" label="Tên đăng nhập"  />
		<s:textfield id="matkhau" name="matkhau" label="Mật khẩu"  />
		
		<select id="loaiquyen" name="loaiquyen">
			<option value="">---</option>
	        <option value="KHACH">Khách</option>
	        <option value="ADMIN">Admin</option>
    	</select>
		<s:file name="hinh" label="Chọn hình" accept="image/png, image/jpeg, image/gif"></s:file>
		
		<s:submit/>
	</s:form>	
	
	
	<script>
	
	</script>
</body>
</html>