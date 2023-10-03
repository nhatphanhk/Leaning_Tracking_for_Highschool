<%-- 
    Document   : notificationDetails
    Created on : Oct 1, 2023, 11:13:09 AM
    Author     : tramy
--%>

<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <c:forEach var="x" items="${notifications}">
            <div class="notificaiton-item p-4">
                <div class="notifi-heading">
                    <div class="notifi-header fs-1">${x.title}</div>
                    <div class="notifi-date fs-3">${x.date}</div>
                </div>
                <div class="d-flex">
                    <div class="ps-3 pt-2 notifi-short-content fs-3 ">${x.content}</div>
                    <div class="ms-auto ps-3 pt-2 notifi-teacher-name fs-3">${x.teacherid}</div>
                </div>
            </div>
        </c:forEach>
    </body>
</html>

