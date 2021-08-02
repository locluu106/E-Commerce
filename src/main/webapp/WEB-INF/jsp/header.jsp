
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bin Mobile</title>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>    
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick-theme.css" media="all"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/nouislider.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"  media="all"/>     
    </head>
    <body>
        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-right">                  
                        <li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i>Giỏ hàng&emsp;&emsp;</a></li>
                    </ul>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">

                        <ul class="header-links pull-right">                  
                            <li><a href="${pageContext.request.contextPath}/user/homeUser"><i class="fa fa-sign-in"></i>Đăng nhập&emsp;&emsp;</a></li>
                        </ul>

                        <ul class="header-links pull-right">                  
                            <li><a href="${pageContext.request.contextPath}/register"><i class="fa fa-registered"></i>Đăng Kí&emsp;&emsp;</a></li>
                        </ul>

                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">


                        <ul class="header-links pull-right">
                            <li><a href="${pageContext.request.contextPath}/user/homeUser"><i></i>Chào: ${lastName}&emsp;&emsp;</a></li>
                        </ul>
                        <ul class="header-links pull-right">                        
                            <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i>Đăng xuất&emsp;&emsp;</a></li>
                        </ul>
                    </c:if>
                    
                </div>
            </div>
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="${pageContext.request.contextPath}/home" class="logo">
                                    <img src="${pageContext.request.contextPath}/img/bin.png" width="50%" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
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
