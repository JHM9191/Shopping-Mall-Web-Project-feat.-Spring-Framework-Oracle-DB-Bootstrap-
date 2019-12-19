$(function(){
//아이디 중복체크
    $('#u_id').blur(function(){
       //alert($('#u_id').val())
        $.ajax({
        type:"POST",
        url:"idCheck.sp",
        data:{
               "u_id":$('#u_id').val()
        },
        success:function(data){   //data : checkSignup에서 넘겨준 결과값
               if($.trim(data)=="YES"){
                  if($('#u_id').val()!=''){ 
                     alert("사용가능한 아이디입니다.");
                     $request.abort();
                 }  }
               else{
                  if($('#u_id').val()!=''){
                        alert("중복된 아이디입니다.");
                        $('#u_id').val('');
                        $('#u_id').focus();
                  }
               }
            }
       }) 
     })

});
