<%-- 
    Document   : academicAffairTeacherList
    Created on : Oct 1, 2023, 9:18:48 PM
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
                            <div class="header-name d-flex justify-content-between">
                                <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                <span>Danh sách giáo viên</span>

              <div class="col">
                <div class="box-section">
                  <div class="app-home__heading">
                    <div class="header-name">
                      <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                      Thời khóa biểu
                    </div>
                  </div>
                  <div class="app-home__body m-5">
                      <form action="loadTimetable" method="post" enctype="multipart/form-data">
                             <div class=" acaAff-files d-flex flex-row-reverse " >
                                <input type="file" id="attachmentFile" name="attachmentFile">                                                                                  
                            </div>
                                        
                                       
                         </form>
                      <div class="row d-flex flex-row mt-4">
                        <div class="acaAff-input-ctrl d-flex align-middle me-4">
                          <label for="">Năm:</label>
                          <select class="form-select">
                            <option value="1">2023</option>
                            <option value="2">2022</option>
                            <option value="3">2021</option>
                          </select>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="">
                                
                                <div class="row d-flex flex-row mt-4">
                                   <div class="row acaAff-files">
                                    <a href="addteacher"><button type="button" class="col-3 acaAff-btn" >Thêm</button></a>
                                    
                                </div>
                                </div>
                                    
                                
                                <div class="row mt-4">
                                    <div class="col">
                                        <!-- Student List details  -->
                                        <table class="table table-bordered table-striped">
                                            <thead class="background-primary">
                                                <tr class="text-color-white">
                                                    <th>STT</th>
                                                    <th>Mã giáo viên</th>
                                                    <th>Họ và Tên</th>
                                                    <th>Giới tính</th>
                                                    <th>Ngày sinh</th>
                                                    <th>Số điện thoại</th>
                                                    <th>Địa chỉ</th>
                                                    <th>Chỉnh sửa</th>
                                                    <th>Xoá</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.teacherlist}" var="x" varStatus="loopStatus">
                                                    <tr>
                                                        <td>${loopStatus.index+1}</td>
                                                        <td>${x.teacherid}</td>
                                                        <td>${x.lastname} ${x.firstname}</td>
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
                                                        <td><a href="updatestudent?email=${x.email}" >Chỉnh sửa</a></td>
                                                        <td><a class="delete-link" href="deletestudent?email=${x.email}" >Xoá</a></td>

                                                    </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table>
                                        <div class="row d-flex flex-row-reverse">
                                            <!--                                        <a href="" class="acaAff-btn">Lưu</a>-->

                                        </div>
                        <div class="acaAff-input-ctrl d-flex align-middle me-4">
                          <label for="">Học kì:</label>
                          <select class="form-select">
                            <option value="1">1</option>
                            <option value="2">2</option>
                          </select>
                        </div>
                          <div class="acaAff-input-ctrl d-flex align-middle me-4">
                          <label for="">Giáo viên:</label>
                          <select class="form-select">
                            <option value="1">Hà trọng tấn</option>
                            <option value="2">Hoàng Tuấn Kiệt</option>
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

    <%@ include file="./includes/linkJS.jsp" %>
    <script src="./assets/js/mycode.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const deleteLinks = document.querySelectorAll('.delete-link');

            deleteLinks.forEach(link => {
                link.addEventListener("click", function (event) {
                    event.preventDefault(); // Prevent the default link behavior

                    const confirmation = confirm('Bạn có chắc chắn muốn xoá giáo viên này?');

                    if (confirmation) {
                        window.location.href = event.target.getAttribute('href');
                    }
                });
            });
        });
    </script>

</body>
</html>
