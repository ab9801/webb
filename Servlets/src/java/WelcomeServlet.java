import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");
            Cookie[] ck = request.getCookies();
            if(ck!=null) {
                String name = ck[0].getValue();
                out.print("<div align='center'> ");
                out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/CSS/styles.css' />");
                out.print("<h2> Hello " + name + "</h2>" +"</br>");
                out.print("<a href='LogoutServlet' class='button3'>LogOut</a>");
                out.print("</div>");
            }
            else {
                out.print("<h3> Kindly login to access your profile! </h3> ");
                request.getRequestDispatcher("login.html").include(request, response);
            }
            
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.close();
        
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
