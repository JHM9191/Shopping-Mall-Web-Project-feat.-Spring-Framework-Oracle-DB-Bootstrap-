<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="icon" href="img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/nice-select.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/slick.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/price_rangs.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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

#managerid {
	float: right;
	margin-right: 10px;
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
	left: -110px;
	right: 0;
	margin: auto;
	background: red;
	border-radius: 40px;
	width: 60px;
	height: 60px;
	line-height: 60px;
	color: white;
	text-align: center;
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
	<header class="main_menu home_menu">
		<div class="container-fluid">
			<div class="row align-items-center justify-content-center">
				<div class="col-lg-11">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="main_mgr.sp"> <img
							src="img/logo02.JPG" alt="logo"  width=130px;>
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="menu_icon"><i class="fas fa-bars"></i></span>
						</button>


						<!-- 硫��대� ��������-->
						<div class="collapse navbar-collapse main-menu-item"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link" href="main_mgr.sp">Admin
										Home</a></li>
								<li class="nav-item"><a class="nav-link" href="qna_mgr.sp">Q&A</a></li>
								<li class="nav-item"><a class="nav-link"
									href="statistics_mgr.sp?productType=All&period=total&cond=monthly">Statistics</a></li>
							</ul>
						</div>
						<div>
							<ul class="navbar-nav">
								<li class="nav-item"><b id="managerid">환영합니다
										${loginid}님</b></li>
								<li class="nav-item"><a href="logout.sp">Logout</a></li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>


	<section>
		<c:choose>
			<c:when test="${center == null }">
				<div id="main_setting">
					<a href="qna_mgr.sp">
						<div id="msg_setting" class="btn_on">
							<img class="img_size1" src="img/manager/msg.png">
							<div id="notification">${b_count }&nbsp;</div>
						</div>
					</a> <a href="statistics_mgr.sp?productType=All&period=total&cond=monthly"><img class="img_size2 btn_on"
						src="img/manager/stat.png"></a>
				</div>
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp" />
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>

<!-- jquery plugins here-->
<!-- jquery -->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="js/swiper.min.js"></script>
<!-- swiper js -->

<!-- particles js -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<!-- slick js -->
<script src="js/slick.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/contact.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>
<script src="js/stellar.js"></script>
<script src="js/price_rangs.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>