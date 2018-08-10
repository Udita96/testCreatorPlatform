<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>add question here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://mdbootstrap.com/previews/docs/latest/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://mdbootstrap.com/previews/docs/latest/css/mdb.min.css" rel="stylesheet">
    <link href="createteststylesheet.css" rel="stylesheet">
     <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


    <script>
$(document).ready(function(){
    $("#addques").click(function(){
        $("#div1").load("blankform.html");
    });
    $("#addquesdetail").click(function(){
        $("#div1").load("samplequestion.html");
    });
});
</script>

</head>
<body>



 <div class="row">
    <header>
<nav class="navbar navbar-expand-lg navbar-dark default-color-dark fixed-top">
    <a class="navbar-brand" href="practice2.html">Create Test</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
               <a href="<c:url value="selectalltest" />" > Edit Test </a><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Take Test</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Test Record</a>
            </li>
        </ul>
         
    </div>
</nav>
</header>
    </div>
    <div class='flex-scroll scroll-styled pad2'>
      Scrollable content
    </div>
    <div>
        <div class="row" id="sidebar">
            <div class="col-lg-2">
                <nav>
                <ul id="quespanel">
                    <a href="addques.jsp"><li> <button id="addques" > add question </button></li></a>
                    <li> <button id=addquesdetail> question </button></li>
                </ul>
              </nav>
            </div>
            <div class="col-lg-10">
                <div id="div1">
                all the best for test bro :) . 
                </div>
            </div>
        </div>
    </div>
    
    <footer  id="footer">
    <div class="text-center py-2 lead">Copyright © 2017 </div>
</footer>
    
    
    
    
    
    
</body>
</html>