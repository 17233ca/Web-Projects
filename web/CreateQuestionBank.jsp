<%-- 
    Document   : CreateQuestionBank
    Created on : Apr 15, 2016, 12:39:35 PM
    Author     : choud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Question bank</title>
    </head>
    <body>
        <h1>Create Question Bank</h1>
        <a href="index.jsp">Home</a>|
        <a href="StudentLogin.jsp">Student</a>|
        <a href="LogoutServlet">Logout</a><br/>
        <%Cookie ck[] = request.getCookies();
            for (int i = 0; i < ck.length; i++) {
                String cookieName = ck[i].getValue();%>
        <%=cookieName%>
        <%}
        %>
        <form method="post">
            <table border="1">
                <tr>
                    <td style="width: 50%">
                        <table>
                            <tr style="height: 100">
                                <td style="width: 100%">
                                    <select name="course_select">
                                        <option value="java">java</option>
                                        <option value="php">php</option>
                                        <option value="c++">c++</option>
                                        <option value="html">html</option>
                                        <option value="dbms">dbms</option>
                                    </select></td>
                            </tr>

                        </table>

                    </td>

                </tr>

                <tr>

                    <td style="width: 50%">
                        <table>
                            <tr style="height: 100%">
                                <td style="width: 50%">Question:</td><td style="width: 50%" align="left"><input type="text" name="question_txt" size="50"></td>

                            </tr>
                        </table>
                    </td>

                </tr>

                <tr>

                    <td style="width: 50%">
                        <table>
                            <tr style="height: 100%">
                                <td style="width: 50%">Answer:</td><td style="width: 50%"><textarea name="answer_txt" rows="4" cols="50"></textarea></td>

                            </tr>
                        </table>
                    </td>

                </tr>

                <tr>

                    <td style="width: 100%" align="center"><input type="Submit" name="createQuest_submit" value="Submit" onclick="form.action = 'CreateQuestionBankServlet';"></td>

                </tr>
            </table>




        </form>
    </body>
</html>
