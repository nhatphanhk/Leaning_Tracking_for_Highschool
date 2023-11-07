<%-- 
    Document   : attendanceStatus
    Created on : Sep 22, 2023, 10:01:54 AM
    Author     : htk09
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        

        <link rel="stylesheet" href="./assets/css/style-attendanceStatu--student.css" />
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
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="studentHomePage.jsp"> <i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                            Nghỉ Học
                                        </div>
                                    </div>

                                    <div class="app-home__body">
                                        <div class="p-5 info-container">
                                            <div class="row">
                                                
                                                <div class="col">
                                                    <div class="box-section" style="height: 100%">
                                                        <table class="table table-bordered text-center " >
                                                            <thead>
                                                                <tr>
                                                                    <th class="col-1" scope="col" >STT</th>
                                                                    <th class="col-2" scope="col" >Ngày</th>
                                                                    <th class="col-1" scope="col" >Học Kỳ</th>
                                                                    <th class="col" scope="col">Nội Dung
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <c:forEach items="${status}" var="x" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.index+1}</td>
                                                                        <fmt:formatDate value="${x.date}" pattern="dd/MM/yyyy" var="formattedDate" />
                                                                        <td>${formattedDate}</td>
                                                                        <td>${x.semesterid}</td>
                                                                        <td style="text-align: start;"> ${x.note}</td>
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
            </div>
        </div>
    </div>


    <%@ include file="./includes/linkJS.jsp" %>
    <script src="assets/js/scripts.js"></script>
</body>
</html>
