<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Contact Start -->
	<div class="container-fluid">
		<h2 class="section-title position-relative text-uppercase  mb-4">
			<span class="bg-secondary" style="margin-left: 630px">Add
				Products</span>
		</h2>
		<div class="row" style="margin-left: 400px;">
			<div class="col-lg-8 mb-5">
				<div class="contact-form bg-light p-30">
					<div ></div>
					<form action="ProductController" method="post"  enctype="multipart/form-data">

						<div class="control-group">
							Product Name: <input type="text" class="form-control"
								name="pname"  placeholder="Product Name" />
						</div>
						<div class="control-group">
							Product Category: <input type="text" class="form-control"
								name="pcategory"  placeholder="Product Category"
								/>
							
						</div>
						<div class="control-group">
							Product Model: <input type="text" class="form-control"
							name="pmodel" placeholder="Product Model"  />
							
						</div>
						<div class="control-group">
							Product Price: <input type="text" class="form-control" name="pprice"
								 placeholder="Product Price" />
							
						</div>
						<div class="control-group">
							Product Description: <input type="text" class="form-control"
								placeholder="Product Description" name="pdesc" />
							
						</div>
						<div class="control-group">
							Product Image: <input type="file" class="form-control" name="image"
								placeholder="Product Image"  />
							
						</div>
						<div>
							<button class="btn btn-primary py-2 px-4" type="submit"
								 name="action" value="addtoproduct">Add
								to Product</button>

						</div>
					</form>
				</div>
			</div>
</body>
</html>