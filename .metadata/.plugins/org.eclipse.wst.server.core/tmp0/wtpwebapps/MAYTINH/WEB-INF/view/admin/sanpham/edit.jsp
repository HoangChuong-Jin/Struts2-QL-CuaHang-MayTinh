<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa sản phẩm</title>

</head>
<body>
	<h1>Chỉnh sửa sản phẩm</h1>	
	
	<s:form action="updateSanPhamAction" method="POST" enctype="multipart/form-data" validate="true">
		<input type="hidden" name="id" value='<s:property value="sanpham.id"/>'/>	
		
		<s:textfield label="Tên sản phẩm" id="tensanpham" name="tensanpham" value="%{sanpham.tensanpham }"  /> 
		<s:textfield id="mota" name="mota" label="Mô tả" value="%{sanpham.mota }" />
		<s:textfield id="giagoc" name="giagoc" label="Giá gốc" value="%{sanpham.giagoc }" />
		<s:textfield id="giaban" name="giaban" label="Giá bán" value="%{sanpham.giaban }" />
		<s:textfield id="soluongton" name="soluongton" label="Số lượng tồn" value="%{sanpham.soluongton }" />
		Hình: <img width='80' src='./img/<s:property value="sanpham.hinhanh"/>'/><br/>		
		<s:file name="hinh" label="Chọn hình" accept="image/png, image/jpeg, image/gif"></s:file>
		
		<s:textfield id="danhmuc" name="danhmuc" label="Danh mục" value="%{sanpham.danhmuc }" />
		<s:textfield id="thuonghieu" name="thuonghieu" label="Thương hiệu" value="%{sanpham.thuonghieu }" />
		
		<s:submit/>
	</s:form>	
	<script>
	
	</script>
</body>
</html>