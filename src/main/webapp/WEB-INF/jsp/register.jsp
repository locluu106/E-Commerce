<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
    <!--<![endif]-->

    <head>

        <title>Fashion Hub</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8" />
        <meta name="keywords" content="Fashion Hub Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
        <link href="css/shop.css" type="text/css" rel="stylesheet" media="all">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
        <link href="css/fontawesome-all.min.css" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Elsie+Swash+Caps:400,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">


    </head>

    <body class="bg-dark">
        <div>
            <div class="agilemodal-dialog modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1>
                            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">fh
                            </a>
                        </h1>
                        <h5 class="modal-title" id="exampleModalLabel">Register</h5>

                    </div>
                    <div class="modal-body  pt-3 pb-5 px-sm-5">
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <img src="images/p3.png" class="img-fluid" style="margin-bottom: 1rem;"alt="login_image" />
                                <a href="${pageContext.request.contextPath}/user/infomation ">
                                    <i class="form-control " style="text-align: center;background-color: #f0475f; color:white; ">Login</i>
                                </a>
                            </div>
                            
                            <div class="col-md-6">
                                <mvc:form modelAttribute="user" action="${pageContext.request.contextPath}/newUser" method="post"> 
                                    <div style="display: flex">
                                        <div class="form-group">
                                            <label class="col-form-label">UserName</label>
                                            <input <mvc:input path="username" type="text" class="form-control"  required="true" /> 
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Password</label>
                                            <input <mvc:input path="password" type="password" class="form-control" /> 
                                        </div> 
                                    </div>
                                        
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Your Name</label>
                                        <input <mvc:input path="customer.customerName" type="text" class="form-control" placeholder="Full Name" />
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Email</label>
                                        <input <mvc:input path="customer.customerEmail" type="email" class="form-control" placeholder="abc@gmail.com" />
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Phone</label>
                                        <input <mvc:input path="customer.customerPhone" type="text" class="form-control" />
                                    </div>

                                    <div class="form-group">
                                        <label class="col-form-label">Birth Date</label>
                                        <input <mvc:input path="customer.customerBirthDate" type="date" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Address</label>
                                        <input <mvc:input path="customer.customerAddress" type="text" class="form-control" />
                                    </div>
                                    <div class="right-w3l">
                                        <input type="submit" class="form-control" value="registration">
                                        
                                    </div>
                                        <p style="color: red">${errorMessage1}</p>
                                        <p style="color: greenyellow">${errorMessage}</p>
                                </mvc:form>
                                
                                    
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
