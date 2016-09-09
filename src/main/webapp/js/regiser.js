 $(document).ready(function(){
  
  $('#showPassword').click(function(){
	  if($('#m_password').attr("type")=="password"){
		  $('#m_password').attr("type","text");
          $('#passwordConfirm').attr("type","text");
	  }
	  else{
		  $('#m_password').attr("type","password");
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
            m_account:"required",
            passwordConfirm:{
             required:true,   
             equalTo:"#m_password"
            }
            
        },
        messages:{
            m_nickname:"請填寫此欄位",
            m_password:"請填寫此欄位",
            m_account:"請填寫此欄位",
            passwordConfirm:{
                required:"請填寫此欄位",
                equalTo:"輸入的密碼不相同"
            }
        }
        
    });
    });
	
	$("#signUp").hover(function(){
		$(this).css("background-color","#a1f000");
	},function(){		
		$(this).css("background-color","#99ff00")
	});
	/*////↑↑Hover↑↑///*/
   /**/
    


    
});

