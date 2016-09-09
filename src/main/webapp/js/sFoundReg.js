 $(document).ready(function() {

    // $(fakeUpload).hover(function(){
    //     $(this).css('background-color','white'),
    //     $(this).css('color','black');
    // },function(){
    //     $(this).css('background-color','rgba(0,0,0,0)'),
    //     $(this).css('color','white');
    // }
    // );
     $('.imSpace').focus(function(){
        $(this).blur();
    });


     /*///↑↑↑↑///*/
 });

 var file;
 var fileReader;

 function doFirst() {
     document.getElementById('upload').onchange = fileChange;

     function fileChange() {

         file = document.getElementById('upload').files[0];

         fileReader = new FileReader();
         fileReader.readAsDataURL(file);
         fileReader.onload = function() {
             var image = document.getElementById('image');
             var msg = document.getElementById('defaultMSG');
             msg.remove();
             image.src = fileReader.result;
             image.idName + "image";
             // image.style.width = '300px';
             // image.style.height = '200px';
         };
     }
 }
 window.addEventListener('load', doFirst, false);
