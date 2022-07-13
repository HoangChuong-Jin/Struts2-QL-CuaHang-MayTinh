<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
</head>
<body>
<h1>Order</h1>
	
	<s:form action="submitOrderAction" method="POST">
			
	    <s:textfield label="Tên sản phẩm" readonly="true" value='%{sanpham.tensanpham}' /> 
		<s:textfield id="giaban" name="giaban" label="Giá" value='%{sanpham.giaban}' readonly="true" />
		
		<s:textfield id="soluong" name="soluong" label="Số lượng" onchange="tinhthanhtien()"/>
		<s:textfield id="thanhtien" name="thanhtien" label="Thành tiền" readonly="true" />
		
		<input type="hidden" name="idsanpham" value='<s:property value="idsanpham"/>'/>
			
		<s:submit/>
	</s:form>
	
	<script>
	function tinhthanhtien() {
		var soluong = document.getElementById("soluong").value;
		var gia = document.getElementById("giaban").value;
		document.getElementById("thanhtien").value = soluong*gia;
	}
	</script>
</body>
</html>