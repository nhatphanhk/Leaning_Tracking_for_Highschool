<%-- 
    Document   : viewTeacherNotification
    Created on : Sep 22, 2023, 10:05:26 AM
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
        <link rel="stylesheet" href="./assets/css/style-attendanceStatu--student.css" />
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
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="studentHomePage.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                            Các Thông Báo Từ Giáo Viên
                                        </div>
                                    </div>
                                    <div class="row m">
                                        <div class="notification-list">
                                            <c:forEach var="x" items="${notifications}">
                                                <div class="notificaiton-item p-4" >
                                                    <a href="viewDetailsNotiFromTeacher?notificationid=${x.notificationid}" class="text-decoration-none">
                                                    <div class="notifi-heading">
                                                        <div class="notifi-header fs-1" style="color:black;">${x.title}</div>
                                                        <div class="notifi-date fs-3" style="color:black;">${x.date}</div>
                                                    </div>
                                                    <div class="d-flex">
                                                        <p class="ps-3 pt-2 notifi-short-content fs-3 " style="color: black;text-overflow: ellipsis;overflow: hidden;white-space: nowrap; max-width: 500px">
                                                            ${x.content}
                                                        </p>
                                                        <div class="ms-auto ps-3 pt-2 notifi-teacher-name fs-3">${x.teacher.firstname} ${x.teacher.lastname}</div>
                                                    </div>
                                                    </a>
                                                </div>
                                            </c:forEach>
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
    <script src="assets/js/scripts.js"></script>
</body>
</html>

