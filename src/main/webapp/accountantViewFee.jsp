<%-- 
    Document   : accountViewFee
    Created on : Nov 7, 2023, 1:20:37 AM
    Author     : nhatp
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="./includes/headerAccountant.jsp" %>
<div class="app-container mt-0">
    <div class="grid d-grid">
        <div class="section-m1">
            <div class="row">
                <div class="col">
                    <div class="box-section">
                        <div class="app-home__heading">
                            <div class="header-name d-flex">
                                <a href="accountantProfile.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                <span style="margin-top: 5px">Quản lý phí</span>
                            </div>
                        </div>
                        <div class="app-home__body m-5">
                            <form action="ViewFeeController" mehtod="GET" >
                                <div class="row acaAff-files">
                                    <a href="AddFeeController"><button type="button" class="col-2 acaAff-btn float-end" >Thêm</button></a>
                                </div>
                                <div class="row d-flex flex-row mt-4">
                                    
                                </div>
                                <div class="row mt-4">
                                    <div class="col">
                                        <!-- Student List details  -->
                                        <table class="table table-bordered table-striped">
                                            <thead class="background-primary">
                                                <tr class="text-color-white">
                                                    <th>STT</th>
                                                    <th>Loại học phí</th>
                                                    <th>Số tiền</th>                                                   
                                                    <th>Chỉnh sửa</th>
                                                    <th>Xóa</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.PayFee}" var="x" varStatus="loopStatus">
                                                    <tr>
                                                        <td>${loopStatus.index + 1}</td>
                                                        <td>${payment.categoryid}</td>
                                                        <td>${payment.totalbill}</td>
                                                        <td><a  class="btn btn-secondary btn-lg" href="" >Chỉnh sửa</a></td>
                                                        <td><span class="material-symbols-outlined">delete</span> </td>
                                                    </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table>
                                        <div class="row d-flex flex-row-reverse">
                                            <!--                                        <a href="" class="acaAff-btn">Lưu</a>-->

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

    <%@ include file="./includes/linkJS.jsp" %>
    <script src="./assets/js/mycode.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const deleteLinks = document.querySelectorAll('.delete-link');

            deleteLinks.forEach(link => {
                link.addEventListener("click", function (event) {
                    event.preventDefault(); // Prevent the default link behavior

                    const confirmation = confirm('Bạn có chắc chắn muốn xoá học phí này?');

                    if (confirmation) {
                        window.location.href = event.target.getAttribute('href');
                    }
                });
            });
        });
    </script>

</body>
</html>
