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
                            <div class="header-name">
                                <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                Thời khóa biểu

                                <!--<a class="acaAff-btn">Import</a>-->
                            </div>
                      <div class="app-home__body m-5">                           
                                
                                    <form action="loadTimetable" method="post" enctype="multipart/form-data">
                                        <div class=" acaAff-files d-flex flex-row-reverse " >
                                            <input type="file" id="attachmentFile" name="attachmentFile">                                                                                  
                                        </div>
                                        
                                       
                                    </form>
                                </div>
                                <div class="row d-flex flex-row mt-4">
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                        <label for="">Năm:</label>
                                        <select class="form-select">
                                            <option value="1">2023</option>
                                            <option value="2">2022</option>
                                            <option value="3">2021</option>
                                        </select>
                                    </div>
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                        <label for="">Học kì:</label>
                                        <select class="form-select">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                        </select>
                                    </div>
                                    <div class="acaAff-input-ctrl d-flex align-middle me-4">
                                        <label for="">Lớp:</label>
                                        <select class="form-select">
                                            <option value="1">10</option>
                                            <option value="2">11</option>
                                            <option value="3">12</option>
                                        </select>
                                    </div>
                                     <div class="acaAff-input-ctrl d-flex align-middle">
                                     <input class="acaAff-btn" type="submit" value="Tìm kiếm">
                                    </div>
                                </div>
                                <div class="row mt-4">
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
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td rowspan="5" class="align-middle">Chiều</td>
                                                    <td>1</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
                                                    <td>Toán</td>
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
