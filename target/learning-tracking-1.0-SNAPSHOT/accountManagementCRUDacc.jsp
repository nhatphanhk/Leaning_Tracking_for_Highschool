    
<%-- 
    Document   : accountManagementNotification
    Created on : Oct 3, 2023, 11:18:28 AM
    Author     : htk09
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700;800;900&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./assets/css/style.css" />
        <title>MS</title>
    </head>
    <body>
        <div class="app">-->
            <!-- header  -->
            <%@ include file="./includes/headerAccountManagement.jsp" %>

            <div class="app-container m-0">
    <div class="grid d-grid">
        <div class="section-m1">
            <div class="row">
                <div class="col">
                    <div class="box-section">
                        <div class="app-home__heading">
                            <div class="header-name">
                                <a href="accountManagementProfile.jsp">
                                    <i class="fa-solid fa-arrow-left"></i>
                                </a>
                                Danh sách học sinh
                                <div class="search-btn-contain"     >
                                    <a
                                        role="button"
                                        class="btn btn-block nav-link"
                                        href="./accountManagementAddAcc.jsp"
                                        ><i class="fa-solid fa-square-plus"></i></a>
                                </div>
                            </div>
                        </div>

                        <div class="app-home__body">
                            <div class="row">
                                <div class="col">
                                    <!-- Student List details  -->
                                    <table class="table table-bordered table-striped">
                                        <thead class="background-primary">
                                            <tr class="text-color-white">
                                                <th>STT</th>
                                                <th>Tài khoản</th>
                                                <th>Mật khẩu</th>
                                                <th>Chức vụ</th>
                                                <th>Sửa</th>
                                                <th>Xóa</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sessionScope.listaccount}" var="a" varStatus="loopStatus">

                                                <tr>
                                                    <td>${loopStatus.index+1}</td>
                                                    <td>${a.email}</td>
                                                    <td>${a.password}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${a.roleid eq 1}">Học sinh</c:when>
                                                            <c:when test="${a.roleid eq 2}">Giáo viên</c:when>
                                                            <c:when test="${a.roleid eq 3}">Quản lí tài khoản</c:when>
                                                            <c:when test="${a.roleid eq 4}">Kế toán</c:when>
                                                            <c:when test="${a.roleid eq 5}">Giám thị</c:when>
                                                            <c:when test="${a.roleid eq 6}">Admin</c:when>
                                                            <c:otherwise>${a.roleid}</c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td>
                                                        <a
                                                            role="button"
                                                            class="btn btn-block nav-link"


                                                            href="updateaccount?email=${a.email}"

                                                            ><i class="fa-solid fa-square-pen"></i></a>
                                                    </td>
                                                    <td><a href=""><i class="fa-solid fa-x"></i></a></td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<%@ include file="./includes/linkJS.jsp" %>
<script src="./assets/js/mycode.js"></script>
</script>
</body>
</html>
