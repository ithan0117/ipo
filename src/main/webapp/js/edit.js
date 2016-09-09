 $(document).ready(function(){
  
  $('#showPassword').click(function(){
	  if($('#m_newPassword').attr("type")=="password"){
		  $('#m_newPassword').attr("type","text");
          $('#passwordConfirm').attr("type","text");
	  }
	  else{
		  $('#m_newPassword').attr("type","password");
          $('#passwordConfirm').attr("type","password");
	  }
  });
		/*////↑↑顯示密碼↑↑///*/
   
    $(function(){
	$("#form").validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules:{
            m_nickname:"required",
            m_password:"required",
            m_newPassword:"required",
            passwordConfirm:{
             required:true,   
             equalTo:"#m_newPassword"
            }
            
        },
        messages:{
            m_nickname:"請填寫此欄位",
            m_password:"請填寫此欄位",
            m_newPassword:"請填寫此欄位",
            passwordConfirm:{
                required:"請填寫此欄位",
                equalTo:"輸入的密碼不相同"
            }
        }
        
    });
    });
	
	$("#save").hover(function(){
		$(this).css("background-color","#a1f000");
	},function(){		
		$(this).css("background-color","#99ff00")
	});
	/*////↑↑Hover↑↑///*/
   /**/
    


    
});

