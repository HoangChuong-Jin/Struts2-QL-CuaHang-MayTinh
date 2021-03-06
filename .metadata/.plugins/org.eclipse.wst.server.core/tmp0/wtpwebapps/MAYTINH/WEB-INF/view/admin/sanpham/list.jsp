<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
<style>
	table,td,tr,th
	{
		border: 1px solid;
	}
	table
	{
		width:100%;
	}
</style>
</head>
<body>
	<h1>Danh sách sản phẩm</h1>
	
	 <s:if test="hasActionMessages()">
	      <p>
	          <s:actionmessage /> 
	      </p>
	  </s:if>
	<p><a href="createSanPhamAction">Thêm mới</a>  <a href="homeAdminAction">Trang chủ</a></p>
	
	<table >
	<tr>
	<th>Tên sản phẩm</th>
	<th>Mô tả</th>
	<th>Giá gốc</th>
	<th>Giá bán</th>
	<th>Số lượng</th>
	<th>Hình ảnh</th>
	<th>Danh mục</th>
	<th>Thương hiệu</th>
	<th>Lượt xem</th>
	<th>Lượt mua</th>
	<th>Sửa</th>
	<th>Xoá</th>
	</tr>

	
	<s:iterator var="sanpham" value="sanphamlist" >
	<tr>
		<td><s:property value="tensanpham"/></td>
		<td><s:property value="mota"/></td>
		<td><s:property value="giagoc"/></td>
		<td><s:property value="giaban"/></td>
		<td><s:property value="soluongton"/></td>
		<td><img width='80' src='./img/<s:property value="hinhanh"/>'/></td>
		<td><s:property value="danhmuc"/></td>
		<td><s:property value="thuonghieu"/></td>
		<td><s:property value="luotxem"/></td>
		<td><s:property value="luotmua"/></td>

		<td><a href='editSanPhamAction?id=<s:property value="id"/>'>Chỉnh sửa</a></td>
		<td><a href='deleteSanPhamAction?id=<s:property value="id"/>' onclick="return confirm('Bạn chắc chắn xóa?')">Xóa</a></td>
	</tr>
	</s:iterator>
	
	</table>
</body>
</html>