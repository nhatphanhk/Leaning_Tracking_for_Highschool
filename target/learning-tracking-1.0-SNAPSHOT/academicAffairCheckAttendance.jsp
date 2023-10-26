<%-- 
    Document   : academicAffairCheckAttendance
    Created on : Oct 1, 2023, 9:13:39 PM
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
                            <div class="header-name d-flex justify-content-between">
                                <span>Điểm danh</span>
                                <h3>${msg}</h3>
                                <form action="list-attendance" method="get">
                                    <div class="search">
                                        <div class="search-btn-contain" style="right:80px;">
                                            <select id="classid" name="classid" class="form-select" aria-label="Default select example" onchange="changeClassName()">
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
                                        <button type="submit" class="btn btn-block submit-modal-btn" style="position: absolute;top: 7px;right: 7px">
                                            Tìm kiếm
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <div class="row">
                                <div class="col">
                                    <form action="check-attendance">
                                        <!-- Student List details  -->
                                        <table class="table table-bordered table-striped">
                                            <thead class="background-primary">
                                                <tr class="text-color-white">
                                                    <th>STT</th>
                                                    <th>Mã học sinh</th>
                                                    <th>Họ và Tên</th>
                                                    <th>Giới tính</th>
                                                    <th>Ngày sinh</th>
                                                    <th>Số điện thoại</th>
                                                    <th>Điểm danh</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${students}" var="x" varStatus="status">
                                                <tr>
                                                    <td>${status.index+1}</td>
                                                    <td>${x.studentid}</td>
                                                    <td>${x.lastName} ${x.firstName}</td>
                                                    <td>
                                                <c:choose>
                                                    <c:when test="${x.gender}">
                                                        Nam
                                                    </c:when>
                                                    <c:otherwise>
                                                        Nữ
                                                    </c:otherwise>
                                                </c:choose>
                                                </td>
                                                <td>${x.dob}</td>
                                                <td>${x.phoneNumber}</td>
                                                <c:if test="${(x.status == true)}"><td><input type="checkbox" name="status${status.index}" value="${x.status}" ></td></c:if>
                                                <c:if test="${(x.status == false)}"><td><input type="checkbox" name="status${status.index}" value="${x.status}" ></td></c:if>
                                                </tr>  
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="row d-flex flex-row-reverse">
                                            <button class="acaAff-btn">Lưu</button>
                                        </div>
                                    </form>
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
 var checkboxes = document.querySelectorAll('input[type="checkbox"]');

  // Loop through the checkboxes and check them based on their values
  checkboxes.forEach(function (checkbox) {
  if (checkbox.value === "true") {
    checkbox.checked = true;
  }
});

checkboxes.forEach(function (checkbox) {
  checkbox.addEventListener("change", function () {
    // Update the value when the checkbox is checked
    checkbox.value = checkbox.checked ? "true" : "false";
  });
});
</script>
</body>
</html>
