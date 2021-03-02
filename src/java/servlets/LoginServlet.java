
package servlets;

import java.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 735815
 */
public class LoginServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();              
        
        String password = request.getParameter("password");        
        String username = request.getParameter("username");
        String logout = request.getParameter("logout");
        
      
          if (logout != null) {
              
              session.invalidate();
              request.setAttribute("message", "You are now logged out. Bye!");
         request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          }
              
        
          else if (session.getAttribute("username") != null) {
              request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          }
                            
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);               
            }
        
       

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   HttpSession session = request.getSession();              
        
        String password = request.getParameter("password");        
        String username = request.getParameter("username");
      
        
        AccountService userService = new AccountService();
       
        
      if (userService.login(username, password) != null) {
          session.setAttribute("username", username);
          response.sendRedirect("/WEB-INF/home.jsp");
      }
        
      else {
          request.setAttribute("message", "Username or password not valid");

 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      }  
}
}
