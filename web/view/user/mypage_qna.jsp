<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
<link rel="stylesheet" href="css/cart-controlQty.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
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
	var previd = '';
	var same = -1;
	function row_toggle(b_id) {
		$('.b_content').slideUp("fast");
		console.log(previd);
		if (previd == b_id) {
			if (same == -1) {
				$('div[id="b_content' + b_id + '"]').slideDown("fast");
			} else {
				$('div[id="b_content' + b_id + '"]').slideUp("fast");
			}
			same = same * (-1);
		} else {
			$('div[id="b_content' + b_id + '"]').slideDown("fast");
		}
		previd = b_id;
		console.log(same);
	};

	// 추가 & 수정 창 토글
	var addopen = false;
	function qna_toggle(loginid) {
		if (loginid == '') {
			var confirmLogin = confirm('로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?');
			if (confirmLogin) {
				alert('로그인 페이지로 이동합니다.');
				location.action = "login.sp";
			} else {
				alert('메인 페이지로 이동합니다.');
				location.action = "main.sp";
			}
		} else {
			if (addopen == false) {
				$('#h2_qna').html("질문을 등록하세요");
				$('#sendbtn').html('보내기');
				$('input[name="b_title"]').val('');
				$('textarea[name="b_content"]').val('');
				$('#b_write').slideDown("fast");
				addopen = true;
				updateopen = false;
			} else if (addopen == true) {
				$('#b_write').slideUp("fast");
				addopen = false;
				updateopen = false;
			}
			/*
			var cancelbtn = $('#cancelbtn').text();
			var addbtn = $('#addbtn').text();
			if (cancelbtn == '취소') {
				$('#h2_qna').html("질문을 등록하세요");
				$('#sendbtn').html('보내기');
				$('input[name="b_title"]').val('');
				$('textarea[name="b_content"]').val('');
			} else if ()
			
			if (addopeon == false) {
				$('div[id="b_write"]').slideUp("fast");
				addopen = true;
			} else if (updateopen == false) {
				if (addopen == true || updateopen == true) {
					$('div[id="b_write"]').slideDown("fast");
				}
			}
			 */
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
			sendForm.action = "qna_updateimpl_mypage.sp";
			sendForm.submit();
		}
	}

	var updateopen = false;
	
	function b_update(b_id, b_title, b_content) {
		if (updateopen == false) {
			var title = document.querySelector('input[name="b_title"]');
			var content = document.querySelector('textarea[name="b_content"]');
			title.value = b_title;
			content.value = b_content;
			$('#h2_qna').html("내 질문 수정하기");
			$('#sendbtn').html('수정하기');
			$('input[name="b_id"]').attr('value', b_id);
			$('#sendbtn').attr('action', 'qna_updateimpl_mypage.sp');
			$('#b_write').show("fast");
			addopen = false;
			updateopen = true;
		} else if (updateopen == true) {
			$('#h2_qna').html("질문을 등록하세요");
			$('#sendbtn').html('보내기');

			$('input[name="b_title"]').val('');
			$('textarea[name="b_content"]').val('');

			$('input[name="b_id"]').attr('value', b_id);
			$('#sendbtn').attr('action', 'qna_addimpl_user.sp');
			$('#b_write').hide("fast");
			updateopen = false;
			addopen = false;
		}
	};

	var title = $('input[name="b_title"]').text();
	//title.
	$(document).ready(
			function() {
				$('input[name="b_title"]').blur(
						function() {
							if ($('input[name="b_title"]').val().length > 30) {
								$('input[name="b_title"]').val('');
								$('input[name="b_title"]').attr('placeholder',
										'30글자 이하 글자만 써주세요.');
							}
						});

				var textlimit = 500;
				$('textarea').keyup(function(event) {
					var textnum = $('textarea').val().length;
					$('#textCount').text(textnum + "/500");
					if (textnum > 500) {
						$(this).val($(this).val().substring(0, 10));
					}
				});
			});
</script>
</head>

<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="bg-white">
	<section class="cat_product_area section_padding border_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-2">

					<div class="left_sidebar_area">
						<aside class="left_widgets p_filter_widgets sidebar_box_shadow">
							<div class="l_w_title">
								<h3>My Page</h3>
							</div>
							<div class="widgets_inner" style="padding:10px 10px;">
								<ul class="list">
									<li><a class="category" href="umypage.sp">회원 정보</a></li>
									<li><a class="category" href="odetail.sp">나의 주문 내역</a></li>
									<li><a class="category" href="#">Q&A</a></li>
								</ul>
							</div>
						</aside>
					</div>
				</div>


				<div class="col-lg-10">
					<div class="row">
						<div class="col-lg-12">
							<div class="right_sidebar_area">
								<div
									class="product_top_bar d-flex justify-content-between align-items-center">
									<div class="col-lg-8 col-md-8">

										<h2>Q&A</h2>
									</div>

									<div id="b_header" class="table-head">
										<span class="c1 txt_center">no.</span> <span
											class="c2 txt_center">제목</span> <span class="c3 txt_center">고객ID</span>
										<span class="c4 txt_center">문의날짜</span><br>
									</div>
									<div id="b_list">
										<c:forEach var="my_b" items="${my_blist }">
											<div class="b_collapsible"
												onclick="row_toggle('${my_b.b_id }');">
												<span class="c1 txt_center txt_height">${my_b.b_id }</span>
												<span class="c2 txt_center txt_height">${my_b.b_title }</span>
												<span class="c3 txt_center txt_height">${my_b.b_writer }</span>
												<span class="c4 txt_center txt_height">${my_b.b_regdate }</span>
												<div class="b_button_right txt_center txt_height">
													<c:choose>
														<c:when test="${my_b.b_writer == loginid }">
															<a class="b_btn"
																onclick="b_update('${my_b.b_id }','${my_b.b_title }','${my_b.b_content }');">수정</a>
															<a href="qna_deleteimpl_mypage.sp?b_id=${my_b.b_id }">삭제</a>
														</c:when>
														<c:otherwise>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
											<div class="b_content" id="b_content${my_b.b_id }">
												<p class="txt_left">${my_b.b_content }</p>
												<c:choose>
													<c:when test="${my_b.b_reply == null }">
													</c:when>
													<c:otherwise>
														<p id="b_reply">└ ${b.b_reply }</p>
													</c:otherwise>
												</c:choose>
											</div>
										</c:forEach>
									</div>
									<form class="b_send" action="qna_updateimpl_mypage" method="post"
										name="b_send">
										<div id="b_write">
											<div>
												<div class="typography">
													<h2 id="h2_qna">질문을 등록하세요</h2>
												</div>
												<div id="shake_title">
													<input type="text" placeholder="제목" name="b_title"
														onfocus="this.placeholder = ''" required="required"
														class="single-input-secondary">
												</div>
												<br> <span id="textCount"></span>
												<textarea class="form-control w-100" rows="15" cols="35"
													placeholder="내용을 입력하세요" name="b_content"
													required="required"></textarea>
												<br> <a href="#" id="sendbtn" onclick="send();"
													class="genric-btn primary-border e-large">보내기</a> <a
													onclick="qna_toggle('${loginid }');" id="cancelbtn"
													class="genric-btn danger-border e-large">취소</a> <input
													type="hidden" name="b_id" value=""> <input
													type="hidden" name="b_writer" value="${loginid }">
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
	</section>
</div>