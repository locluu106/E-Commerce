<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!-- Start header section -->
<jsp:include page = "./header/header.jsp" flush = "true" />

<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Sửa sản phẩm</div>
                        <hr>

                        <mvc:form method="post" modelAttribute="productDetais" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/admin/update-Product" >

                            <div class="form-group">
                                <label for="input-2">ID</label>
                                <div>
                                    <mvc:input path="productId" class="form-control"
                                               id="input-1" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="input-1">Loại sản phẩm</label>
                                <mvc:select path="category.categoryId" items="${categoryList}"   class="form-control"></mvc:select>
                                </div>


                                <div class="form-group">
                                    <label for="input-2">Tên sản phẩm</label>
                                    <div>
                                    <mvc:input path="name" class="form-control" id="input-1" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="input-1">Mức giá</label>
                                <mvc:input path="priceFormatted"  class="form-control" id="input-1" />
                                
                            </div>
                            <div class="form-group">
                                <label for="input-1">Số Lượng sản phẩm</label>
                                <mvc:input path="numberProduct" type="text" class="form-control" id="input-1" />
                            </div>

                            <div class="form-group">
                                <label for="input-2">Màu sản phẩm</label>
                                <div>
                                    <mvc:input path="color" type="text" class="form-control" id="input-1" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="input-2">Ram</label>
                                    <div class="input-group">
                                    <mvc:input path="ram" type="text" class="form-control" id="input-1" />


                                    </div>
                                </div>
                                

                                <div class="form-group"> 
                                    <label for="input-1">Ảnh sản phẩm</label> 
                             
                                    <input type="file" class="form-control"  name="file">
                                </div>           


                                <div class="form-footer">
                                    <button class="btn btn-danger">
                                        <a href="#">Hủy</a>
                                    </button>

                                    <button type="submit" class="btn btn-success">Cập nhật</button>
                                </div>
                        </mvc:form>


                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>

<jsp:include page = "./footer/footer.jsp" flush = "true" />
