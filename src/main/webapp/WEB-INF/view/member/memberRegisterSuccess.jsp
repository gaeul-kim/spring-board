<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>
                <a href="/">SampleProject</a>
            </h1>
        </header>
        <section class="content">
            <%@ include file="/WEB-INF/view/include/navigation.jsp"%>
            <main>
            <div class="box-small">
                <ul>
                    <li><div class="text-center">회원가입이 정상적으로 완료되었습니다.</div></li>
                </ul>
            </div>
            </main>
        </section>
        <footer>
            <a href="#">홈페이지</a>
        </footer>
    </div>
</body>
</html>