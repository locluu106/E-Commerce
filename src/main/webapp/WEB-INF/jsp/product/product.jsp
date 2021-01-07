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
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <link href="//fonts.googleapis.com/css?family=Elsie+Swash+Caps:400,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">

    </head>

    <body>
        <jsp:include page="../homeHeader.jsp" />
        <div class="ibanner_w3 pt-sm-5 pt-3">
            <h4 class="head_agileinfo text-center text-capitalize text-center pt-5">
                <span>f</span>ashion
                <span>h</span>ub</h4>
        </div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">Product</li>
            </ol>
        </nav>
        <div class="innerf-pages section">
            <div class="fh-container mx-auto">
                <div class="row my-lg-5 mb-5">
                    <%@include file="gridleft.jsp" %>
                    <div class="col-lg-9 mt-lg-0 mt-5 right-product-grid">
                        <div class="card-group">
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
                                        <div class="card-body  py-3 px-2">
                                            <h5 class="card-title text-capitalize">${productdetails.productDetailsName}</h5>
                                            <div class="card-text d-flex justify-content-between">
                                                <p class="text-dark font-weight-bold">${productdetails.priceFormatted} $</p>
                                                <p hidden>${productdetails.productDetailsId}</p>
                                            </div>
                                        </div>
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
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footerProduct.jsp" %>    

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

                }
            </script>
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
            <script src="js/jquery-ui.js"></script>
            <script>
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

                });
            </script>
            <script src="js/bootstrap.js"></script>
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
            <script src="js/SmoothScroll.min.js"></script>
    </body>
</html>