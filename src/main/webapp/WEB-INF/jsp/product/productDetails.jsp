<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <title>Fashion Hub Ecommerce Category Bootstrap Responsive Website Template| Womens :: w3layouts</title>
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
        
        <link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/shop.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/owl.carousel.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/flexslider.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
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
                <li class="breadcrumb-item">
                    <a href="#">Product Details</a>
                </li>

            </ol>
        </nav>
        <div class="innerf-pages section py-5">
            <div class="container">
                <div class="row my-sm-5">
                    <div class="col-lg-4 single-right-left">
                        <div class="grid images_3_of_2">
                            <div class="flexslider1">
                                <ul class="slides">
                                    <c:forEach var="image" items="${productDetails.images}">
                                        <li data-thumb="#">
                                            <div class="thumb-image">                                               
                                                <img src="<c:url value='/images/${image.imagesName}'/>"  data-imagezoom="true" alt=" " class="img-fluid">
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 mt-lg-0 mt-5 single-right-left simpleCart_shelfItem">
                        <h3>${productDetails.productDetailsName}</h3>
                        <div class="caption">                           
                            <div class="clearfix"> </div>
                            <h6>${productDetails.priceFormatted} $</h6>
                        </div>
                        <div class="desc_single">
                            <h5>Description</h5>
                        </div>
                        <div class="d-sm-flex justify-content-between">
                            <div class="occasional">
                                <h5 class="sp_title mb-3">Highlights</h5>
                                <ul class="single_specific">
                                    <li> Size
                                        <span>${productDetails.size.sizeName}</span>
                                    <li> Color
                                        <span>${productDetails.color.colorName}</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="occasion-cart">
                            <div class="chr single-item single_page_b">

                                <button  class="hub-cart phub-cart btn">
                                    <a class="fa fa-cart-plus" aria-hidden="true" 
                                       href="<c:url value='/addToCart/${productDetails.productDetailsId}'/>">
                                    </a>
                                </button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section singlep_btm pb-5">
            <div class="container">
                <div class="new_arrivals">
                    <h4 class="rad-txt text-capitalize">you may also be interested in
                    </h4>
                    <div class="card-group my-5">
                        <c:forEach var="productdetails" items="${productDetailsList}">
                            <div class="card product-men p-3">
                                <div class="men-thumb-item">
                                    <img src="<c:url value='/images/${productdetails.images[0].imagesName}'/>" alt="img" class="card-img-top">
                                    <div class="men-cart-pro">
                                        <div class="inner-men-cart-pro">
                                            <a href="${pageContext.request.contextPath}/details/${productdetails.productDetailsId}" class="link-product-add-cart">Quick View</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body  py-3 px-2">
                                    <h5 class="card-title text-capitalize">${productdetails.productDetailsName}</h5>
                                    <div class="card-text d-flex justify-content-between">
                                        <p class="text-dark font-weight-bold">${productdetails.priceFormatted} $</p>
                                    </div>
                                </div>
                                <!-- card footer -->
                                <div class="card-footer d-flex justify-content-end">
                                    <form action="#" method="post">
                                        <button  class="hub-cart phub-cart btn">
                                            <a class="fa fa-cart-plus" aria-hidden="true" 
                                               href="<c:url value='/addToCart/${productdetails.productDetailsId}'/>">
                                            </a>                                               
                                        </button>    
                                    </form>
                                </div>
                            </div>
                        </c:forEach>                    
                    </div>
                </div>
            </div>
        </div>
        <
        <%@include file="footerProduct.jsp" %>
        <script src="<c:url value='/resources/js/jquery-2.2.3.min.js'/>"></script>
        <script>
            $(document).ready(function () {
                $('ul li.dropdown').hover(function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
                }, function () {
                    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
                });
            });
        </script>
        <script src="<c:url value='/resources/js/jquery.flexslider.js'/>"></script>
        <script>
            $(window).load(function () {
                $('.flexslider1').flexslider({
                    animation: "slide",
                    controlNav: "thumbnails"
                });
            });
        </script>
        <script src="<c:url value='/resources/js/responsiveslides.min.js'/>"></script>
        <script>
            $(function () {
                $("#slider3").responsiveSlides({
                    auto: false,
                    pager: true,
                    nav: false,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });
            });
        </script>
        <script src="<c:url value='/resources/js/minicart.js'/>"></script>
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
        <script src="<c:url value='/resources/js/imagezoom.js'/>"></script>
        <script src="<c:url value='/resources/js/move-top.js'/>"></script>
        <script src="<c:url value='/resources/js/easing.js'/>"></script>
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
        <script src="<c:url value='/resources/js/SmoothScroll.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
    </body>
</html>