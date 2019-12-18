<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	function display(data, dbdata) {
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
								categories : dbdata[1],
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

	function getData(pt, period, cond) {
		$.ajax({
			url : 'statpayment.sp?productType=' + pt + '&period=' + period
					+ '&cond=' + cond,
			success : function(dbdata) {
				var data = [ {
					name : '총매출',
					type : 'column',
					yAxis : 1,
					data : dbdata[0],
					tooltip : {
						valueSuffix : ' 원'
					},
					color : Highcharts.getOptions().colors[6]
				}

				/*
				,
				{
					name : '수익률',
					type : 'spline',
					data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
							26.5, 23.3, 18.3, 13.9, 9.6 ],
					tooltip : {
						valueSuffix : '%'
					},
					color : Highcharts.getOptions().colors[1]
				}
				 */
				];
				//alert(dbdata[1]);
				display(data, dbdata);
			},
			error : function() {
			}

		});
	};

	$(document).ready(function() {
		getData('${productType}', '${period}', '${cond}');
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
					<li data-value="All" class="option selected"><a
						href="statistics_mgr.sp?productType=All&period=${period }&cond=${cond}">전체</a></li>
					<li data-value="New" class="option"><a
						href="statistics_mgr.sp?productType=New&period=${period }&cond=${cond}">New
							Arrival</a></li>
					<li data-value="Best" class="option"><a
						href="statistics_mgr.sp?productType=Best&period=${period }&cond=${cond}">Best</a></li>
				</ul>
			</div>

			<div class="nice-select" tabindex="0">
				<span class="current">전체기간</span>
				<ul class="list">
					<li data-value="1" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=total&cond=${cond}">전체기간</a></li>
					<li data-value="2" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=1&cond=${cond}">최근
							1년</a></li>
					<li data-value="3" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=2&cond=${cond}">최근
							2년</a></li>
					<li data-value="4" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=3&cond=${cond}">최근
							3년</a></li>
				</ul>
			</div>
			<div class="nice-select" tabindex="0">
				<span class="current">월별</span>
				<ul class="list">
					<li data-value="monthly" class="option selected"><a
						href="statistics_mgr.sp?productType=${productType }&period=${period }&cond=monthly">월별</a></li>
					<li data-value="yearly" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=${period }&cond=yearly">년별</a></li>
					<li data-value="daily" class="option"><a
						href="statistics_mgr.sp?productType=${productType }&period=${period }&cond=daily">일별</a></li>
				</ul>
			</div>
		</div>
		<br>
	</div>
</section>
<div id="container_stat"></div>
