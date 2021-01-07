

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

    <body>   
        <div>
            <div class="agilemodal-dialog modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1>
                            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">fh
                            </a>
                        </h1>
                        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
                        
                    </div>
                    <div class="modal-body  pt-3 pb-5 px-sm-5">
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <img src="images/p3.png" class="img-fluid" alt="login_image" />
                            </div>
                            <div class="col-md-6">
                                <form action="j_spring_security_check" method="post">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">User Name</label>
                                        <input type="text" name="username" required="true"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Password</label>

                                        <input type="password" name="password" required="true"/><br>
                                    </div>
                                    <div class="right-w3l">
                                        <input type="submit" class="form-control" value="Login">
                                        <input type="hidden" name="${_csrf.parameterName}" 
                                               value="${_csrf.token}"/>
                                    </div>
                                </form>
                                    <a href="${pageContext.request.contextPath}/register">
                                        <p>Do not have an account ?<i>sign up</i></p>
                                    </a>
                                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                    <p style="color:red;">Error:
                                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
                                    </c:if> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
    </body>
</html>
