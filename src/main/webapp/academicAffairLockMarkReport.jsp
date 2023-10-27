<%-- 
    Document   : academicAffairLockMarkReport
    Created on : Oct 1, 2023, 9:16:40 PM
    Author     : flywt
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="./includes/headerAcademicAffair.jsp" %>
<div class="app-container mt-0 acaAff-container">
    <div class="grid d-grid">
        <div class="section-m1">
            <div class="row">
                <div class="col">
                    <div class="box-section">
                        <div class="app-home__heading">
                            <div class="header-name d-flex ">
                                <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                <span style="margin-top: 5px">Danh sách học sinh</span>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="LockMark" method="post">
                                <div class="row box-lock-time">
                                    <div class="box-lock-time__header">
                                        Cài đặt khóa điền điểm của giáo viên
                                    </div>
                                    <div class="box-lock-time__body">
                                        <div class="row d-flex flex-row mt-4">
                                            <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                                <label for="">Thời gian từ:</label>
                                                <input type="date" disabled="">
                                            </div>
                                            <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                                <label for="">Đến:</label>
                                                <input type="date" disabled="">
                                            </div>
                                            <span class="text-danger">Tính năng nhập thời gian hiện chưa hỗ trợ</span>
                                        </div>
                                        <c:if test = "${!isLockedMark}">
                                            <div class="row acaAff-files d-flex flex-row-reverse m-4">
                                                <button type="submit" class="acaAff-btn btn-error" data-bs-toggle="tooltip" data-bs-placement="top" title="Nhấn để khóa sổ điểm">KHÓA</button>
                                            </div>
                                        </c:if>
                                        <c:if test = "${isLockedMark}">
                                            <div class="row acaAff-files d-flex flex-row-reverse m-4">
                                                <button type="submit" class="acaAff-btn btn-success" data-bs-toggle="tooltip" data-bs-placement="top" title="Nhấn để mở sổ điểm">MỞ</button>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </form>
                            <!-- TABS navigation -->
                            <div class="row mt-5">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <c:forEach var ="x" items="${classes}">
                                        <li class="nav-item" role="presentation">
                                            <button class="nav-link" id="t${x.classname}-tab" data-bs-toggle="tab" data-bs-target="#t${x.classname}" type="button" role="tab" aria-controls="t${x.classname}" aria-selected="false">${x.classname}</button>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <c:forEach var="entry" items="${mapClassAndMark}">
                                        <c:set var="className" value="${entry.key}" />
                                        <c:set var="marksList" value="${entry.value}" />
                                        <div class="tab-pane fade" id="t${className}" role="tabpanel" aria-labelledby="t${className}-tab">
                                            <table class="table table-bordered table-striped">
                                                <thead class="background-primary">
                                                    <tr class="text-color-white">
                                                        <th>STT</th>
                                                        <th>Mã học sinh</th>
                                                        <th>Họ</th>
                                                        <th>Tên</th>
                                                        <th>HK1</th>
                                                        <th>HK2</th>
                                                        <th>TB</th>
                                                        <th>Nhận xét</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="mark" items="${marksList}"  varStatus="loopStatus">
                                                        <tr>
                                                            <td>${loopStatus.index + 1}</td>
                                                            <td>${mark.studentid}</td>
                                                            <td class="text-start">${mark.lastname}</td>
                                                            <td>${mark.firstname}</td>
                                                            <td></td>
                                                            <td></td>
                                                            <td>${mark.total_mark}</td>
                                                            <td></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!--                            <div class="accordion" id="accordionExample">
                            <c:forEach var="entry" items="${mapClassAndMark}">
                                <c:set var="className" value="${entry.key}" />
                                <c:set var="marksList" value="${entry.value}" />
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="heading${className}">
                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${className}" aria-expanded="false" aria-controls="collapse${className}">
                                ${className}
                            </button>
                        </h2>
                        <div id="collapse${className}" class="accordion-collapse collapse" aria-labelledby="heading${className}" data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                <table class="table table-bordered table-striped">
                                    <thead class="background-primary">
                                        <tr class="text-color-white">
                                            <th>STT</th>
                                            <th>Mã học sinh</th>
                                            <th>Họ</th>
                                            <th>Tên</th>
                                            <th>HK1</th>
                                            <th>HK2</th>
                                            <th>TB</th>
                                            <th>Nhận xét</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                <c:forEach var="mark" items="${marksList}" varStatus="loopStatus">
                                    <tr>
                                        <td>${loopStatus.index + 1}</td>
                                        <td>${mark.studentid}</td>
                                        <td>${mark.lastname}</td>
                                        <td>${mark.firstname}</td>
                                        <td></td>
                                        <td></td>
                                        <td>${mark.final_mark}</td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                            </c:forEach>
                        </div>-->
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

