
/* 


 * Student Info: Name=AniketChoudhury, ID=17233

 * Subject:  CS532B_HW6_Spring_2016

 * Author: choud 

 * Filename: CreateQuestionBankServlet.java 

 * Date and Time: Apr 15, 2016 6:50:15 PM 

 * Project Name: QuestionBank 


 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author choud
 */
public class CreateQuestionBankServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Connection con;
            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (Exception ex) {
                System.out.println("problem with jdbc driver or connection" + ex.getMessage());
            }
            String course = request.getParameter("course_select");
            String question = request.getParameter("question_txt");
            String answer = request.getParameter("answer_txt");
            String checkBox = request.getParameter("checkbox");
            System.out.println("checkBox:" + checkBox);
            //request.getParameter(answer);
            if (request.getParameter("createQuest_submit") != null) {

                Cookie ck[] = request.getCookies();
                if (ck != null) {

                    String cookieName = ck[0].getValue();
                    if (!cookieName.equals("") || cookieName != null) {
                        out.println("welcome" + cookieName);

                        try {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/question_bank", "root", "");
                            PreparedStatement statement = con.prepareStatement("insert into question values(?,?,?)");
                            //statement.setString(1, "1");
                            statement.setString(1, course);
                            statement.setString(2, question);
                            statement.setString(3, answer);
                            int i = statement.executeUpdate();
                            System.out.println(i + " statement updated");

                            RequestDispatcher dis = request.getRequestDispatcher("CreateQuestionBank.jsp");
                            dis.forward(request, response);
                        } catch (IOException ex) {
                            System.out.println("database problem:" + ex.getMessage());
                        } catch (SQLException ex) {
                            System.out.println("sql related problem" + ex.getMessage());
                        }
                    } else {
                        out.println("please login first");
                        request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
                    }

                }

            } else if (request.getParameter("takeQuiz_submit") != null) {

                System.out.println("hello");
                try {

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/question_bank", "root", "");
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery("select QUESTIONS from question where COURSE = 'java';");
                    System.out.println("hello");
                    //statement.setString(1, "1");
//                    statement.setString(1, checkBox);
//                    int i = statement.executeUpdate();
                    //System.out.println(i + " statement updated");
                    HttpSession ses = request.getSession();

                    while (rs.next()) {
                        System.out.println(rs.getString("QUESTIONS"));
                        ses.setAttribute("questionBank", rs.getString("QUESTIONS"));
                        response.sendRedirect("Questions.jsp");
                        return;
                    }

                    RequestDispatcher dis = request.getRequestDispatcher("CreateQuestionBank.jsp");
                    dis.forward(request, response);
                } catch (IOException ex) {
                    System.out.println("database problem:" + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("sql related problem" + ex.getMessage());
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateQuestionBankServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateQuestionBankServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
