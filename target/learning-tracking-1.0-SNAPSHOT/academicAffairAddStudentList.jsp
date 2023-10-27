<%-- 
    Document   : academicAffairAddStudentList
    Created on : Oct 17, 2023, 10:08:17 AM
    Author     : Admin
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
                                <a href="studentlistcontroller"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                <span>Thêm học sinh</span>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="addstudent" method="post">
                                 <div class="form-row">
                                  
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Họ</label>
                                      <input name="lastname" class="Col-7" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Tên</label>
                                      <input name="firstname" class="Col-7" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                        <label class="col-3" style="font-size: 15px">Giới tính</label>
                                        <select name="gender" class="col-7" style="width :115px">
                                            <option value="Nam" selected }>Nam</option>
                                            <option value="Nữ" >Nữ</option>
                                        </select>
                                    </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Ngày sinh</label>
                                      <input name="dob" type="" class="Col-7" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Số điện thoại</label>
                                      <input name="phone" class="Col-7" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Email</label>
                                      <input name="email" class="Col-7" ></input>
                                  </div>
   
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Địa chỉ</label>
                                      <input name="address"  class="Col-7" ></input>
                                  </div>
                                     <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Lớp</label>
                                      <select name="classid">
                                          
                                          <c:forEach var="x" items="${sessionScope.listclass}">
                                                <option  value="${x.classid}">${x.classname}</option>
                                            </c:forEach>
                                              
                                          
                                      </select>
                                  </div>
                                     <div class="form-group m-2">
                                     
                                      <h3 style="color: red">${requestScope.ms}</h3>
                                      <h3 style="color: red">${requestScope.msg}</h3>
                                      
                                  </div>
                                    
                                     
                                  
                              </div>
                                
                                        <div class="row d-flex flex-row-reverse">
                                            <button class="acaAff-btn" type="submit">Lưu</button>
                                        </div>
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


</body>
</html>