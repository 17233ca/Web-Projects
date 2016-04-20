
/* 


 * Student Info: Name=AniketChoudhury, ID=17233

 * Subject:  CS532B_HW6_Spring_2016

 * Author: choud 

 * Filename: LoginServlet.java 

 * Date and Time: Apr 15, 2016 2:41:44 PM 

 * Project Name: QuestionBank 


 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
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
public class LoginServlet extends HttpServlet {

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
            LoginBO loginObj = new LoginBO();
            HttpSession ses = request.getSession();
            if (request.getParameter("admin_submit") != null) {
                String userName = request.getParameter("userName_txt");
                String password = request.getParameter("password_txt");
                if (userName.equals("admin") && password.equals("admin")) {
                    loginObj.setUserName("request.getParameter(\"userName_txt\")");
                    loginObj.setPassword("request.getParameter(\"password_txt\")");
                    //ses.setAttribute("adminLoggedIn", loginObj);
                    Cookie ck = new Cookie("adminName", request.getParameter("userName_txt"));
                    response.addCookie(ck);
                    RequestDispatcher dis = request.getRequestDispatcher("CreateQuestionBank.jsp");
                    dis.forward(request, response);
                } else {
                    request.setAttribute("message", "invalid userID or password");
                    RequestDispatcher dis = request.getRequestDispatcher("AdminLogin.jsp");
                    dis.forward(request, response);
                }
            } else if (request.getParameter("student_submit") != null) {
                String userName = request.getParameter("userName_txt");
                String password = request.getParameter("password_txt");
                if (userName.equals("student") && password.equals("student")) {
                    loginObj.setUserName("student");
                    loginObj.setPassword("student");
                    synchronized (ses) {
                        ses.setAttribute("studentLogin", loginObj);
                        response.sendRedirect("SelectQuestion.jsp");
                    }
                } else {
                    request.setAttribute("message", "invalid userID or password");
                    RequestDispatcher dis = request.getRequestDispatcher("StudentLogin.jsp");
                    dis.forward(request, response);
                }

            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
