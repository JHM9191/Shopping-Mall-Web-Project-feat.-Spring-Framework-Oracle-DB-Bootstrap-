function menuClicked(menu) {
		if (menu == 'All') {
			location.href = "plist.sp?menu=All&cat=none&pagenum=1&contentnum=9";
		} else if (menu == 'New') {
			location.href = "plist.sp?menu=New&cat=none&pagenum=1&contentnum=9";
		} else if (menu == 'Best') {
			location.href = "plist.sp?menu=Best&cat=none&pagenum=1&contentnum=9";
		}
	};
	
	$.ajax({
		url:'getcartqty.sp',
		type: 'get',
		success:function(data){
			if(data == 0){
			}else{
				$("#msg_setting").html('<div id="notification">'+data+'&nbsp;</div>');
			}
		}
	});