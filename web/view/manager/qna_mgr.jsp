<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	width: 100%;
}

#b_write input[name="b_writer"] {
	width: 25%;
	height: 50px;
	text-size: 1.5em;
	display: inline;
}

#b_write input[name="b_title"] {
	width: 65%;
	height: 50px;
	text-size: 1.5em;
	display: inline;
	float: right;
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

#h4_userid, #h4_qnatitle {
	display: inline;
}
</style>
<script>
	/*
	 function tr_toggle(b_id) {
	 var content = document.querySelector('div[id="'+ b_id + '"]');
	 if (content.style.display == "block") {
	 content.style.display = "none";
	 } else {
	 //var content_others = document.querySelector('not(div[id="'+ b_id + '"])');
	 //content_others.style.display="none";
	 content.style.display = "block";
	 }
	 };
	
	 function b_reply(b_id,b_title,b_writer,b_content) {
	 var writer = document.querySelector('input[name="b_writer"]');
	 var title = document.querySelector('input[name="b_title"]');
	 var content = document.querySelector('textarea[name="b_content"]');
	
	 writer.value = b_writer;
	 title.value = b_title;
	 content.value = b_content;
	 $('input[name="b_id"]').attr('value',b_id);
	 }
	 */

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
	var replyopen = false;

	// 취소 버튼 클릭.
	function cancel() {
		$('#h2_qna').html("Q&A 답장하기");
		$('#sendbtn').html('답장하기');
		$('input[name="b_title"]').val('');
		$('textarea[name="b_content"]').val('');
		$('div[id="b_write"]').slideUp("fast");
	}
	/*
	 // 답장창 안열려있을 경우, 열기.
	 if (replyopen == false) {
	 $('#h2_qna').html("Q&A 답장하기");
	 $('#sendbtn').html('답장하기');
	 $('input[name="b_title"]').val('');
	 $('textarea[name="b_content"]').val('');
	 $('#b_write').slideDown("fast");
	 replyopen = true;
	 updateopen = false;
	 } else if (replyopen == true) {
	 $('#b_write').slideUp("fast");
	 replyopen = false;
	 updateopen = false;
	 }

	 var cancelbtn = $('#cancelbtn').text();
	 var replybtn = $('#replybtn').text();

	 if (replyopen == false) {
	 $('div[id="b_write"]').slideUp("fast");
	 replyopen = true;
	 } else if (updateopen == false) {
	 if (replyopen == true || updateopen == true) {
	 $('div[id="b_write"]').slideDown("fast");
	 }
	 }
	
	 */
	// 답장하기 버튼 (답장 & 답글수정)
	function send() {
		var sendForm = $('form[name="b_send"]');
		var text = $('#sendbtn').text();
		if (text == '답장하기') {
			alert("inside: " + text);
			sendForm.action = "qna_replyimpl_mgr.sp";
			sendForm.submit();
		} else if (text == '수정하기') {
			sendForm.action = "qna_updatereplyimpl_mgr.sp";
			sendForm.submit();
		}
	}

	var updateopen = false;
	function b_reply(text, b_id, b_title, b_writer, b_content, b_reply) {
		if (text == '답장하기') {
			if(replyopen == false) {
				var title = document.querySelector('input[name="b_title"]');
				var writer = document.querySelector('input[name="b_writer"]');
				var content = document.querySelector('textarea[name="b_content"]');
				writer.value = b_writer;
				title.value = b_title;
				content.value = b_content;
				$('#h2_qna').html("Q&A 답장하기");
				$('#sendbtn').html('답장하기');
				$('input[name="b_id"]').attr('value', b_id);
				$('#sendbtn').attr('action', 'qna_replyimpl_mgr.sp');
				$('#b_write').show("fast");
				replyopen = true;
				updateopen = false;
			} else if (replyopen == true) {
				$('#b_write').hide("fast");
				replyopen = false;
			}
		} else if (text == '답글수정') {
			if (updateopen == false) {
				var title = document.querySelector('input[name="b_title"]');
				var writer = document.querySelector('input[name="b_writer"]');
				var content = document.querySelector('textarea[name="b_content"]');
				var reply = document.querySelector('textarea[name="b_reply"]');
				writer.value = b_writer;
				title.value = b_title;
				content.value = b_content;
				reply.value = b_reply;
				$('#h2_qna').html("Q&A 답글 수정하기");
				$('#sendbtn').html('수정하기');
				$('input[name="b_id"]').attr('value', b_id);
				$('#sendbtn').attr('action', 'qna_updatereplyimpl_mgr.sp');
				$('#b_write').show("fast");
				updateopen = true;
				replyopen = false;
			} else if (updateopen == true) {
				$('#b_write').hide("fast");
				updateopen = false;
			}
		}

		
	};

	var title = $('input[name="b_title"]').text();
	//title.
	/*
	$(document).ready(
			function() {
				$('input[name="b_title"]').blur(
						function() {
							if ($('input[name="b_title"]').val().length > 30) {
								//alert("hello?");
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
						//event.preventDefault();
						$(this).val($(this).val().substring(0, 10));
					}
				});
			});
	
	 */
