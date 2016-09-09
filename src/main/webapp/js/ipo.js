 $(document).ready(function(){
  
  //  $('#login').hover(function(){
  //       $(this).attr("src","images/login1.png");
  //       $('#talkbubble').show();
  //   },function(){
  //       $(this).attr("src","images/login2.png");
  //         $('#talkbubble').hide();
  //   }
  // );
  //   $('#talkbubble').hover(function(){
  //       $(this).show();
  //   });
    /*///↑↑滑過圖時，顯示對話框，且滑鼠下移滑到對話框時，使它保持"顯示"↑↑///*/

    $('a,input,button').focus(function(){
        $(this).blur();
    });
    /*///↑↑取消點擊時產生的border↑↑///*/
  
	$('#search').hover(function(){
        $(this).attr("src","images/search2.png");
    },function(){
        $(this).attr("src","images/search.png");
		}
	);
	
	$('#stray').hover(function(){
        $(this).attr("src","images/stray2.png");
    },function(){
        $(this).attr("src","images/stray.png");
		}
	);
	
	$('#item').hover(function(){
        $(this).attr("src","images/item2.png");
    },function(){
        $(this).attr("src","images/item.png");
		}
	);
	
	$('#lifepost').hover(function(){
        $(this).attr("src","images/lifepost2.png");
    },function(){
        $(this).attr("src","images/lifepost.png");
		}
	);


    // $('#login3').hover(function(){
    //     $(this).attr("src","images/login1.png");
    // },function(){
    //     $(this).attr("src","images/login3.png");
    
    // });

    // $('.navbar-right>a').hover(function(){
    //     $('#login3').attr("src","images/login1.png");
    // },function(){
    //     $('login1').attr("src","images/login3.png");
    
    // });


  /*///↑↑圖片hover效果↑↑///*/
  
  /*///↑↑↑↑///*/
});