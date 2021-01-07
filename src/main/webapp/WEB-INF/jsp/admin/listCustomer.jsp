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
                                
                                <li class="active">List Customer</li>
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
                                    <strong class="card-title">List Customer</strong>
                                </div>
                                
                                <div class="card-body">
                                    <table id="bootstrap-data-table-export" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Address</th>
                                                <th>Phone</th>                                                    
                                                <th>Email</th>
                                                <th>Birth Day</th>
                                                <th>Sex</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="customer" items="${customerList}">
                                                <tr>
                                                    <td>${customer.customerId}</td>
                                                    <td>${customer.customerName}</td>
                                                    <td>${customer.customerAddress}</td>
                                                    <td>${customer.customerPhone}</td>                                                        
                                                    <td>${customer.customerEmail}</td>
                                                    <td>${customer.customerBirthDate}</td>
                                                    <td>${customer.sex}</td>                                                                                                                      
                                                    <td class="actions">
                                                        <a href="${pageContext.request.contextPath}/editCustomer/${customer.customerId}" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                                    </td>
                                                    <td class="actions">
                                                        <a href="${pageContext.request.contextPath}/deleteCustomer/${customer.customerId}" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
                                                    </td>
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
