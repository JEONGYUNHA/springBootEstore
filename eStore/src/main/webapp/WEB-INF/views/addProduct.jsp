<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Add Product</h1>
		<p class="lead">Fill the below information to add a product:</p>

		<!-- form tag library(action: 하단에서  submit 눌리면 수행될 url/ http post method  -->
		<!-- modle attribute와 밑에 path는  객체가 있으면 객체의 어떤 내용을 가지고 와서 출력하기 위해 어떤 내용을 가지고 올것이냐...-->
		<sf:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" modelAttribute="product" enctype="multipart/form-data">

			<div class="form-group"><!-- grouping 하기 위해 form-group 사용 -->
				<label for="name">Name</label>
				<sf:input path="name" id="name" class="form-control" /><!-- proudct의 name -->
				<sf:errors path="name" cssStyle="color:#ff0000;"/>
			</div>

			<div class="form-group">
				<label for="category">Category : </label>
				<sf:radiobutton path="category" id="category" value="컴퓨터" /> 컴퓨터<!-- proudct의 category -->
				<sf:radiobutton path="category" id="category" value="가전" /> 가전
				<sf:radiobutton path="category" id="category" value="잡화" /> 잡화
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" id="description"
					class="form-control" /><!-- proudct의  description -->
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<sf:textarea path="price" id="price" class="form-control" />
				<sf:errors path="price" cssStyle="color:#ff0000;"/>
			</div>

			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<sf:input path="unitInStock" id="unitInStock" class="form-control" />
				<sf:errors path="unitInStock" cssStyle="color:#ff0000;"/>
			</div>

			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<sf:input path="manufacturer" id="manufacturer" class="form-control" />
				<sf:errors path="manufacturer" cssStyle="color:#ff0000;"/>
			</div>
			
			<div class="form-group">
				<label for="productImage">Upload Picture</label>
				<sf:input path="productImage" id="productImage" type="file" class="form-control" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="<c:url value="/admin/productInventory"/>"
				class="btn btn-dark">Cancel</a>

		</sf:form>
		<br />
	</div>
</div>