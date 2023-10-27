

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <div class="grid h-100">
        <nav class="navbar navbar-light h-100">
            <a
                class="navbar-brand navbar-logo h-100"
                href="login?email=${sessionScope.account.email}"
                >
                <img
                    src="./assets/imgs/logoPng.png"
                    class="d-inline-block align-top h-100"
                    alt=""
                    />
                <p>Sổ liên lạc điện tử</p>
            </a>

            <div class="navbar-school">
                <img
                    src="./assets/imgs/highSchool.png"
                    width="30"
                    height="30"
                    class="d-inline-block align-top"
                    alt=""
                    />
                <p>FPT High School</p>
            </div>
        </nav>
    </div>
    <%@ include file="./dropDownSettings.jsp" %>
</div>