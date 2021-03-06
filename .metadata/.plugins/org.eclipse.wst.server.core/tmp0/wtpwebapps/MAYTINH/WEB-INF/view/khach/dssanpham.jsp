<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" />
    <style>
        .vertical-nav {
            min-width: 17rem;
            width: 17rem;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            box-shadow: 3px 3px 10px rgba(61, 162, 230, 0.685);
            transition: all 0.9s;
        }
        .page-content {
            width: calc(100%);
            margin-left:0;
            transition: all 0.9s;
        }
          
        /* for toggle behavior */
          
        #sidebar.active {
            margin-left: -17rem;
        }
          
        #content.active {
            width: 100%;
            margin: 0;
        }
          
        @media (max-width: 768px) {
            #sidebar {
                margin-left: -17rem;
            }
            #sidebar.active {
                margin-left: 0;
            }
            #content {
                width: 100%;
                margin: 0;
            }
            #content.active {
                margin-left: 17rem;
                width: calc(100% - 17rem);
            }
        }
        body {
            background: #eef8fc;
            min-height: 100vh;
            overflow-x: hidden;
        }
          
        .separator {
            background:black;
            margin: 3rem 0;
            border-bottom: 1px dashed #fff;
        }
    </style>
    <script>
        $(function() {
            // Sidebar toggle behavior
            $('#sidebarCollapse').on('click', function() {
              $('#sidebar, #content').toggleClass('active');
            });
          });
    </script>
    
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
		<div class="container">
			
			<a class="navbar-brand" href="homeKhachAction">
				<img src="./img/logo.png" width="100" height="40" class="d-inline-block align-top" alt="" />
			</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
	              <li class="nav-item active"><a class="nav-link" href="homeKhachAction"><i class="bi bi-house-fill"></i> Trang chủ</a></li>
	              <li class="nav-item dropdown active">
	                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"> Danh mục</a>
	                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	                      <s:iterator var="danhmuc" value="danhmuclist" >
	                        <a class="dropdown-item" href="groupdanhmuc?iddanhmuc=<s:property value="iddanhmuc"/>"><s:property value="tendanhmuc"/></a>
	                      </s:iterator>
	                    </div>
	              </li>
	              
	        </ul>
	        <!-- tìm kiếm -->
	         <s:form action="TimKiem" method="GET" class="col-sm-5"> 
               
                <div class="input-group mb-0">
                        <input type="search" required class="form-control" name="tukhoa" style="width=300px;" placeholder="Tìm sản phẩm ..." aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn" style="background-color:#FF9933;" type="submit"><i class="bi bi-search  text-white"></i></button>
                    </div>
                </div>
            </s:form>
			<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">
                    <i class="bi bi-person-fill"></i><s:property value="hoten"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#" data-target="#fdoimatkhau" data-toggle="modal"><i class="fa fa-lock"></i> Đổi mật khẩu</a>
                    <a class="dropdown-item" href="#" data-target="#fcapnhathoso" data-toggle="modal"><i class="fa fa-id-card"></i> Cập nhật hồ sơ</a>
                    <a class="dropdown-item" href="lichsuMuaHang"><i class="fa fa-history"></i> Lịch sử mua hàng</a>
                    <a class="dropdown-item" href="logOut" ><i class="fa fa-sign-out"></i> Đăng xuất</a>
                </div>
             </li>
			
			<li class="nav-item "><a class="nav-link" href="logOut" ><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
			</ul>
			</div>
		</div>
	</nav>
<!-- Nội Dung -->
<s:if test="hasActionMessages()"> 
          <div class="alert alert-success alert-dismissible fade show mb-0" role="alert">
            <h6 > <s:actionmessage /></h6>
		</div>
    </s:if>
    <div class="page-content p-3" id="content">
        <div class="container">
            <div class="card">
                <h4 class="card-header">SẢN PHẨM</h4> 
                <div class="card-body">
                    <div class="table-responsive-lg">     
                      <div class="container">
 
		  
	    <div class="row">
		    <s:iterator var="sanpham" value="sanphamlist" >
		    
		   	
		    	<div id="card" class="col-sm-3 px-2 p-2" >
					<div class="card h-100" >
						
						<a href="orderAction?idsanpham=<s:property value="id"/>">
							<img class="card-img-top" src="./img/<s:property value="hinhanh"/>" height="250" alt="">
						</a>
						
					   <div class="text-center mt-2">
					      <h6 ><a class="card-title" href="orderAction?idsanpham=<s:property value="id"/>" ><s:property value="tensanpham"/></a></h6>
					      <h6 class="card-subtitle mb-2 text-danger"><s:property value="%{getText('{0,number,###,##0đ}', {giaban})}"/></h6>
					      <p class="card-text">
					         
					      </p>
					      
					      
					   </div>
					</div>
				</div>
		    	
	    	</s:iterator>
	    	
    	</div>
	   
    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!-- Kết thúc Nội Dung -->
</body>
</html>