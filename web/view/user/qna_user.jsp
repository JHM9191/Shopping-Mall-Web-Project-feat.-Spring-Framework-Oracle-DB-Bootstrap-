<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

<style>
#b_table {
	/*float: left;*/
	margin: 0 auto;
}

#b_table_top:nth-child(1) {
	display: inline;
	float: left;
}

#b_table_top:nth-child(2) {
	display: inline;
	float: right;
}

#b_header {
	background: black;
	color: white;
	width: 900px;
}

#b_list {
	width: 900px;
	height: 900px;
	overflow: scroll;
	/*float: left;*/
}

.c1 {
	display: inline-block;
	width: 50px;
}

.c2 {
	display: inline-block;
	width: 300px;
}

.c3 {
	display: inline-block;
	width: 100px;
}

.c4 {
	display: inline-block;
	width: 280px;
}

.txt_center {
	text-align: center;
}

.b_collapsible {
	/*float: left;*/
	border-bottom: 1px solid #B2CCFF;
	background-color: #EAEAEA;
	width: 100%;
}

.b_collapsible:hover {
	background-color: #00D8FF;
	cursor: pointer;
}

.b_button_right {
	float: right;
	width: 15%;
}

.b_btn {
	text-decoration: underline;
	color: -webkit-link;
	cursor: pointer;
}

.b_content {
	background-color: #BDBDBD;
	display: none;
}

#b_reply {
	color: red;
}

#b_write {
	background-color: #B2EBF4;
	padding: 8px;
	position: fixed;
	right: 5px;
	bottom: 5px;
	float: right;
	display: none;
	position: fixed;
}

#b_write input[name="b_title"] {
	width: 100%;
	height: 50px;
	text-size: 1.5em;
}

.askbtn {
	position: fixed;
	top: 100px;
	right: 8px;
}

.b_button {
	text-decoration: none;
	margin: 3px;
	width: 50%;
	height: 50px;
	line-height: 50px;
	float: right;
	text-align: center;
	background: silver;
	font-size: 1.5em;
	text-decoration: none;
	width: 50%;
}

.txt_left {
	text-align: left;
}

.txt_green {
	color: #1DDB16;
}

.txt_height {
	height: 25px;
}
</style>
<script>
	// 게시글 토글
	function tr_toggle(b_id) {
		$('.b_content').slideUp("fast");
		$('div[id="b_content' + b_id + '"]').slideDown("fast");
	};

	// 추가 & 수정 창 토글
	var addopen = false;
	var updateopen = false;
	function qna_toggle(loginid) {
		var confirmLogin;
		if (loginid == '') {
			confirmLogin = confirm('로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?');
			if (confirmLogin) {
				alert('로그인 페이지로 이동합니다.');
				location.action = "login.sp";
			} else {
				alert('메인 페이지로 이동합니다.');
				location.action = "main.sp";
			}
		}
		var text = $('#cancelbtn').text();
		if (text == '취소') {
			$('#h2_qna').html("질문을 등록하세요");
			$('#sendbtn').html('보내기');
			$('input[name="b_title"]').val('');
			$('textarea[name="b_content"]').val('');
		}
		if(addopen == true || updateopen == true) {
			$('div[id="b_write"]').slideDown("fast");
		}
	};

	// 보내기 버튼 (추가 & 수정)
	function send() {
		var sendForm = $('form[name="b_send"]');
		var text = $('#sendbtn').text();
		if (text == '보내기') {
			alert("inside: " + text);
			sendForm.action = "qna_addimpl_user.sp";
			sendForm.submit();
		} else if (text == '수정하기') {
			sendForm.action = "qna_updateimpl_user.sp";
			sendForm.submit();
		}
	}

	function b_update(b_id, b_title, b_content) {
		$('div[id="b_write"]').show("fast");
		var title = document.querySelector('input[name="b_title"]');
		var content = document.querySelector('textarea[name="b_content"]');
		title.value = b_title;
		content.value = b_content;
		$('#h2_qna').html("내 질문 수정하기");
		$('#sendbtn').html('수정하기');
		$('input[name="b_id"]').attr('value', b_id);
		$('#sendbtn').attr('action', 'qna_updateimpl_user.sp');
	};
</script>

<div id="section-top-border text-right mb-30"></div>
<section class="row align-items-center justify-content-center">
	<!-- <div class="row align-items-center container">-->



	<div id="b_table">
		<div class="typography">
			<h2>Q&A</h2>
		</div>

		<div id="b_header" class="table-head">
			<span class="c1 txt_center">no.</span> <span class="c2 txt_center">제목</span>
			<span class="c3 txt_center">고객ID</span> <span class="c4 txt_center">문의날짜</span><br>
		</div>
		<div id="b_list">
			<c:forEach var="b" items="${blist }">
				<div class="b_collapsible" onclick="tr_toggle('${b.b_id }');">
					<span class="c1 txt_center txt_height">${b.b_id }</span> <span
						class="c2 txt_center txt_height">${b.b_title }</span> <span
						class="c3 txt_center txt_height">${b.b_writer }</span> <span
						class="c4 txt_center txt_height">${b.b_regdate }</span>
				</div>
				<div class="b_button_right txt_center txt_height">
					<c:choose>
						<c:when test="${b.b_writer == loginid }">
							<a class="b_btn"
								onclick="b_update('${b.b_id }','${b.b_title }','${b.b_content }');">수정</a>
							<a href="qna_deleteimpl_user.sp?b_id=${b.b_id }">삭제</a>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</div>

				<div class="b_content" id="b_content${b.b_id }">
					<p class="txt_left txt_green">${b.b_content }</p>
					<c:choose>
						<c:when test="${b.b_reply == null }">
						</c:when>
						<c:otherwise>
							<p id="b_reply">└ ${b.b_reply }</p>
						</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
		</div>

	</div>

	<div class="button-group-area askbtn">
		<a href="#" onclick="qna_toggle('${loginid}');"
			class="genric-btn primary-border e-large">문의하기</a>
	</div>
	<form class="b_send" action="qna_addimpl_user.sp" method="post"
		name="b_send">
		<div id="b_write">
			<div>
				<div class="typography">
					<h2 id="h2_qna">질문을 등록하세요</h2>
				</div>
				<input type="text" placeholder="제목" name="b_title"
					onfocus="this.placeholder = ''" required="required"
					class="single-input-secondary"><br>
				<textarea class="form-control w-100" rows="15" cols="35"
					placeholder="내용을 입력하세요" name="b_content" required="required"></textarea>
				<br> <a href="#" id="sendbtn" onclick="send();"
					class="genric-btn primary-border e-large">보내기</a> <a
					onclick="qna_toggle('${loginid }');" id="cancelbtn"
					class="genric-btn danger-border e-large">취소</a> <input
					type="hidden" name="b_id" value=""> <input type="hidden"
					name="b_writer" value="${loginid }">
			</div>
		</div>
	</form>
</section>

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