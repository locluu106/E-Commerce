<%-- 
    Document   : homeAdminMenu
    Created on : 24 thg 11, 2020, 22:39:22
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/showHomeAdmin"><h2>Fashion Hub</h2></a>
                    <a class="navbar-brand hidden" href="${pageContext.request.contextPath}/admin/showHomeAdmin"><h2>F</h2></a>
                </div>

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/admin/showHomeAdmin"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                        </li>
                        <h3 class="menu-title">UI elements</h3><!-- /.menu-title -->
                        <li>
                            <a href="${pageContext.request.contextPath}/listPro"> <i class="menu-icon fa fa-table"></i>Manufacture</a>
                            <a href="${pageContext.request.contextPath}/listProductDetails"> <i class="menu-icon fa fa-table"></i>Product Details</a>
                            <a href="${pageContext.request.contextPath}/listCustomer"> <i class="menu-icon fa fa-table"></i>Customer</a>
                            <a href="${pageContext.request.contextPath}/listUser"> <i class="menu-icon fa fa-table"></i>User</a>
                            <a href="${pageContext.request.contextPath}/listOrder"> <i class="menu-icon fa fa-table"></i>Order</a>
                            <a href="${pageContext.request.contextPath}/listColor"> <i class="menu-icon fa fa-table"></i>Color</a>
                            <a href="${pageContext.request.contextPath}/listImg"> <i class="menu-icon fa fa-table"></i>Images</a>
                        </li>

                        
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside>
    </body>
</html>
