<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

    <head>
        <title>Fashion Hub Ecommerce Category Bootstrap Responsive Website Template| Women:: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8" />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/shop.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/owl.carousel.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/flexslider.css'/>" rel="stylesheet">
        <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <link href="//fonts.googleapis.com/css?family=Elsie+Swash+Caps:400,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">

    </head>

    <body>

        <!-- header -->
        <jsp:include page="../homeHeader.jsp" />
        <!-- //header -->

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
                <li class="breadcrumb-item active" aria-current="page">Women's Clothing</li>
            </ol>
        </nav>
        <!-- //breadcrumbs -->
        <!-- Shop -->
        <div class="innerf-pages section">
            <div class="fh-container mx-auto">
                <div class="row my-lg-5 mb-5">
                    <!-- grid left -->
                    <%@include file="gridleft.jsp" %>
                    <!-- //grid left -->
                    <!-- grid right -->
                    <div class="col-lg-9 mt-lg-0 mt-5 right-product-grid">
                        <!-- card group  -->
                        <div class="card-group">
                            <!-- card -->
                            <c:forEach var="productdetails" items="${productDetailsList}">
                                <div class="col-lg-3 col-sm-6 p-0">
                                    <div class="card product-men p-3">
                                        <div class="men-thumb-item">
                                            <img src="<c:url value='/images/${productdetails.images[0].imagesName}'/>" alt="img" class="card-img-top">
                                            <div class="men-cart-pro">
                                                <div class="inner-men-cart-pro">
                                                    <a href="details/${productdetails.productDetailsId}" class="link-product-add-cart">Quick View</a>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- card body -->
                                        <div class="card-body  py-3 px-2">
                                            <h5 class="card-title text-capitalize">${productdetails.productDetailsName}</h5>
                                            <div class="card-text d-flex justify-content-between">
                                                <p class="text-dark font-weight-bold">${productdetails.priceFormatted} $</p>
                                                <p hidden>${productdetails.productDetailsId}</p>
                                            </div>
                                        </div>
                                        <!-- card footer -->
                                        <div class="card-footer d-flex justify-content-end">
                                            <button  class="hub-cart phub-cart btn">
                                                <a class="fa fa-cart-plus" aria-hidden="true" 
                                                   href="<c:url value='/addToCart/${productdetails.productDetailsId}'/>">
                                                </a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <!-- //card -->
                            <!-- card -->


                        </div>
                    </div>
                </div>
            </div>
            <!--// Shop -->
            <%@include file="footerProduct.jsp" %>
            <!-- //footer -->
            <!-- sign up Modal -->
            <div class="modal fade" id="myModal_btn" tabindex="-1" role="dialog" aria-labelledby="myModal_btn" aria-hidden="true">
                <div class="agilemodal-dialog modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Register Now</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body pt-3 pb-5 px-sm-5">
                            <div class="row">
                                <div class="col-md-6 align-self-center">
                                    <img src="images/p3.png" class="img-fluid" alt="login_image" />
                                </div>
                                <div class="col-md-6">
                                    <form action="#" method="post">
                                        <div class="form-group">
                                            <label for="recipient-name1" class="col-form-label">Your Name</label>
                                            <input type="text" class="form-control" placeholder=" " name="Name" id="recipient-name1" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-email" class="col-form-label">Email</label>
                                            <input type="email" class="form-control" placeholder=" " name="Email" id="recipient-email" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="password1" class="col-form-label">Password</label>
                                            <input type="password" class="form-control" placeholder=" " name="Password" id="password1" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="password2" class="col-form-label">Confirm Password</label>
                                            <input type="password" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="">
                                        </div>
                                        <div class="sub-w3l">
                                            <div class="sub-agile">
                                                <input type="checkbox" id="brand2" value="">
                                                <label for="brand2" class="mb-3">
                                                    <span></span>I Accept to the Terms & Conditions</label>
                                            </div>
                                        </div>
                                        <div class="right-w3l">
                                            <input type="submit" class="form-control" value="Register">
                                        </div>
                                    </form>
                                    <p class="text-center mt-3">Already a member?
                                        <a href="#" data-toggle="modal" data-target="#exampleModal1" class="text-dark login_btn">
                                            Login Now</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //signup modal -->
            <!-- signin Modal -->
            <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModal1" aria-hidden="true">
                <div class="agilemodal-dialog modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Login</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body  pt-3 pb-5 px-sm-5">
                            <div class="row">
                                <div class="col-md-6 align-self-center">
                                    <img src="images/p3.png" class="img-fluid" alt="login_image" />
                                </div>
                                <div class="col-md-6">
                                    <form action="#" method="post">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Your Name</label>
                                            <input type="text" class="form-control" placeholder=" " name="Name" id="recipient-name" required="">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Password</label>
                                            <input type="password" class="form-control" placeholder=" " name="Password" required="">
                                        </div>
                                        <div class="right-w3l">
                                            <input type="submit" class="form-control" value="Login">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- signin Modal -->
            <!-- js -->
            <script src="js/jquery-2.2.3.min.js"></script>
            <!-- //js -->
            <!-- smooth dropdown -->

            <script>
            $(document).ready(function () {
                $('ul li.dropdown').hover(function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
                }, function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
                });
            });
            </script>
            <!-- //smooth dropdown -->
            <!-- script for password match -->

            <script>
                window.onload = function () {
                    document.getElementById("password1").onchange = validatePassword;
                    document.getElementById("password2").onchange = validatePassword;
                }

                function validatePassword() {
                    var pass2 = document.getElementById("password2").value;
                    var pass1 = document.getElementById("password1").value;
                    if (pass1 != pass2)
                        document.getElementById("password2").setCustomValidity("Passwords Don't Match");
                    else
                        document.getElementById("password2").setCustomValidity('');
                    //empty string means no validation error
                }
            </script>

            <!-- script for password match -->
            <!-- cart-js -->
            <script src="js/minicart.js"></script>

            <script>
                hub.render();

                hub.cart.on('new_checkout', function (evt) {
                    var items, len, i;

                    if (this.subtotal() > 0) {
                        items = this.items();

                        for (i = 0, len = items.length; i < len; i++) {
                        }
                    }
                });
            </script>

            <!-- //cart-js -->
            <!-- price range (top products) -->
            <script src="js/jquery-ui.js"></script>

            <script>
                //<![CDATA[ 
                $(window).load(function () {
                    $("#slider-range").slider({
                        range: true,
                        min: 0,
                        max: 9000,
                        values: [50, 6000],
                        slide: function (event, ui) {
                            $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
                        }
                    });
                    $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

                }); //]]>
            </script>

            <!-- //price range (top products) -->
            <script src="js/bootstrap.js"></script>
            <!-- start-smoth-scrolling -->
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

            <!-- start-smoth-scrolling -->
            <!-- here stars scrolling icon -->

            <script>
                $(document).ready(function () {

                    var defaults = {
                        containerID: 'toTop', // fading element id
                        containerHoverID: 'toTopHover', // fading element hover id
                        scrollSpeed: 1200,
                        easingType: 'linear'
                    };


                    $().UItoTop({
                        easingType: 'easeOutQuart'
                    });

                });
            </script>

            <!-- //here ends scrolling icon -->
            <!-- smoothscroll -->
            <script src="js/SmoothScroll.min.js"></script>
            <!-- //smoothscroll -->

    </body>

</html>