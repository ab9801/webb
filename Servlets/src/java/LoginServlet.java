import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        try {
            String un = request.getParameter("username");
            String pw = request.getParameter("password");
            
            if(Authenticator.loginValidate(un,pw)) { //valid username and password combo
                Cookie ck = new Cookie("username" , request.getParameter("username"));
                ck.setMaxAge(60*10); //in seconds
                response.addCookie(ck);
                out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/CSS/styles.css' />");
                out.print("<div class=buttons>");
                out.print("<a href='WelcomeServlet' class='button1'>View Profile</a>");
                out.print("<a href='LogoutServlet' class='button2'>Log Out</a>");
            }
            else {
                out.print("Username or password error!");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request,response);
            }
            out.close();
        } catch(Exception e) {
            out.print("EXCEPTION!!");
            out.print("</br>"  + e.getMessage());
            e.printStackTrace();
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
