<%-- 
    Document   : Questions
    Created on : Apr 15, 2016, 2:35:18 PM
    Author     : choud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions</title>
    </head>
    <body>
        <h1>Answer The Following Questions</h1>
        
        <table border="0">
            <tr style="height: 30%">
                <td style="width: 50%">Questions: <%=session.getAttribute("questionBank")%></td>
            </tr>
            
            <tr style="height: 30%">
                <td style="width: 50%"><textarea name="studentQuestion_textarea" rows="4" cols="50"></textarea></td>
            </tr>
            
            <tr style="height: 40%">
                <td style="width: 50%" align="left"><input type="submit" value="submit"/></td>
            </tr>
        </table>
                
    </body>
</html>
