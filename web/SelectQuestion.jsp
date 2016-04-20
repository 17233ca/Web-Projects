<%-- 
    Document   : SelectQuestion
    Created on : Apr 15, 2016, 1:37:35 PM
    Author     : choud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Question</title>
    </head>
    <body>
        <h1>Select Question</h1>
        <form>
            <fieldset name="checkbox">
                <table border="1">
                    <tr style="height: 17%">
                        <td style="width: 50%">
                            <table border="1">
                                <tr style="height: 100%">
                                    <td align="right" style="width: 80%"><input type="checkbox" name="java_check" value="java_check"/>java</td>&nbsp;<td style="width: 20%"><input type="text" name="java_txt" size="4"/></td>
                                </tr>

                            </table>
                        </td>
                    </tr>

                    <tr style="height: 17%">
                        <td style="width: 50%">
                            <table border="1">
                                <tr style="height: 100%">
                                    <td align="right" style="width: 80%"><input type="checkbox" name="php_check" value="php_check"/>php</td>&nbsp;<td style="width: 20%"><input type="text" name="php_txt" size="4"/></td>
                                </tr>

                            </table>
                        </td>

                    </tr>

                    <tr style="height: 17%">
                        <td style="width: 50%">
                            <table border="1">
                                <tr style="height: 100%">
                                    <td align="right" style="width: 80%"><input type="checkbox" name="c++_check" value="c++_check"/>C++</td>&nbsp;<td style="width: 20%"><input type="text" name="c++_txt" size="4"/></td>
                                </tr>

                            </table>
                        </td>
                    </tr>

                    <tr style="height: 17%">
                        <td style="width: 50%">
                            <table border="1">
                                <tr style="height: 100%">
                                    <td align="right" style="width: 80%"><input type="checkbox" name="html_check" value="html_check"/>html</td>&nbsp;<td style="width: 20%"><input type="text" name="html_txt" size="4"/></td>
                                </tr>

                            </table>
                        </td>
                    </tr>

                    <tr style="height: 17%">
                        <td style="width: 50%">
                            <table border="1">
                                <tr style="height: 100%">
                                    <td align="right" style="width: 80%"><input type="checkbox" name="dbms_check" value="dbms_check"/>dbms</td>&nbsp;<td style="width: 20%"><input type="text" name="dbms_txt" size="4"/></td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"><input type="submit" name="takeQuiz_submit" value="Submit" onclick="form.action='CreateQuestionBankServlet';"/></td>
                    </tr>
                </table>  
            </fieldset>
        </form>
    </body>
</html>
