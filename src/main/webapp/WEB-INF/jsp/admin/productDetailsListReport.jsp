<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
    <!--<![endif]-->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Fashion Hub</title>
        <meta name="description" content="Sufee Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="admin/apple-icon.png">
        <link rel="shortcut icon" href="admin/favicon.ico">

        <link rel="stylesheet" href="admin/vendors/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="admin/vendors/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="admin/vendors/themify-icons/css/themify-icons.css">
        <link rel="stylesheet" href="admin/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="admin/vendors/selectFX/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="admin/vendors/jqvmap/dist/jqvmap.min.css">


        <link rel="stylesheet" href="admin/assets/css/style.css">

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <jsp:include page="homeAdminMenu.jsp" />
        <div id="right-panel" class="right-panel">
            <jsp:include page="homeAdminHeader.jsp" />
            <div class="breadcrumbs">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h1>Dashboard</h1>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li><a href="#">Dashboard</a></li>
                                <li><a href="#">Table</a></li>
                                <li class="active">List Products</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content mt-3">
                <div class="animated fadeIn">
                    <div class="row">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">List Products</strong>
                                </div>
                                <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="mb-md">
                                            <a href="./export1"><button>Export</button></a>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div class="card-body">
                                    <table id="bootstrap-data-table-export" class="table table-striped table-bordered">

                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Details</th>
<!--                                                <th>Images</th>-->
                                                <th>Price</th>                                                    
                                                <th>Sex</th>
                                                <th>Age Group</th>
                                                <th>Color</th>
                                                <th>Size</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="productDetails" items="${productDetailsList}">
                                                <tr>
                                                    <td>${productDetails.productDetailsId}</td>
                                                    <td>${productDetails.product.productName}</td>
                                                    <td>${productDetails.productDetailsName}</td>
<!--                                                    <td><img src="${pageContext.request.contextPath}/images/${productDetails.images[0].imagesName}" style="width: 300px; height: 200px"></td>-->
                                                    <td>${productDetails.price}</td>                                                        
                                                    <td>${productDetails.sex.sexName}</td>
                                                    <td>${productDetails.ageGroup.ageName}</td>
                                                    <td>${productDetails.color.colorName}</td>                                                       
                                                    <td>${productDetails.size.sizeName}</td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>


                    </div>
                </div><!-- .animated -->
            </div>
        </div>
        <script src="admin/vendors/jquery/dist/jquery.min.js"></script>
        <script src="admin/vendors/popper.js/dist/umd/popper.min.js"></script>
        <script src="admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="admin/assets/js/main.js"></script>


        <script src="admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="admin/vendors/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="admin/vendors/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
        <script src="admin/vendors/jszip/dist/jszip.min.js"></script>
        <script src="admin/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="admin/vendors/pdfmake/build/vfs_fonts.js"></script>
        <script src="admin/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="admin/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="admin/vendors/datatables.net-buttons/js/buttons.colVis.min.js"></script>
        <script src="admin/assets/js/init-scripts/data-table/datatables-init.js"></script>
    </body>
</html>
