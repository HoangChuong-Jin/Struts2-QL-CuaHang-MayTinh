<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa đơn hàng</title>

</head>
<body>
	<h1>Chỉnh sửa đơn hàng</h1>	
	
	<s:form action="updateDonHangAction" method="POST" enctype="multipart/form-data" validate="true">
		<input type="hidden" name="id" value='<s:property value="donhang.id"/>'/>	
		
		<s:textfield label="Người dùng" id="nguoidung_id" name="nguoidung_id" value="%{donhang.nguoidung_id }"  /> 
		<s:textfield id="sanpham_id" name="sanpham_id" label="Sản phẩm" value="%{donhang.sanpham_id }" />
		<s:textfield id="soluong" name="soluong" label="Số lượng" value="%{donhang.soluong }" />
		<s:textfield id="giaban" name="giaban" label="Giá bán" value="%{donhang.giaban }" />
		<s:textfield id="ngay" name="ngay" label="Ngày mua" value="%{donhang.ngay }" />
		<s:textfield id="tongtien" name="tongtien" label="Tổng tiền" value="%{donhang.tongtien }" />
		<s:textfield id="ghichu" name="ghichu" label="Ghi chú" value="%{donhang.ghichu }" />
		<s:textfield id="trangthai" name="trangthai" label="Trạng thái" value="%{donhang.trangthai }" />
		<s:submit/>
	</s:form>	

</body>
</html>