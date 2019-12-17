<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<style>
#submenu {
	/* float: right; */
	
}

#submenu>a:nth-child(3) {
	float: right;
}

#container {
	display: block;
}

#selection {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	padding-top: 15px;
	padding-bottom: 15px;
}

#selection>div {
	display: inline;
}
</style>
<script>
	function display(data) {
		Highcharts
				.chart(
						'container_stat',
						{
							chart : {
								zoomType : 'xy'
							},
							title : {
								text : '월별 총매출 및 수익률'
							},
							subtitle : {
								text : ''
							},
							xAxis : [ {
								categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
										'May', 'Jun', 'Jul', 'Aug', 'Sep',
										'Oct', 'Nov', 'Dec' ],
								crosshair : true
							} ],
							yAxis : [
									{ // Primary yAxis
										labels : {
											format : '{value} 원',
											style : {
												color : Highcharts.getOptions().colors[0]
											}
										},
										title : {
											text : '총매출',
											style : {
												color : Highcharts.getOptions().colors[0]
											}
										}
									},
									{ // Secondary yAxis
										title : {
											text : '수익률',
											style : {
												color : Highcharts.getOptions().colors[0]
											}
										},
										labels : {
											format : '{value} %',
											style : {
												color : Highcharts.getOptions().colors[0]
											}
										},
										opposite : true
									} ],
							tooltip : {
								shared : true
							},
							legend : {
								layout : 'vertical',
								align : 'left',
								x : 120,
								verticalAlign : 'top',
								y : 100,
								floating : true,
								backgroundColor : Highcharts.defaultOptions.legend.backgroundColor
										|| // theme
										'rgba(255,255,255,0.25)'
							},
							series : data
						});
	}

	function getData() {
		var data = [
				{
					name : '총매출',
					type : 'column',
					yAxis : 1,
					data : [ 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6,
							148.5, 216.4, 194.1, 95.6, 54.4 ],
					tooltip : {
						valueSuffix : ' 원'
					},
					color : Highcharts.getOptions().colors[6]
				},
				{
					name : '수익률',
					type : 'spline',
					data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3,
							18.3, 13.9, 9.6 ],
					tooltip : {
						valueSuffix : '%'
					},
					color : Highcharts.getOptions().colors[1]
				} ];
		display(data);
	};

	$(document).ready(function() {
		getData();
	});
	function selected(text) {
		alert(text);
	}
</script>
<section class="row align-items-center justify-content-center">
	<div class="container">
		<div class="row justify-content-center">

			<div class="nice-select" tabindex="0">
				<span class="current">전체</span>
				<ul class="list">
					<li data-value="All" class="option selected">전체</li>
					<li data-value="New" class="option">New Arrival</li>
					<li data-value="Best" class="option">Best</li>
				</ul>
			</div>

			<div class="nice-select" tabindex="0">
				<span class="current">1년</span>
				<ul class="list">
					<li data-value="1" class="option selected">1년</li>
					<li data-value="2" class="option">2년</li>
					<li data-value="3" class="option">3년</li>
				</ul>
			</div>
			<div class="nice-select" tabindex="0">
				<span class="current">월별</span>
				<ul class="list">
					<li data-value="monthly" class="option selected"><a
						href="statpayment.sp">월별</a></li>
					<li data-value="yearly" class="option">년별</li>
					<li data-value="daily" class="option">일별</li>
				</ul>
			</div>
		</div>
		<br>
	</div>
</section>
<div id="container_stat"></div>
