<%-- 
    Document   : academicAffairLockMarkReport
    Created on : Oct 1, 2023, 9:16:40 PM
    Author     : flywt
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                            <!--Doughnut Statistic-->
                            <div class="row d-flex justify-content-around mb-5">
                                <div class="col-sm-5 shadow p-3 mb-5 bg-body rounded">
                                    <div class="card">
                                        <div class="row card-body">
                                            <div class="col-4 title-container d-flex flex-column justify-content-center align-items-center">
                                                <div class="icon-contain d-inline">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-mortarboard-fill text-color-primary" viewBox="0 0 16 16">
                                                        <path d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917l-7.5-3.5Z"/>
                                                        <path d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466 4.176 9.032Z"/>
                                                    </svg>
                                                </div>
                                                <h1 class="d-inline text-color-primary">${classes.size()}</h1>
                                                <h2 class="d-inline text-color-primary">Lớp học</h2>
                                            </div>
                                            <div class="col-4 statis-container d-flex flex-column justify-content-center align-items-start">
                                                <h3><div style="width: 10px;
                                                         background-color: #190367;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 10 (${count10})</h3>
                                                <h3><div style="width: 10px;
                                                         background-color: #3d19be;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 11 (${count11})</h3>
                                                <h3><div style="width: 10px;
                                                         background-color: #568dfa;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 12 (${count12})</h3>
                                            </div>
                                            <div class="col-4 statis-donut-container">
                                                <canvas id="myChart" style="max-width: 200px"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-5 shadow p-3 mb-5 bg-body rounded">
                                    <div class="card">
                                        <div class="row card-body">
                                            <div class="col-4 title-container d-flex flex-column justify-content-center align-items-center">
                                                <div class="icon-contain d-inline">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill text-color-primary" viewBox="0 0 16 16">
                                                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
                                                    </svg>
                                                </div>
                                                <h1 class="d-inline text-color-primary">${students.size()}</h1>
                                                <h2 class="d-inline text-color-primary">Học sinh</h2>
                                            </div>
                                            <div class="col-4 statis-container d-flex flex-column justify-content-center align-items-start">
                                                <h3><div style="width: 10px;
                                                         background-color: #190367;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 10 (${student10})</h3>
                                                <h3><div style="width: 10px;
                                                         background-color: #3d19be;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 11 (${student11})</h3>
                                                <h3><div style="width: 10px;
                                                         background-color: #568dfa;
                                                         height: 10px;
                                                         display: inline-block;"></div> Khối 12 (${student12})</h3>
                                            </div>
                                            <div class="col-4 statis-donut-container">
                                                <canvas id="myChart2" style="max-width: 200px"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--Column chart statistic-->
<!--                            <div class="row mb-5">
                                <div class="col-4 column-chart">
                                <div class="heading mb-4 h2">
                                    Học lực học sinh khối 10
                                </div>
                                <canvas id="columnChart10" style="width:100%;max-width:600px"></canvas>
                            </div>
                                <div class="col-4 column-chart">
                                <div class="heading mb-4 h2">
                                    Học lực học sinh khối 11
                                </div>
                                <canvas id="columnChart11" style="width:100%;max-width:600px"></canvas>
                            </div>
                                <div class="col-4 column-chart">
                                <div class="heading mb-4 h2">
                                    Học lực học sinh khối 12
                                </div>
                                <canvas id="columnChart12" style="width:100%;max-width:600px"></canvas>
                            </div>
                            </div>-->
                            

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
                                            <span class="text-danger h3">Tính năng nhập thời gian hiện chưa hỗ trợ</span>
                                        </div>
                                        <c:if test = "${!isLockedMark}">
                                            <div class="row acaAff-files d-flex flex-row-reverse m-4">
                                                <button type="button" class="acaAff-btn btn-error" data-bs-toggle="modal" data-bs-target="#exampleModal">KHÓA</button>
                                            </div>
                                        </c:if>
                                        <c:if test = "${isLockedMark}">
                                            <div class="row acaAff-files d-flex flex-row-reverse m-4">
                                                <button type="button" class="acaAff-btn " data-bs-toggle="modal" data-bs-target="#openModal">MỞ SỔ ĐIỂM</button>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </form>
                            <!-- TABS navigation -->
