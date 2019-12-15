<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
#a_nav {
	height: 80px;
	line-height: 80px;
	border-bottom: 1px solid gray;
}
#img_logo {
	position: absolute;
	left: 0;
	right: 0;
	margin: auto;
}
#a_nav>span {
	float: right;
}
#a_nav>a:nth-child(6) {
	float: right;
}
#main_align {
	margin: 0 auto;
}
#main_setting {
	width: 100%;
	height: 800px;
	line-height: 800px;
	align-items: center;
}
/*Q&A notification*/
#msg_setting {
	position: absolute;
	left: 0;
	right: 0;
	margin: auto;
	cursor: pointer;
}
.btn_on:hover {
	opacity: 20%;
}
#notification {
	position: absolute;
	top: 150px;
	left: -100px;
	right: 0;
	margin: auto;
	background: red;
	border-radius: 40px;
	width: 60px;
	height: 60px;
	line-height: 60px;
	color: white;
	text-align: right;
	font-size: 2.5em;
}
.img_size1 {
	position: absolute;
	top: 150px;
	left: -250px;
	right: 0;
	margin: auto;
	width: 200px;
	height: 200px;
}
.img_size2 {
	position: absolute;
	top: 250px;
	left: 0;
	right: -250px;
	margin: auto;
	width: 180px;
	height: 180px;
}
</style>
</head>
<body>
	<div id="a_nav">
		<a href="main_mgr.sp">Admin Home</a> <a href="qna_mgr.sp">Q&A</a> <a><img
			id="img_logo" src="img/logo.png"></a> <a href="statistics_mgr.sp">Statistics</a>
		<span>환영합니다 ${loginid}님</span><a href="logout.sp">Logout</a>
	</div>
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<div id="main_setting">
					<a href="qna_mgr.sp">
						<div id="msg_setting" class="btn_on">
							<img class="img_size1" src="img/manager/msg.png">
							<div id="notification">${b_count }&nbsp;</div>
						</div>
					</a> 
					<a href="statistics_mgr.sp"><img class="img_size2 btn_on" src="img/manager/stat.png"></a>
				</div>
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp" />	
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>