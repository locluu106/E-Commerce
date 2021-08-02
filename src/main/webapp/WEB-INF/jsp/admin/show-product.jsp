<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<c:url value="/resources/client/assets" var="url" />


<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <button class="add-catalog">
                    <a href="${pageContext.request.contextPath}/admin/add-Product">Thêm sản phẩm</a>
                </button>
            </div>
             <div class="col-lg-12">
                <button class="add-catalog">
                    <a href="${pageContext.request.contextPath}/admin/add-Category">Thêm Hãng</a>
                </button>
            </div>
                <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách sản phẩm</h5>

                        <mvc:form
                            action="${pageContext.request.contextPath}/admin/searchProduct"
                            method="get" class="form-inline">
                            <input name="searchText" type="text" value="${searchText}"
                                   class="form-control mr-sm-2" />
                            <input class="btn btn-info" type="submit" value="Searchs">
                        </mvc:form>

                        </br>

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>

                                        <th scope="col">ID</th>
                                        <th scope="col">Hãng</th>
                                        <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Hình ảnh</th>

                                        <th scope="col">Giá sản phẩm</th>
                                        <th scope="col">Số Lượng</th>
                                        <th scope="col">Màu</th>
                       
                                        <th scope="col">Ram</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${pagedListHolder.pageList}" var="product">
                                        <tr>
                                            <th scope="row">${product.productId}</th>
                                            <td>${product.category.name }</td>
                                            <td>${product.name }</td>
                                            <td>
                                                <img src="<c:url value='/images/${product.images}'/>" alt="img" class="card-img-top">
                                            </td>
                                            <td><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${product.price}" /> ₫</td>
                                            <td>${product.numberProduct }</td>
                                            <td>${product.color}</td>
                                            <td>${product.ram}</td>
                                            <td>
                                                <button class="btn btn-danger">
                                                    <a
                                                        href="${pageContext.request.contextPath}/admin/DeleteProduct/${product.productId}">Xóa</a>
                                                </button>

                                                <button class="btn btn-success">
                                                    <a
                                                        href="${pageContext.request.contextPath}/admin/edit-Product/${product.productId}">Sửa</a>
                                                </button>

                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                        <c:url value="/admin/show-productDetails/" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>
                        <tg:paging pagedListHolder="${pagedListHolder}"	pagedLink="${pagedLink}" ></tg:paging>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>


<jsp:include page="./footer/footer.jsp" flush="true" />