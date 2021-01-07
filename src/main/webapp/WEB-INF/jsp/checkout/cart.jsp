    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <title>Fashion Hub Ecommerce Category Bootstrap Responsive Website Template| Checkout :: w3layouts</title>
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
        <link href="<c:url value='/resources/css/owl.carousel.min.css.css'/>" rel="stylesheet">    
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"> 
        <link href="<c:url value='/resources/css/fontawesome-all.min.css'/>" rel="stylesheet">
        <link href="css/fontawesome-all.min.css" rel="stylesheet">
        <link href="<c:url value='/resources/css/checkout.css'/>" rel="stylesheet"> 
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
                <li class="breadcrumb-item active" aria-current="page">Cart</li>
            </ol>
        </nav>
        <section class="checkout_wthree py-sm-5 py-3">
            <div class="container">
                <div class="check_w3ls">
                    <div class="d-sm-flex justify-content-between mb-4">
                        <h4>review your order
                        </h4>

                    </div>
                    <div class="checkout-right">
                        <table class="timetable_sub">
                            <thead>
                                <tr>
                                    <th>SL No.</th>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="orderDetails" items="${order.orderDetailsList}">
                                    <tr class="rem1">
                                        <td class="invert">1</td>
                                        <td class="invert-image">
                                            <a href="#">
                                                <img src="<c:url value='/images/${orderDetails.productDetails.images[0].imagesName}'/>" alt=" " class="img-responsive">
                                            </a>
                                        </td>
                                        <td class="invert">
                                            <div class="quantity">
                                                <div class="quantity-select">
                                                    <form action="${pageContext.request.contextPath}/update/${orderDetails.productDetails.productDetailsId}" method="post">
                                                        <input type="hidden" name="productDetailsId
                                                               value="<c:out value='${orderDetails.productDetails.productDetailsId}'/>">               
                                                        <input type="number" id="quantity"  value="<c:out value='${orderDetails.quantity}'/>" name="quantity" min="1" max="5">
                                                        <input type="submit" value="update ">
                                                    </form>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="invert">${orderDetails.productDetails.productDetailsName}</td>
                                        <td class="invert">${orderDetails.productDetails.priceFormatted} $</td>
                                        <td class="invert">
                                            <div class="rem">
                                                <div >
                                                    <a class="close1" href="${pageContext.request.contextPath}/remove/${orderDetails.productDetails.productDetailsId}"></a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="row checkout-left mt-5">
                        <form class="col-md-6 checkout-left-basket">
                            <h4>Continue to basket</h4>
                            <c:set var="s" value="0"></c:set>
                            <c:forEach var="orderDetails" items="${order.orderDetailsList}">
                                <c:set var="s" value="${s + orderDetails.total}"></c:set>
                                    <ul>
                                        <li>${orderDetails.productDetails.productDetailsName}
                                        <i>------------</i>
                                        <i>${orderDetails.quantity}</i>
                                        <span>$ ${orderDetails.productDetails.priceFormatted} </span>
                                    </li>
                                </ul>
                            </c:forEach>
                            <br><br>
                            <ul>
                                <li>Total
                                    <i>-</i>
                                    <span>$ ${s}</span>
                                </li>
                            </ul>
                                <br><br>
                                <div style="text-align: center; padding-left: 10px;padding-right: 10px;">
                                    <a href="${pageContext.request.contextPath}/home" class="link-product-add-cart">Continue Shopping</a>
                                </div>
                           
                        </form>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <form style="text-align: center;" class="col-md-6" action="${pageContext.request.contextPath}/inforCustomer" method="get">
                                <input class="link-product-add-cart" type="submit" value="inforCustomer">
                                <p style="color: red"> ${errorMessage}</p>
                            </form>   
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <form style="text-align: center;" class="col-md-6" action="${pageContext.request.contextPath}/inforCustomer" method="get" >                              
                                <input class="link-product-add-cart" type="submit" value="Order">
                                <p style="color: red"> ${errorMessage}</p>
                            </form> 
                        </c:if>
                    </div>
                </div>                                                        
            </div>                                      
        </section>

        <jsp:include page="../homeFooter.jsp" />

        <script>
            $('.value-plus').on('click', function () {
                var divUpd = $(this).parent().find('.value'),
                        newVal = parseInt(divUpd.text(), 10) + 1;
                divUpd.text(newVal);
            });

            $('.value-minus').on('click', function () {
                var divUpd = $(this).parent().find('.value'),
                        newVal = parseInt(divUpd.text(), 10) - 1;
                if (newVal >= 1)
                    divUpd.text(newVal);
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
        <script src="js/bootstrap.js"></script>
</html>