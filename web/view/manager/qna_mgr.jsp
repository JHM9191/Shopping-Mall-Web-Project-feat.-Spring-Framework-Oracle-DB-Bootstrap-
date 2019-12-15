<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
#submenu>a:nth-child(2) {
	float: right;
}

#b_table {
	float: left;
}

#b_header {
	background: black;
	color: white;
}

#b_list {
	width: 900px;
	height: 500px;
	overflow: scroll;
	float: left;
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
	float: left;
	width: 85%;
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

.b_collapsible:hover {
	background-color: orange;
	cursor: pointer;
}

.b_content {
	display: none;
}

#b_reply {
	color: red;
}

td>div {
	
}

#b_write {
	position: relative;
	float: right;
}
/*#b_write input[name="b_title"] {
	width: 100%;
	height: 50px;
	text-size: 1.5em;
}*/
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
	
</script>

<section>
	<div id="b_table">
		<div id="b_header">
			<span class="c1 txt_center">no.</span> <span class="c2 txt_center">제목</span>
			<span class="c3 txt_center">고객ID</span> <span class="c4 txt_center">문의날짜</span><br>
		</div>
		<div id="b_list">
			<c:forEach var="b" items="${blist }">
				<div class="b_collapsible" onclick="tr_toggle(${b.b_id })">
					<span class="c1 txt_center txt_height">${b.b_id }</span> <span
						class="c2 txt_center txt_height">${b.b_title }</span> <span
						class="c3 txt_center txt_height">${b.b_writer }</span> <span
						class="c4 txt_center txt_height">${b.b_regdate }</span>
				</div>
				<div class="b_button_right txt_center txt_height">
					<a href="qna_deleteimpl_mgr.sp?b_id=${b.b_id }">삭제</a>
					<c:choose>
						<c:when test="${b.b_reply == null }">
							<a class="b_btn"
								onclick="b_reply('${b.b_id}','${b.b_title }','${b.b_writer }','${b.b_content }');">답장하기</a>
						</c:when>
						<c:otherwise>
							<a>답장완료</a>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="b_content" id="${b.b_id }">
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
	<form action="qna_replyimpl_mgr.sp" method="post">
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
	</form>
</section>