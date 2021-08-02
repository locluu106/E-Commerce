
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" /> 


<div class="section">
    <div class="container">
        <div class="row">

        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Sản phẩm</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav">
                            <li><a href="${pageContext.request.contextPath}/seach-price/${0}/${2000000}" >Dưới 2 Triệu</a></li>
                            <li><a  href="${pageContext.request.contextPath}/seach-price/${2000000}/${4000000}">Từ 2 - 4 Triệu</a></li>
                            <li><a  href="${pageContext.request.contextPath}/seach-price/${4000000}/${7000000}">Từ 4 - 7 Triệu</a></li>
                            <li><a  href="${pageContext.request.contextPath}/seach-price/${7000000}/${13000000}">Từ 7 - 13 Triệu</a></li>
                            <li><a  href="${pageContext.request.contextPath}/seach-price/${13000000}">Trên 13 Triệu</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-auto">
                <div class="row">


                    <div class="product-label " style="margin: 0px 10px 0px 10px">
                        <c:forEach var="product" items="${product}">
                            <div class="product"  style="width: 200px;margin: 10px 10px 10px 10px;float: left;"> 
                                <div class="product-img">
                                    <img src="<c:url value='/images/${product.images}'/>" alt="" style="width: 200px;height: 200px;">

                                </div>
                                <div class="product-body">
                                    <p class="product-category">${product.name}</p>
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

                                <c:choose>
                                    <c:when test="${product.numberProduct >= 1}">
                                        <div class="add-to-cart">
                                            <button class=""><a href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="fa fa-shopping-cart">Thêm</a></button>
                                        </div>
                                    </c:when>
                                    <c:otherwise >
                                        <div class="add-to-cart">
                                            <button class=""><a><c:out value="Tạm hết" /></a></button>
                                        </div>

                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="hot-deal" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="hot-deal">
                    <ul >
                        <li>
                            <div>
                            </div>
                        </li>
                        <li>
                            <div>

                            </div>
                        </li>
                        <li>
                            <div>

                            </div>
                        </li>
                        <li>
                            <div>

                            </div>
                        </li>
                    </ul>
                    <h2 ></h2>
                    <p></p>
                    <a></a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Sẩn phẩm bán chạy</h3>
                </div>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">

                                <c:forEach var="product" items="${productSale}">
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
                                        <c:choose>
                                            <c:when test="${product.numberProduct >= 1}">
                                                <div class="add-to-cart">
                                                    <button class=""><a href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="fa fa-shopping-cart">Thêm</a></button>
                                                </div>
                                            </c:when>
                                            <c:otherwise >
                                                <div class="add-to-cart">
                                                    <button class=""><a><c:out value="Tạm hết" /></a></button>
                                                </div>

                                            </c:otherwise>
                                        </c:choose>


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



<jsp:include page="footer.jsp" /> 
