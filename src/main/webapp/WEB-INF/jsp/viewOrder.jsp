<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<style>
    #loader {
        transition: all 0.3s ease-in-out;
        opacity: 1;
        visibility: visible;
        position: fixed;
        height: 100vh;
        width: 100%;
        background: #fff;
        z-index: 90000;
    }

    #loader.fadeOut {
        opacity: 0;
        visibility: hidden;
    }



    .spinner {
        width: 40px;
        height: 40px;
        position: absolute;
        top: calc(50% - 20px);
        left: calc(50% - 20px);
        background-color: #333;
        border-radius: 100%;
        -webkit-animation: sk-scaleout 1.0s infinite ease-in-out;
        animation: sk-scaleout 1.0s infinite ease-in-out;
    }

    @-webkit-keyframes sk-scaleout {
        0% { -webkit-transform: scale(0) }
        100% {
            -webkit-transform: scale(1.0);
            opacity: 0;
        }
    }

    @keyframes sk-scaleout {
        0% {
            -webkit-transform: scale(0);
            transform: scale(0);
        } 100% {
            -webkit-transform: scale(1.0);
            transform: scale(1.0);
            opacity: 0;
        }
    }
</style>
</head>
<body class="app">
    <main class='main-content bgc-grey-100' >
        <div id='mainContent'>
            <div class="container-fluid">

                <div class="row">
                    <div class="col-md-12">
                        <div class="bgc-white bd bdrs-3 p-20 mB-20">
                            <h4 class="c-grey-900 mB-20"  style="padding-bottom: 50px;padding-top: 50px;">
                                Đơn hàng của bạn:
                            </h4>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Ngày đặt Hàng</th>
                                        <th scope="col">Địa chỉ giao hàng </th>
                                        <th scope="col">Tiền đợn hàng</th>
                                        <th scope="col">Trạng thái đơn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="orders" items="${ordersList}">
                                    <tr>
                                        <th>${orders.orderDate}</th>
                                        <th>${orders.user.customer.address}</th>
                                        <td>${orders.payment[0].amountFormatted}₫</td>
                                        <td>${orders.orderStatus}</td>
                                        <td><a href="${pageContext.request.contextPath}/viewOrder/${orders.ordersId}">Chi tiết</a></td>
                                    </tr>
                                   
                                    
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


    <jsp:include page="footer.jsp"/>