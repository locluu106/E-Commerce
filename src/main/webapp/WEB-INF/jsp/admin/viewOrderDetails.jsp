<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/admin/apple-icon.png">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/admin/favicon.ico">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/themify-icons/css/themify-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/selectFX/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/vendors/jqvmap/dist/jqvmap.min.css">


        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/style.css">

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

            </div>

            <div class="content mt-3">
                <div class="animated fadeIn">
                    <div class="row">

                        <div class="col-md-12">
                            <div class="card">

                                <div class="card-body">
                                    <table id="bootstrap-data-table-export" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Quantity</th>
                                                <th>Price</th>   
                                                <th>Product</th>   
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="orderDetails" items="${orderList}">
                                                <tr>
                                                    <td>${orderDetails.orderDetailsId}</td>
                                                    <td>${orderDetails.quantity}</td>
                                                    <td>${orderDetails.unitPrice}</td>                                                        
                                                    <td>${orderDetails.productDetails.productDetailsName}</td>  
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
        <script src="${pageContext.request.contextPath}/admin/vendors/jquery/dist/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/popper.js/dist/umd/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/assets/js/main.js"></script>


        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/jszip/dist/jszip.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/pdfmake/build/vfs_fonts.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendors/datatables.net-buttons/js/buttons.colVis.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/assets/js/init-scripts/data-table/datatables-init.js"></script>
    </body>
</html>
