<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Converter Result</title>
</head>
<body>
   <div>
    <h2>Number Converter</h2>
    <form method="post" action="ConvertServlet">
        <label for="number">Enter Base 10 Number : <input type="text" id="number" name="number"></label>  
        <br>
        <input type="submit"  id="binary" name="btn" value="binary">
        <input type="submit"  id="hexa" name="btn" value="hexa">  
        <input type="submit" id="octal" name="btn" value="octal">
        <input type="reset">
    </form>
   </div>
   
    <div id="result">
    <h2 >Result</h2>
    <%-- Display the Name --%>
    
    <%-- Display the number to convert --%>
    <p> <%= request.getAttribute("numberToConvert") %></p>
    
    <%-- Display the converted number --%>
    <p> <%= request.getAttribute("convertedNumber") %></p>
    
    <%-- Display the description of the conversion --%>
    <p style="color: blue;"><%= request.getAttribute("description") %></p>
    
    <%-- Display any error message, if applicable --%>
    <% String error = (String) request.getAttribute("error");
       if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><strong>Error:</strong> <%= error %></p>
    <% } %>
    
    <%-- Provide a link to go back to the converter form --%>
    <p><a href="InputPage.html">First Question</a></p>
    </div>
    
</body>
</html>
