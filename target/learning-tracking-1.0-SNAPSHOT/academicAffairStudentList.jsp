<%-- 
    Document   : academicAffairStudentList
    Created on : Oct 1, 2023, 9:20:05 PM
    Author     : flywt
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="./includes/headerAcademicAffair.jsp" %>
<div class="app-container mt-0">
    <div class="grid d-grid">
        <div class="section-m1">
            <div class="row">
                <div class="col">
                    <div class="box-section">
                        <div class="app-home__heading">
                            <div class="header-name d-flex">
                                <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                <span style="margin-top: 5px">Danh sách học sinh</span>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="">
                                <div class="row acaAff-files d-flex">
                                    <a class="col-2" href="addstudent"><button type="button" class="col-2 acaAff-btn" >Thêm</button></a>
                                     
                                  </div>
                                <c:set var="cid" value="${requestScope.cid}" />
                                <div class="row d-flex flex-row mt-4">
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                        <label for="">Lớp:</label>
                                        
                                        <select id="classSelect" class="form-select">
                                            <option disabled selected>Chọn lớp</option>
                                            <c:forEach var="x" items="${requestScope.listclass}">
                                                <option ${(cid == x.classid)?'selected':''}  value="${x.classid}">${x.classname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                </div>
                                <div class="row mt-4">
                                    <div class="col">
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
                                                    <th>Địa điểm</th>
                                                    <th>Chỉnh sửa</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.studentlist}" var="x" varStatus="loopStatus">
                                                    <tr>
                                                        <td>${loopStatus.index+1}</td>
                                                        <td>${x.studentid}</td>
                                                        <td class="text-start">${x.lastName} ${x.firstName}</td>
                                                        <td><c:choose>
                                                                            <c:when test="${x.gender}">
                                                                                Nam
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                Nữ
                                                                            </c:otherwise>
                                                                        </c:choose></td>
                                                        <td>${x.dob}</td>
                                                        <td>${x.phoneNumber}</td>
                                                        <td>${x.address}</td>
                                                        <td><a class="btn btn-secondary btn-lg" href="updatestudent?email=${x.email}" email>Chỉnh sửa</a></td>
                                            


                                                    </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table>
                                        
                                    </div>
                                </div>
                            </form>
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
    const classSelect = document.getElementById("classSelect");

    // Add a change event listener to the select element
    classSelect.addEventListener("change", function(event) {
        // Handle the change event here, e.g., send a request to a servlet
        const selectedValue = this.value;
        window.location.href = "StudentListByClassController?classid=" + selectedValue;
    });

   
</script>
<script>
        document.addEventListener("DOMContentLoaded", function () {
            const deleteLinks = document.querySelectorAll('.delete-link');

            deleteLinks.forEach(link => {
                link.addEventListener("click", function (event) {
                    event.preventDefault(); // Prevent the default link behavior

                    const confirmation = confirm('Bạn có chắc chắn muốn xoá học sinh này?');

                    if (confirmation) {
                        window.location.href = event.target.getAttribute('href');
                    }
                });
            });
        });
    </script>

</body>
</html>