<!--                            <div class="row mt-5">
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
                                                            <td class="text-start">${mark.firstname}</td>
                                                            <td></td>
                                                            <td></td>
                                                            <td><fmt:formatNumber type = "number" maxIntegerDigits = "1" value = "${mark.total_mark}" /></td>
                                                            <td></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        <c:if test = "${isLockedMark}">
                                            <div class="row acaAff-files d-flex flex-row-reverse m-4">
                                                <button type="submit" class="acaAff-btn btn-success" data-bs-toggle="tooltip" data-bs-placement="top" title="Nhấn để mở quyền chỉnh sửa điểm của lớp ${className}">MỞ</button>
                                            </div>
                                        </c:if>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!--Modal-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="exampleModalLabel">Xác nhận khóa sổ điểm</h2>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body h3">
        Xác nhận khóa sổ điểm, khi sổ điểm khóa thì giáo viên sẽ không thể cập nhật điểm cho học sinh
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-me btn-cancel-modal" data-bs-dismiss="modal">Hủy</button>
        <form action="LockMark" method="post">
            <button type="submit" class="btn-me btn-confirm-modal">Xác nhận</button>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="openModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="exampleModalLabel">Xác nhận mở khóa sổ điểm</h2>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body h3">
        Xác nhận mở khóa sổ điểm, khi sổ điểm mở khóa thì giáo viên sẽ có thể cập nhật điểm cho học sinh
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-me btn-cancel-modal" data-bs-dismiss="modal">Hủy</button>
        <form action="LockMark" method="post">
            <button type="submit" class="btn-me btn-confirm-modal">Xác nhận</button>
        </form>
      </div>
    </div>
  </div>
</div>

<%@ include file="./includes/linkJS.jsp" %>
<script src="./assets/js/mycode.js"></script>
<script src="./assets/js/academicAffairScript.js"></script>
<script type="text/javascript">
    var xValues = ["Khối 10", "Khối 11", "Khối 12"];
    var yValues = [${count10}, ${count11}, ${count12}];
    var yValuesStudents = [${student10}, ${student11}, ${student12}];
    var barColors = ["#190367", "#3d19be", "#568dfa"];

    new Chart("myChart", {
        type: "doughnut",
        data: {
            labels: xValues,
            datasets: [
                {
                    backgroundColor: barColors,
                    data: yValues,
                },
            ],
        },
        options: {
            title: {
                display: false,
                text: "World Wide Wine Production 2018",
            },
            legend: {
                display: false, // This line hides the legend
            },
        },
    });
    new Chart("myChart2", {
        type: "doughnut",
        data: {
            labels: xValues,
            datasets: [
                {
                    backgroundColor: barColors,
                    data: yValuesStudents,
                },
            ],
        },
        options: {
            title: {
                display: false,
                text: "World Wide Wine Production 2018",
            },
            legend: {
                display: false, // This line hides the legend
            },
        },
    });


    var xValuesCol = ["Yếu", "Trung bình", "Khá", "Giỏi"];
    var yValuesColChart10 = [${countWeak10}, ${countAver10}, ${countNorm10}, ${countGreat10}];
    var yValuesColChart11 = [${countWeak11}, ${countAver11}, ${countNorm11}, ${countGreat11}];
    var yValuesColChart12 = [${countWeak12}, ${countAver12}, ${countNorm12}, ${countGreat12}];
    var barColorsChart = ["#568dfa", "#568dfa", "#568dfa", "#568dfa"];

    new Chart("columnChart10", {
        type: "bar",
        data: {
            labels: xValuesCol,
            datasets: [{
                    backgroundColor: barColorsChart,
                    data: yValuesColChart10
                }]
        },
        options: {
            legend: {display: false},
            title: {
                display: false,
                text: "World Wine Production 2018"
            }
        }
    });
    new Chart("columnChart11", {
        type: "bar",
        data: {
            labels: xValuesCol,
            datasets: [{
                    backgroundColor: barColorsChart,
                    data: yValuesColChart11
                }]
        },
        options: {
            legend: {display: false},
            title: {
                display: false,
                text: "World Wine Production 2018"
            }
        }
    });
    new Chart("columnChart12", {
        type: "bar",
        data: {
            labels: xValuesCol,
            datasets: [{
                    backgroundColor: barColorsChart,
                    data: yValuesColChart12
                }]
        },
        options: {
            legend: {display: false},
            title: {
                display: false,
                text: "World Wine Production 2018"
            }
        }
    });
</script>
</body>
</html>