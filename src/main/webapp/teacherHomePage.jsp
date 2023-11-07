<%-- 
    Document   : teacherHomePage
    Created on : Sep 22, 2023, 10:04:15 AM
    Author     : htk09
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <div class="app">
            <!-- header  -->
            <%@ include file="./includes/header.jsp" %>
            <div class="app-container">
                <div class="grid d-grid">
                    <div class="app-home section-m1">
                        <div class="row">
                            <div class="col">
                                <div class="box-section" style="min-height:476px">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <i class="fa-solid fa-folder pe-2 ps-2"></i>
                                            Thông tin cá nhân
                                        </div>
                                    </div>
                                    <div class="app-home__body">
                                        <div class="p-4 info-container">
                                            <div class="row">
                                                <div class="col">
                                                    <div class="card-body text-center student-avatar">
                                                        <img
                                                            class="img-account-profile rounded-circle mb-4 mt-4"
                                                            src="./assets/imgs/user.png"
                                                            alt=""
                                                            />
                                                        <h1 class="mb-4 text-color-gray fw-bolder">
                                                            ${sessionScope.teacher.lastname} ${sessionScope.teacher.firstname}
                                                        </h1>
                                                        <h3 class="mb-4 text-color-gray fw-bold">
                                                            Môn giảng dạy : ${sessionScope.teacher.major}
                                                        </h3>

                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="card-body text-center student-list-info">
                                                        <ul class="list-info mt-4">
                                                            <li class="info-href-contain h3 ms-3 mb-4">
                                                                <a href="teacherProfile.jsp" class="text-color-gray">
                                                                    <i class="fa-solid fa-user me-3"></i>
                                                                    <span>HỒ SƠ GIÁO VIÊN</span>
                                                                </a>
                                                            </li>
                                                            <li class="info-href-contain h3 ms-3 mb-4">
                                                                <a href="student-list" class="text-color-gray">
                                                                    <i class="fa-solid fa-bars me-3"></i>
                                                                    <span>DANH SÁCH HỌC SINH</span>
                                                                </a>
                                                            </li>
                                                            <li class="info-href-contain h3 ms-3 mb-4">
                                                                <a href="crudmark?teacherid=${sessionScope.teacher.teacherid}" class="text-color-gray">
                                                                    <i class="fa-solid fa-award me-3"></i>
                                                                    <span>SỔ ĐIỂM</span>
                                                                </a>
                                                            </li>
                                                            <!--                                <li class="info-href-contain h3 ms-3 mb-4">
                                                                                                <a href="tea" class="text-color-gray">
                                                                                                    <i class="fa-solid fa-calendar me-3"></i>
                                                                                                    <span>DIỂM DANH</span>
                                                                                                </a>
                                                                                            </li>-->
                                                        </ul>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <a href="notificationSchool?teacherid=${sessionScope.teacher.teacherid}" style="text-decoration: none">
                                            <div class="header-name">
                                                <i class="fa-solid fa-bell pe-2 ps-2"></i>
                                                Thông báo từ nhà trường
                                            </div>
                                        </a>
                                    </div>
                                        <div class="notification-list" style="min-height: 400px; overflow: hidden;">
                                        <c:forEach var="x" items="${notification}">
                                            <div class="notificaiton-item p-4">
                                                <div class="notifi-heading">
                                                    <div class="notifi-header">${x.title}</div>
                                                    <div class="notifi-date">${x.date}</div>
                                                </div>
                                                <div class="ps-3 pt-2 notifi-short-content" style="text-overflow: ellipsis;overflow: hidden;white-space:nowrap; max-width: 500px">${x.content}</div>
                                            </div>
                                        </c:forEach>
                                        
                                    </div>
                                            <div class="text-center view-all text-center" style="height: 30px; border-top: 1px solid #cccccc; font-size: 16px;">
                                                <a href="notificationSchool?teacherid=${sessionScope.teacherid}" class="text-color-gray" style="text-decoration: none">Xem tất cả</a>
                                        </div>
                                </div>
                            </div>


                            

                        </div>
                        <div class="row mt-4">
                            <div class="col">

                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <i class="fa-solid fa-clipboard pe-2 ps-2"></i>
                                            Thủ tục, pháp lý
                                        </div>
                                    </div>
                                    <div class="registration-container">
                                        <div class="applicate-container">
                                            <a href="teacherNotificationHistory?teacherid=${sessionScope.teacherid}">
                                                <button type="button" class="btn btn-me applicate-btn">
                                                    <i class="ps-3 pe-3 w1 fa-solid fa-envelope"></i>
                                                    Gửi thông báo
                                                </button>
                                            </a>
                                            <!--<A href="viewApplicationTeacher?teacherid=${sessionScope.teacherid}"> <button type="button" class="btn btn-me applicate-view">Đơn</button></A>-->
                                        </div>
                                    </div>
                                </div>


                            </div>
                            <div class="col">
                                <div class="row">
                                    <div class="col">
                                        <div class="box-section">
                                            <div class="app-home__heading">
                                                <div class="header-name">
                                                    <i class="fa-solid fa-calendar-days pe-2 ps-2"></i>
                                                    Thời khoá biểu
                                                </div>
                                            </div>
                                            <div class="timetable-href">
                                                <a href="viewTimetableTeacher?teacherid=${sessionScope.teacher.teacherid}" class="text-color-gray fw-bold">Xem</a>
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
    </body>
</html>
