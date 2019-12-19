<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<head>

</head>
      <!-- banner part start-->
    <section class="banner_part">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-7">
                    <div class="banner_slider">
                        <div class="single_banner_slider">
                            <div class="banner_text">
                                <div class="banner_text_iner">
                                    <img src="img/shopping.JPG" alt="logo">
                     
                        
                                    
                                    <h1>Fashion Collection 2019</h1>
                                    <a href="#" class="btn_1" onclick="menuClicked('New');">shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- banner part end-->
    
    
	<!-- best arrival part here -->
	<section class="new_arrival section_padding">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-8">
					<div class="arrival_tittle">
						<h2>Best</h2>
					</div>
				</div>


				<!-- 영역 나눌때 문제, all -->
				<div class="col-lg-5">
					<div class="arrival_filter_item filters"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">

				<c:forEach var="pbest" items="${jsp_bestlist }">

					<div class="col-md-4">
						<img src="img/product_img/${pbest.p_id}.jpg">
					</div>
				</c:forEach>

			</div>
		</div>

	</section>
	<!-- new arrival part end -->


    <!-- new arrival part here -->



	<section class="new_arrival section_padding">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-8">
					<div class="arrival_tittle">
						<h2>New arrival</h2>
					</div>
				</div>

				<!-- 영역 나눌때 문제, all -->

				<div class="col-lg-5">
					<div class="arrival_filter_item filters"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">

				<c:forEach var="pnew" items="${jsp_newlist }">

					<div class="col-md-4">
						<img src="img/product_img/${pnew.p_id}.jpg">
					</div>
				</c:forEach>

			</div>
		</div>

	</section>

	
	<!-- new arrival part end -->