<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
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

	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-12 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Product Image</th>
							<th>Product Name</th>
							<th>Product Price</th>
							<th>Product Category</th>
							<th>Product Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody class="align-middle">
						<%
						List<Product> list = ProductDao.viewProduct();
						%>
						<%
						for (Product p : list) {
						%>
						<tr>
							<td class="align-middle"><img src="images/<%=p.getImage()%>"
								alt="abc" style="width: 100px; height: 100px"></td>
							<td class="align-middle"><%=p.getPname()%></td>
							<td class="align-middle">Rs.<%=p.getPprice()%></td>
							<td class="align-middle"><%=p.getPcategory()%></td>
							<td class="align-middle"><%=p.getPdesc()%></td>
							<td class="align-middle"><a
								href="single-product.jsp?pid=<%=p.getPid()%>"
								class="btn btn-success">Edit</a></td>
							<td class="align-middle"><a
								href="delete-product.jsp?pid=<%=p.getPid()%>"
								class="btn btn-danger">Delete</a></td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Cart End -->

</body>
</html>