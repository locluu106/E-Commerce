
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/shop.css" type="text/css" rel="stylesheet" media="all">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/fontawesome-all.min.css" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Elsie+Swash+Caps:400,900" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">

    <body>
        <%@include file="homeHeader.jsp" %>
        <%@include file="homeMainBanner.jsp" %>
        <section id="colorlib-subscribe" >
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="section_title_container text-center">
                            <div class="section_title" text-align: center"><h1>
                                    Thank you for your order. Your order will be delivered in the fastest time</h1></div>

                            <div><a href="${pageContext.request.contextPath}/homepage">Home</a></div>
                        </div>
                    </div>
                </div> 
            </div>
        </section>
        <%@include file="homeFooter.jsp" %>
    </body>
</html>
