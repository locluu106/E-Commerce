
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <header>
            <div class="container">
                <nav class="top_nav d-flex pt-3 pb-1">
                    <h1>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">fh
                        </a>
                    </h1>
                    <div class="w3ls_right_nav ml-auto d-flex">
                        <mvc:form action="${pageContext.request.contextPath}/search" method="get"  class="nav-search form-inline my-0 form-control">   
                            <input class="form-control input-lg" style="background-color: white;" name ="searchText" type="text" value="${searchText}"  placeholder="Search" />
                            <input class="btn btn-outline-secondary  ml-3 my-sm-0" type="submit" value="Searchs">
                        </mvc:form>        
                        <!-- search form -->
                        <div class="nav-icon d-flex">
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/user/infomation" >
                                    <i class="fas fa-user "></i>                        
                                </a>
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/logout">
                                    <i class="fas fa-sign-out-alt"></i>
                                </a>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/user/infomation" >
                                    <i class="far fa-user"></i>
                                </a>
                            </c:if>
                            <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/cart" >
                                <i class="fas fa-shopping-bag"></i>
                            </a>
                        </div>
                    </div>
                </nav>

                <nav class="navbar navbar-expand-lg navbar-light justify-content-center">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mx-auto text-center">
                            <li class="nav-item">
                                <a class="nav-link  active" href="/DemoECommerce">Home
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item dropdown has-mega-menu" style="position:static;">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Men's clothing</a>
                                <div class="dropdown-menu" style="width:50%;">
                                    <div class="px-0 container">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <c:forEach var="product" items="${productList}">
                                                    <a class="dropdown-item" href="<c:url value='/productType/${product.productId}'/>">${product.productName}</a>

                                                </c:forEach>                                                                                             
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown has-mega-menu" style="position:static;">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Women's clothing</a>
                                <div class="dropdown-menu" style="width:50%">
                                    <div class="px-0 container">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/productType/${5}/${2}">Tunic</a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/productType/${6}/${2}">Casual </a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/productType/${7}/${2}">Women Jeans Test</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown has-mega-menu" style="position:static;">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Kids Clothing</a>
                                <div class="dropdown-menu" style="width:60%">
                                    <div class="container">
                                        <div class="row w3_kids  py-3">
                                            <div class="col-md-4 ">
                                                <span class="bg-light">Boy's Clothing</span>                        
                                            </div>                                           
                                            <div class="col-md-4">
                                                <span>Girl's Clothing</span>                                                
                                            </div>                                           
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
            </div>
        </header>
    </body>
</html>
