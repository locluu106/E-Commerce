<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fashion Hub Ecommerce Category Bootstrap Responsive Website Template| Payment :: w3layouts</title>
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

        <link href="<c:url value='/resources/css/owl.carousel.min.css.css'/>" rel="stylesheet">                               
        <link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">        
        <link href="<c:url value='/resources/css/shop.css'/>" rel="stylesheet">             
        <link href="css/style.css" type="text/css" rel="stylesheet" media="all">    
        <link href="css/fontawesome-all.min.css" rel="stylesheet">
        <link href="css/chekcout.css" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Elsie+Swash+Caps:400,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">

    </head>

    <body>
        <!-- header -->
        <jsp:include page="../homeHeader.jsp" />
        <!-- inner banner -->
        <div class="ibanner_w3 pt-sm-5 pt-3">
            <h4 class="head_agileinfo text-center text-capitalize text-center pt-5">
                <span>f</span>ashion
                <span>h</span>ub</h4>
        </div>
        <!-- //inner banner -->
        <!-- breadcrumbs -->
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">Billing Address</li>
            </ol>
        </nav>
        <!-- //breadcrumbs -->
        <!--Payment-->

        <section class="payment_w3ls py-5">
            <div class="container">
                <div class="privacy about">
                    <h5 class="head_agileinfo text-center text-capitalize pb-5">
                        <span>b</span>illing Address</h5>
                    <!--/tabs-->
                    <div class="responsive_tabs innfpage-tabs">
                        <div id="horizontalTab">
                    
                            <div class="resp-tabs-container">
                               
                                <div class="col-md-8 address_form">
                                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                                        <mvc:form modelAttribute="customer"  action="${pageContext.request.contextPath}/payment" method="post">
                                            <div class="creditly-wrapper wrapper">
                                                <div class="information-wrapper">
                                                    <div class="first-row form-group">
                                                        <div class="controls">
                                                            <label class="control-label">Full name: </label>
                                                            <input <mvc:input path="customerName" required="true" class="billing-address-name form-control"/>>
                                                        </div>
                                                        <div class="card_number_grids">
                                                            <div class="card_number_grid_left">
                                                                <div class="controls">
                                                                    <label class="control-label">Address</label>
                                                                    <input <mvc:input path="customerAddress" required="true" class="form-control"/>>
                                                                </div>
                                                            </div>
                                                            <div class="card_number_grid_right">
                                                                <div class="controls">
                                                                    <label class="control-label" for="email">Email </label>
                                                                    <input type="email" <mvc:input path="customerEmail" required="true" class="form-control"/>>
                                                                </div>
                                                            </div>
                                                            <div class="clear"> </div>
                                                        </div>
                                                        <div class="controls">
                                                            <label class="control-label">Phone </label>
                                                            <input  <mvc:input path="customerPhone" required="true" class="form-control" /> >
                                                        </div>
                                                        <div class="controls">
                                                            <label class="control-label">Sex </label>
                                                            <mvc:select path="sex" items="${sex}"  class="form-control"/>
                                                        </div>
                                                        
                                                    </div>
                                                        <input class="btn btn-primary submit" type="submit" value="Payment"> 
                                                </div>
                                            </div>
                                        </mvc:form>
                                    </c:if>
                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        <mvc:form modelAttribute="users"  action="${pageContext.request.contextPath}/payment" method="post">
                                            <div class="creditly-wrapper wrapper">
                                                <div class="information-wrapper">
                                                    <div class="first-row form-group">
                                                        <div class="controls">
                                                            <label class="control-label">Full name: </label>
                                                            <input value="${users.customer.customerName}" class="form-control security-code" >
                                                        </div>
                                                        <div class="card_number_grids">
                                                            <div class="card_number_grid_left">
                                                                <div class="controls">
                                                                    <label class="control-label">Address:</label>
                                                                    <input value="${users.customer.customerAddress}" class="form-control security-code">
                                                                </div>
                                                            </div>
                                                            <div class="card_number_grid_right">
                                                                <div class="controls">
                                                                    <label class="control-label">Email: </label>
                                                                    <input value="${users.customer.customerEmail}" class="form-control security-code" disabled>
                                                                </div>
                                                            </div>
                                                            <div class="clear"> </div>
                                                        </div>
                                                        <div class="controls">
                                                            <label class="control-label">Phone: </label>
                                                            <input value="${users.customer.customerPhone}" class="form-control security-code" disabled >
                                                        </div>

                                                        <input type="submit" value="Payment"/>
                                                        <p style="color: red">${errorMessage}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </mvc:form>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>                                                                      
        </section>


        <%@include file="homeFooter.jsp" %>


        <script src="js/jquery-2.2.3.min.js"></script>

        <script>
            $(document).ready(function () {
                $('ul li.dropdown').hover(function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
                }, function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
                });
            });
        </script>

        <script src="js/easy-responsive-tabs.js"></script>
        <script>
            $(document).ready(function () {
                $('#horizontalTab').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion           
                    width: 'auto', //auto or any width like 600px
                    fit: true, // 100% fit in a container
                    closed: 'accordion', // Start closed if in accordion view
                    activate: function (event) { // Callback function if tab is switched
                        var $tab = $(this);
                        var $info = $('#tabInfo');
                        var $name = $('span', $info);
                        $name.text($tab.text());
                        $info.show();
                    }
                });
            });
        </script>

        <script src="js/creditly.js"></script>
        <link rel="stylesheet" href="css/creditly.css" type="text/css" media="all" />

        <script>
            $(function () {
                var creditly = Creditly.initialize(
                        '.creditly-wrapper .expiration-month-and-year',
                        '.creditly-wrapper .credit-card-number',
                        '.creditly-wrapper .security-code',
                        '.creditly-wrapper .card-type');

                $(".creditly-card-form .submit").click(function (e) {
                    e.preventDefault();
                    var output = creditly.validate();
                    if (output) {

                        console.log(output);
                    }
                });
            });
        </script>

        <script src="js/move-top.js"></script>
        <script src="js/easing.js"></script>
        <script>
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();

                    $('html,body').animate({
                        scrollTop: $(this.hash).offset().top
                    }, 1000);
                });
            });
        </script>

        <script>
            $(document).ready(function () {


                $().UItoTop({
                    easingType: 'easeOutQuart'
                });

            });
        </script>
        <script src="js/SmoothScroll.min.js"></script>

    </body>

</html>