<%-- 
Document   : teacherSendApplication
Created on : Sep 22, 2023, 10:04:52 AM
Author     : htk09
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet" />
        <link rel="stylesheet" href="./assets/css/teacher-base.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
        <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>-->
        <link rel="stylesheet" href="./assets/css/style.css" />
        <link rel="stylesheet" href="./assets/css/teacher-style.css" />
        <title>MS</title>
    </head>

    <body>
        <div class="app">
            <!-- header  -->
            <%@ include file="./includes/header.jsp" %>
            <div class="app-container d-flex justify-content-center">
                <div class="box-section w-50 mt-lg-5">
                    <div class="app-home__heading">
                        <div class="header-name">
                            <a href="notificationSchool?studentid=${sessionScope.studentid}"><i class="fa-solid fa-arrow-left me-3"></i></a>
                            Nội Dung Thông Báo
                        </div>
                    </div>
                    <div class="send-notification mx-4">
                        <div class="mb-3 d-flex mt-4">
                            <label class="form-label me-4">Tiêu đề:</label>
                            <p name="title" class="form-control w-75 noti-select">${detailNoti.title}</p>                            </div>                            
                        <div class="mb-3">
                            <label class="form-label">Nội dung:</label>
                            <div name="content" class="form-control noti-textarea" style="min-height: 300px">${detailNoti.content}</div>                        </div>
                        <!--<input type="hidden" name="teacherid" value="" />-->
                        <!--<button type="submit" class="btn btn-primary btn-submit mb-4 float-end">Submit</button>-->
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="./includes/linkJS.jsp" %>
        <%@ include file="./includes/script.html" %>
    </body>

</html>
