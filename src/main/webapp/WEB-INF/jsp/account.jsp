
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">

                <ul class="breadcrumb-tree">
                    <label for="create-account">
                        <span></span>
                        Sign in
                    </label>

                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-6">


                <div class="form-group">

                    <form action="j_spring_security_check" method="post">			
                        <div class="caption">
                            <p>Nhập tài khoản</p>
                            <input class="input" type="text" name="username" placeholder="Enter Your Username" required>
                            <input class="input" type="password" name="password" placeholder="Enter Your Password" required>
                        </div>
                        <div class="row">
                            <div class="newsletter">
                                <button class="newsletter-btn"><i class="fa fa-sign-in"></i> Đăng nhập</button>
                            </div>
                        </div>
                        
                    </form>
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                <p style="color:red;">Error:
                                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
                                </c:if> 
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>