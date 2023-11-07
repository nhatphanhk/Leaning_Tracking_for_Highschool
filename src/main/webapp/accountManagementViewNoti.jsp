<%-- 
    Document   : accountManagementViewNoti
    Created on : Oct 3, 2023, 1:26:55 PM
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
            <%@ include file="./includes/headerAccountManagement.jsp" %>

            <div class="app-container m-0">
                <div class="grid d-grid">
                    <div class="section-m1">
                        <div class="row">
                            <div class="col">
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="login?email=${sessionScope.account.email}">
                                                <i class="fa-solid fa-arrow-left"></i>
                                            </a>
                                            Danh sách thông báo
                                            <div class="search-btn-contain"     >
                                                <a
                                                    role="button"
                                                    class="btn btn-block nav-link"
                                                    href="sendNotificationFromSchool?staffid=${sessionScope.accountManager.staffid}"
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
                                                            <th>Nội Dung</th>
                                                            <th>Sửa</th>
                                                            <th>Xóa</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="x" items="${notification}" varStatus="loopStatus">
                                                            <tr>
                                                        <input type="hidden" name="notificationid" id="notificationid" value="${x.notificationid}"/>
                                                        <td class="align-middle">${loopStatus.index + 1}</td>
                                                        <td>
                                                            <a href="viewDetailNotificationManager?notificationid=${x.notificationid}" class="text-decoration-none">

                                                                <div class="notificaiton-item p-4" style="text-align: left">
                                                                    <div class="notifi-heading">
                                                                        <div class="notifi-header fs-1" style="color: black">${x.title}</div>
                                                                    </div>
                                                                    <div class="ps-3 pt-2 notifi-short-content fs-3" style="font-weight: 400;text-overflow: ellipsis;overflow: hidden;white-space:nowrap; max-width: 500px; color: black;">${x.content}</div>
                                                                    <div class="notifi-date fs-3" style="text-align: right; font-weight: 400; color: black;">${x.date}</div>
                                                                </div>
                                                            </a>
                                                        </td>

                                                        <td class="align-middle">
                                                            <a
                                                                role="button"
                                                                class="btn btn-block nav-link"                                                                
                                                                href="viewDetailNotiSchoolUpdate?notificationid=${x.notificationid}"

                                                                ><i data-toggle="tooltip" class="fa-solid fa-square-pen" style="font-size: 30px;"></i></a>
                                                        </td>
                                                        <td class="align-middle">
                                                            <a href="deleteNotification?notificationid=${x.notificationid}" onclick="">
                                                                <i class="fa-solid fa-x" style="font-size: 30px; color:black;"></i>
                                                            </a>
                                                        </c:forEach>
                                                        </tr>
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

        <!--Modal-->
        <div class="modal" id="deleteModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Cảnh Báo!</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Bạn có chắc chắn xoá thông báo này?</p>
                    </div>
                    <div class="modal-footer">
                        <form action="deleteNotification" method="post">
                            <input type="hidden" name="notificationid" id="notificationid">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                            <button type="submit" class="btn btn-primary">Xoá</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function showMess(notificationid) {
                console.log(notificationid);
                document.getElementById('notificationid').value = notificationid;
                var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
                console.log(deleteModal);
            }
        </script>
        <%@ include file="./includes/linkJS.jsp" %>
        <script src="./assets/js/mycode.js"></script>

    </body>
</html>
