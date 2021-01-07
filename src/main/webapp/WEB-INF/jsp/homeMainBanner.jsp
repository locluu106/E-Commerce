
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            @keyframes my { 
	 0% { color: blue;  } 
	 50% { color: red;  }
	 100% { color: black;  } 
 }
             .test {
         background:white;
         font-size:24px;
         font-weight:bold;
	 -webkit-animation: my 700ms infinite;
	 -moz-animation: my 700ms infinite; 
	 -o-animation: my 700ms infinite; 
	 animation: my 700ms infinite;
}
        </style>
    </head>
    <body>
        <div style=" margin-left: 110px; margin-right: 110px ">
            <div class="w3-content w3-section"  >
                <img class="mySlides" src="images/slider/a1.jpg" alt="Men slide img" style="width:100%; height: 400px">
                <img class="mySlides" src="images/slider/b2.jpg" alt="Men slide img" style="width:100%; height: 400px">
                <img class="mySlides" src="images/slider/b3.jpg" alt="Men slide img" style="width:100%; height: 400px">
                <img class="mySlides" src="images/slider/a5.jpg" alt="Men slide img" style="width:100%; height: 400px">
            </div>
            <script>
                var myIndex = 0;
                carousel();
                function carousel() {
                    var i;
                    var x = document.getElementsByClassName("mySlides");
                    for (i = 0; i < x.length; i++) {
                        x[i].style.display = "none";
                    }
                    myIndex++;
                    if (myIndex > x.length) {
                        myIndex = 1
                    }
                    x[myIndex - 1].style.display = "block";
                    setTimeout(carousel, 2000); // Change image every 2 seconds
                }
            </script> 
            <br><br>
        </div>
       
       
    </body>
</html>
