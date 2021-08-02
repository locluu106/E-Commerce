<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Đăng Kí</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick-theme.css" media="all"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/nouislider.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"  media="all"/>     
    </head>
    <body>
        <header>
            <div id="top-header">
                <div class="container">
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <ul class="header-links pull-right">                  
                            <li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                        <ul class="header-links pull-right">                  
                            <li><a href="${pageContext.request.contextPath}/user/homeUser"><i class="fa fa-sign-in"></i>Đăng nhập&emsp;&emsp;</a></li>
                        </ul>

                        <ul class="header-links pull-right">                  
                            <li><a href="${pageContext.request.contextPath}/register"><i class="fa fa-registered"></i>Đăng Kí&emsp;&emsp;</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <ul class="header-links pull-left">                        
                            <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i>Đăng xuất</a></li>
                        </ul>
                    </c:if>
                </div>
            </div>
            <div id="header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="${pageContext.request.contextPath}/home" class="logo">
                                    <img src="${pageContext.request.contextPath}/img/bin.png" width="50%" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="header-search">
                                <mvc:form action="${pageContext.request.contextPath}/search" method="get"  >  
                                    <input class="input"  name ="searchText" type="text" value="${searchText}"  placeholder="bạn tìm gì..">
                                    <button class="search-btn">Tìm</button>
                                </mvc:form>
                            </div>
                        </div>
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <nav id="navigation">
            <div class="container">
                <div id="responsive-nav">
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <c:forEach var="category" items="${category}">
                            <li>
                                <a href="${pageContext.request.contextPath}/category/${category.name}">${category.name}</a></li>
                        </c:forEach>  
                    </ul>
                </div>
            </div>
        </nav>
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <label for="create-account">
                                <span></span>
                            </label>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            
                            <form:form  modelAttribute="user" action="${pageContext.request.contextPath}/newUser" method="post"> 		
                                <div class="caption">
                                    <h3>Đăng kí tài khoản</h3>
                                    <br><br>
                                    <form:input class="input" type="text" path="username" placeholder="Tên tài khoản"  required="true"/><br>
                                    <form:input class="input" type="password" path="password" placeholder="Mật khẩu"  required="true"/><br>
                                    <form:input class="input" type="text" path="customer.name" placeholder="Họ tên" required="true"/><br>
                                    <form:input class="input" type="text" path="customer.email" placeholder="Email"   pattern="[^ @]*@[^ @]*"/><br>
                                    <form:input class="input" type="text" path="customer.phoneNumber" placeholder="Số điện thoại" required="true"/><br>
                                    <form:input class="input" type="date" path="customer.birthdate" placeholder="Ngày sinh" required="true"/><br>
                                    <form:input class="input" type="text" path="customer.address" placeholder="Địa chỉ" required="true"/><br>
                                    
                                </div>
                                <div class="row">
                                    <div class="newsletter">
                                        <button class="newsletter-btn"><i class="fa fa-sign-in"></i> Đăng Kí</button>
                                    </div>
                                </div>
                            </form:form>
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="newsletter" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p></p>
                            <form>
                            </form>
                            <ul class="newsletter-follow">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer id="footer">
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">About Us</h3>
                                <p></p>
                                <ul class="footer-links">
                                    <li><a href="#"><i class="fa fa-map-marker"></i>Morocco</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+212696805712</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>ihssanehatim@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Categories</h3>
                                <ul class="footer-links">
                                    <li><a href="#">Hot deals</a></li>
                                    <li><a href="#">Laptops</a></li>
                                    <li><a href="#">Smartphones</a></li>
                                    <li><a href="#">Cameras</a></li>
                                    <li><a href="#">Accessories</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="clearfix visible-xs"></div>
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Information</h3>
                                <ul class="footer-links">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Contact Us</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Orders and Returns</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="#">My Account</a></li>
                                    <li><a href="#">View Cart</a></li>
                                    <li><a href="#">Wishlist</a></li>
                                    <li><a href="#">Track My Order</a></li>
                                    <li><a href="#">Help</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="bottom-footer" class="section">
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <ul class="footer-payments">
                                <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                                <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                            </ul>
                            <span class="copyright">
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved  <i class="fa fa-heart-o" aria-hidden="true"></i> by IHSSANE HATIM
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/nouislider.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
