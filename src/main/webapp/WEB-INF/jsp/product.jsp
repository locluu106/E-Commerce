<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<div id="breadcrumb" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                
            </div>
        </div>
    </div>
</div>
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- Product main img -->
            <div class="col-md-5 col-md-push-2">
                <div id="product-main-img">
                    <div class="product-preview">
                       <img src="<c:url value='/images/${product.images}'/>" alt="">
                    </div>

                </div>
            </div>

            <div class="col-md-2  col-md-pull-5">
                <div id="product-imgs">
                    <div >
                        
                    </div>


                </div>
            </div>

            <div class="col-md-5">
                <div class="product-details">
                    <h2 class="product-name">${product.name} </h2>
                    <div>
                        <h3 class="product-price">${product.priceFormatted}₫</h3>
                    </div>
                    <ul class="product-links">
                        <li>Bộ nhớ :</li>
                        <li>${product.ram}</li>								
                    </ul>
                    <ul class="product-links">
                        <li>Màu :</li>
                        <li>${product.color}</li>
                    </ul>
                    <br>
                    <c:choose>
                        <c:when test="${product.numberProduct >= 1}">
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn" ><a  href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="fa fa-shopping-cart"></a> Thêm vào giỏ hàng</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <span class="product-available"> <c:out value="Hết hàng" /></span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="col-md-12">
                <div id="product-tab">
                    <ul class="tab-nav">
                        <li class="active"><a data-toggle="tab" href="#tab1"></a></li>								
                    </ul>
                    <div class="tab-content">
                        <div id="tab1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-md-12">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-title text-center">
                        <h3 class="title">Sản phẩm khác</h3>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="row">
                        <div class="products-tabs">
                            <div id="tab2" class="tab-pane fade in active">
                                <div class="products-slick" data-nav="#slick-nav-2">
                                    <c:forEach var="product" items="${productDetailsList}">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="<c:url value='/images/${product.images}'/>" alt="" style="width: 200px">
                                                <div class="product-label">
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">Category</p>
                                                <h3 class="product-name"><a>${product.name}</a></h3>
                                                <h4 class="product-price">${product.priceFormatted}₫</h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="quick-view" >
                                                        <i class="fa fa-eye" ></i>
                                                        <span class="tooltipp"><a href="${pageContext.request.contextPath}/details/${product.productId}">Chi tiết</a></span>
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><a href="<c:url value='/addToCart/${product.productId}'/>" >Thêm</a></button>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div id="slick-nav-2" class="products-slick-nav"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp" /> 