</script>
<div id="section-top-border text-right mb-30"></div>
<section class="row align-items-center justify-content-center">
	<div id="b_table">
		<div id="b_header">
			<span class="c1 txt_center">no.</span> <span class="c2 txt_center">제목</span>
			<span class="c3 txt_center">고객ID</span> <span class="c4 txt_center">문의날짜</span><br>
		</div>
		<div id="b_list">
			<c:forEach var="b" items="${blist }">
				<div class="b_collapsible" onclick="row_toggle('${b.b_id }');">
					<span class="c1 txt_center txt_height">${b.b_id }</span> <span
						class="c2 txt_center txt_height">${b.b_title }</span> <span
						class="c3 txt_center txt_height">${b.b_writer }</span> <span
						class="c4 txt_center txt_height">${b.b_regdate }</span>
					<div class="b_button_right txt_center txt_height">
						<a href="qna_deleteimpl_mgr.sp?b_id=${b.b_id }">삭제</a>
						<c:choose>
							<c:when test="${b.b_reply == null }">
								<a class="b_btn" href="#"
									onclick="b_reply('답장하기','${b.b_id}','${b.b_title }','${b.b_writer }','${b.b_content }');">답장하기</a>
							</c:when>
							<c:otherwise>
								<a class="b_btn" href="#"
									onclick="b_reply('답글수정','${b.b_id}','${b.b_title }','${b.b_writer }','${b.b_content }', '${b.b_reply }');">답글수정</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="b_content" id="b_content${b.b_id }">
					<p class="txt_left" id="b_content">${b.b_content }</p>
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
	<!-- form action="qna_replyimpl_mgr.sp" method="post">
		<div id="b_write">
			<div>
				<b>회원명: </b><input type="text" name="b_writer" placeholder="회원명.."
					readonly="readonly" /><br> <b>제목: </b><input type="text"
					name="b_title" placeholder="제목.." readonly="readonly" /><br>
				<textarea rows="10" cols="50" name="b_content" placeholder="문의내용.."
					readonly="readonly"></textarea>
				<br>
				<textarea rows="15" cols="50" placeholder="답글 쓰는곳.." name="b_reply"></textarea>
				<br> <input type="submit" class="b_button" value="답장하기">
				<input type="hidden" name="b_id" value="">

			</div>
		</div>
	</form-->
	<!-- 
	<div class="button-group-area askbtn">
		<a href="#" onclick="qna_toggle('${loginid}');" id="addbtn"
			class="genric-btn primary-border e-large">문의하기</a>
	</div>
	 -->
	<form class="b_send" action="qna_replyimpl_mgr.sp" method="post"
		name="b_send">
		<div id="b_write">
			<div>
				<div class="typography">
					<h2 id="h2_qna">Q&A 답장하기</h2>

					<h4 id="h4_userid">회원ID:&nbsp;</h4>
					<input type="text" name="b_writer" class="single-input-secondary"
						readonly="readonly">
					<h4 id="h4_qnatitle">&nbsp;&nbsp;&nbsp;&nbsp;제목:</h4>
					<input type="text" name="b_title" class="single-input-secondary"
						readonly="readonly">
				</div>
				<span id="textCount"></span>
				<textarea class="form-control" rows="5" cols="35" name="b_content"
					readonly="readonly"></textarea>
				<textarea class="form-control" rows="5" cols="35"
					placeholder="답글을 입력하세요" name="b_reply" required="required"></textarea>
				<br> <a href="#" id="sendbtn" onclick="send();"
					class="genric-btn primary-border e-large">답장하기</a> <a
					onclick="cancel();" id="cancelbtn"
					class="genric-btn danger-border e-large">취소</a> <input
					type="hidden" name="b_id" value="">
			</div>
		</div>
	</form>
</section>
