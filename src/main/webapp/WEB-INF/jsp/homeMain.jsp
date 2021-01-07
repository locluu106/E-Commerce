
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!-- about -->
        <div class="row no-gutters pb-4" style="margin-left: 110px; margin-right: 110px">
            <div class="col-sm-3">
                <div class="hovereffect">
                    <img class="img-fluid"src="images/a1_1.jpg" alt="">
                    <div class="overlay">
                        <h5>Women's fashion</h5>
                        <a class="info" href="${pageContext.request.contextPath}/women">Shop Now</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="hovereffect">
                    <img class="img-fluid" src="images/a2.jpg" alt="">
                    <div class="overlay">
                        <h5>Men's fashion</h5>
                        <a class="info" href="${pageContext.request.contextPath}/men">Shop Now</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="hovereffect">
                    <img class="img-fluid" src="images/a3.jpg" alt="">
                    <div class="overlay">
                        <h5>Girl's fashion</h5>
                        <a class="info" href="#">Shop Now</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="hovereffect">
                    <img class="img-fluid" src="images/a3.jpg" alt="">
                    <div class="overlay">
                        <h5>Boy's fashion</h5>
                        <a class="info" href="#">Shop Now</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- //about -->
        <!-- product tabs -->
        <section class="tabs_pro py-md-5 pt-sm-3 pb-5" style=" margin-left: 110px; margin-right: 110px ">
            <h5 class="head_agileinfo text-center text-capitalize pb-5">
                <span>s</span>mart clothing</h5>
            <div class="tabs tabs-style-line pt-md-5">
                <nav class="container">
                    
                </nav>
                <!-- Content Panel -->
                <div id="clothing-nav-content" class="tab-content py-sm-5">
                    <div role="tabpanel" class="tab-pane fade show active" id="women" aria-labelledby="women-tab">
                        <div id="owl-demo" class="owl-carousel text-center">
                            <c:forEach var="productdetails" items="${productDetailsList}">
                            <div class="item">
                                <div class="card product-men p-3">
                                    <div class="men-thumb-item">
                                        <img src="<c:url value='/images/${productdetails.images[0].imagesName}'/>" class="card-img-top">
                                        <div class="men-cart-pro">
                                            <div class="inner-men-cart-pro">
                                                <a href="details/${productdetails.productDetailsId}" class="link-product-add-cart">Quick View</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- card body -->
                                    <div class="card-body  py-3 px-2">
                                        <h5 class="card-title text-capitalize">${productdetails.productDetailsName}</h5>
                                        <div class="card-text d-flex justify-content-between">
                                            <p class="text-dark font-weight-bold">${productdetails.priceFormatted} $</p>                                          
                                        </div>
                                    </div>
                                    <div class="card-footer d-flex justify-content-end">                                                               
                                            <button  class="hub-cart phub-cart btn">
                                                <a class="fa fa-cart-plus" aria-hidden="true" 
                                                   href="<c:url value='/addToCart/${productdetails.productDetailsId}'/>">
                                                </a>                                               
                                          </button>                                                                                 
                                   </div>
                                </div>
                            </div>
                            </c:forEach>
                            
                            <div class="item">
                                <div class="product-men p-3 text-center">
                                    <img src="images/p2.png" class="img-responsive" alt="" />
                                    <a href="${pageContext.request.contextPath}/product" class="btn btn-lg bg-info text-white">view more</a>
                                </div>
                            </div>
                        </div>
                    </div>                                                                        
                </div>
            </div>
        </section>


    </body>
</html>
