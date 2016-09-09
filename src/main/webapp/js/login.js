 $(document).ready(function(){
   
    $(function(){
	$("#form").validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules:{
            m_password:"required",
            m_account:"required",
        },
        messages:{
            m_account:"請輸入使用者信箱",
            m_password:"請輸入密碼"
        }
        
    });
    });
	
	$("#signIn").hover(function(){
		$(this).css("background-color","#a1f000");
	},function(){		
		$(this).css("background-color","#99ff00")
	});
	/*////↑↑Hover↑↑///*/
	
	
   /**/
    
});

