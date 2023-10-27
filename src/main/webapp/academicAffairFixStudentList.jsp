<%-- 
    Document   : academicAffairFixStudentList
    Created on : Oct 17, 2023, 10:19:26 AM
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
                                <span>Chỉnh sửa học sinh</span>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="updatestudent" method="post">
                                 <div class="form-row">
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px" >Mã học sinh</label>
                                      <input name="id" readonly="" class="Col-7" value="${requestScope.st.studentid}"></input>
                                  </div>
                                  <div class="form-group m-2">
                                      
                                      <input hidden="" name="classid" readonly="" class="Col-7" value="${requestScope.st.classid}"></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Họ</label>
                                      <input name="lastname" class="Col-7" value="${requestScope.st.lastName}"  ></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Tên</label>
                                      <input name="firstname" class="Col-7" value="${requestScope.st.firstName}" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                        <label class="col-3" style="font-size: 15px">Giới tính</label>
                                        <select name="gender" class="col-7" style="width: 115px">
                                            <option value="Nam" ${(requestScope.st.gender == true) ? 'selected' : ''}>Nam</option>
                                            <option value="Nữ" ${(requestScope.st.gender == false) ? 'selected' : ''}>Nữ</option>
                                            <c:if test=""></c:if>
                                        </select>
                                    </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Ngày sinh</label>
                                      <input name="dob" class="Col-7" value="${requestScope.st.dob}" ></input>
                                  </div>
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Số điện thoại</label>
                                      <input name="phone" class="Col-7" value="${requestScope.st.phoneNumber}" ></input>
                                  </div>
                                  
                                  <div class="form-group m-2">
                                      <label class="col-3" style="font-size: 15px">Địa chỉ</label>
                                      <input name="address" class="Col-7" value="${requestScope.st.address}" ></input>
                                  </div>
                                  
                              </div>
                                
                                        <div class="row d-flex flex-row-reverse">
                                            <button class="acaAff-btn" type="submit">Lưu chỉnh sửa</button>
                                            
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
<script>
    const classSelect = document.getElementById("classSelect");

    // Add a change event listener to the select element
    classSelect.addEventListener("change", function(event) {
        // Handle the change event here, e.g., send a request to a servlet
        const selectedValue = this.value;
        window.location.href = "StudentListByClassController?classid=" + selectedValue;
    });

   
</script>

</body>
</html>