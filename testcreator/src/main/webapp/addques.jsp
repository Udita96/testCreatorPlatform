<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>add question here</title>

</head>
<body>


 <div class="question">

    </div>
<form method="post" action = 'addquestion' name=quesform>
<textarea name="questionText"  col=50 row=25></textarea>
    <div class="options" id="options">
    <input type=radio name=correctoption   value = 'o1' /> <input type=text name=option1/><br>
    
    <input type=radio name=correctoption   value = 'o2' /> <input type=text name=option2/><br>
    
    <input type=radio name=correctoption   value = 'o3' /> <input type=text name=option3/><br>
    
    <input type=radio name=correctoption   value = 'o4' /> <input type=text name=option4/><br>
    </div>
    <input type="submit" value='add question'>
    
    
    
</body>
</html>