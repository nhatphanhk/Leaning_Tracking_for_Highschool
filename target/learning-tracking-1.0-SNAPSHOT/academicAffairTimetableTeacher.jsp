<%-- 
    Document   : academicAffairTimetableTeacher
    Created on : Oct 1, 2023, 9:07:30 PM
    Author     : flywt
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="./includes/headerAcademicAffair.jsp" %>
<div class="app-container mt-0">
    <div class="grid d-grid">
        <div class="section-m1">
            <div class="row">
                <div class="col">
                    <div class="box-section">
                        <div class="app-home__heading">
                            <div class="header-name">
                                <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                Thời khóa biểu
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <div class="import-file">
                                <h3>Thêm Thời Khoá Biểu:</h3>
                                <form action="loadTimetable" method="post" enctype="multipart/form-data">                               
                                    <div class="mb-3">
                                        <!--<label for="attachmentFile"></label>-->
                                        <input type="file" id="attachmentFile" name="attachmentFile">
                                    </div>
                                    <div>
                                        <input onclick="showPopup()" class="ps-2 pe-2" type="submit" value="Import">
                                    </div>                                
                                </form>
                            </div>
                            <form action="manageTimtable" method="get">
                                <div class="row d-flex flex-row mt-4">
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4 col-3">
                                        <label class="w-100" for="">Giáo viên:</label>
                                        <select id="teacherid" name="teacherid" class="form-select w-100">
                                            <option selected>Chọn Giáo Viên</option>
                                            <c:forEach items="${teacherlist}" var="teacher">
                                                <option value="${teacher.teacherid}">GV. ${teacher.lastname} ${teacher.firstname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="acaAff-input-ctrl d-flex align-middle col-3">
                                        <input class="acaAff-btn m-0" type="submit" value="Tìm kiếm">
                                    </div>
                                </div>
                            </form>
                            <div class="row mt-4 import-file">
                                <div class="col">
                                    <!-- Timetable details  -->
                                    <table class="table table-bordered">
                                        <thead class="background-primary">
                                            <tr class="text-color-white">
                                                <th>Buổi</th>
                                                <th>Tiết</th>
                                                <th>Thứ 2</th>
                                                <th>Thứ 3</th>
                                                <th>Thứ 4</th>
                                                <th>Thứ 5</th>
                                                <th>Thứ 6</th>
                                                <th>Thứ 7</th>
                                                <th>Chủ Nhật</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td rowspan="5" class="align-middle">Sáng</td>
                                                <td>1</td>
                                                <c:forEach var="x" items="${timetableTeacher0}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>
                                                <td>                                  
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <c:forEach var="x" items="${timetableTeacher1}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <c:forEach var="x" items="${timetableTeacher2}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <c:forEach var="x" items="${timetableTeacher3}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <c:forEach var="x" items="${timetableTeacher4}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td rowspan="5" class="align-middle">Chiều</td>
                                                <td>1</td>
                                                <c:forEach var="x" items="${timetableTeacher5}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <c:forEach var="x" items="${timetableTeacher6}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <c:forEach var="x" items="${timetableTeacher7}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <c:forEach var="x" items="${timetableTeacher8}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <c:forEach var="x" items="${timetableTeacher0}">
                                                    <td>
                                                        ${x.majorname}
                                                        <h5>${x.classname}</h5>
                                                    </td>
                                                </c:forEach>

                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div> 

                            <form action="manageTimetableClass" method="get">
                                <div class="row d-flex flex-row mt-4">
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4 col-3">
                                        <label class="w-90" for="">Lớp</label>
                                        <select id="classid" name="classid" class="form-select" style="font-size: 16px; width: 130px;" aria-label="Default select example" onchange="changeClassName()">
                                            <option selected>Chọn Lớp</option>
                                            <option value="1">10A1</option>
                                            <option value="2">10A2</option>
                                            <option value="3">10A3</option>
                                            <option value="4">11A1</option>
                                            <option value="5">11A2</option>
                                            <option value="6">11A3</option>
                                            <option value="7">12A1</option>
                                            <option value="8">12A2</option>
                                            <option value="9">12A3</option>                                                            
                                        </select> 
                                    </div>
                                    <div class="acaAff-input-ctrl d-flex align-middle col-3">
                                        <input class="acaAff-btn m-0" type="submit" value="Tìm kiếm">
                                    </div>
                                </div>
                            </form>
                            <div class="row mt-4 import-file">
                                <div class="col">
                                    <!-- Timetable details  -->
                                    <table class="table table-bordered">
                                        <thead class="background-primary">
                                            <tr class="text-color-white">
                                                <th>Buổi</th>
                                                <th>Tiết</th>
                                                <th>Thứ 2</th>
                                                <th>Thứ 3</th>
                                                <th>Thứ 4</th>
                                                <th>Thứ 5</th>
                                                <th>Thứ 6</th>
                                                <th>Thứ 7</th>
                                                <th>Chủ Nhật</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td rowspan="5" class="align-middle">Sáng</td>
                                                <td>1</td>
                                                <c:forEach var="x" items="${timetableStudent0}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>                                   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <c:forEach var="x" items="${timetableStudent1}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   

                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <c:forEach var="x" items="${timetableStudent2}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <c:forEach var="x" items="${timetableStudent3}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <c:forEach var="x" items="${timetableStudent4}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td rowspan="5" class="align-middle">Chiều</td>
                                                <td>1</td>
                                                <c:forEach var="x" items="${timetableStudent5}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <c:forEach var="x" items="${timetableStudent6}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <c:forEach var="x" items="${timetableStudent7}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <c:forEach var="x" items="${timetableStudent8}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <c:forEach var="x" items="${timetableStudent9}">
                                                    <td>${x.majorname}</td>                                  
                                                </c:forEach>   
                                                <td></td>
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

<%@ include file="./includes/linkJS.jsp" %>
<script src="./assets/js/mycode.js"></script>
<script>
    function showPopup() {
    swal("Good job!", "You clicked the button!", "success");
    return true;
}
</script>
</body>
</html>