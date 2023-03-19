package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.UserService;

/**
 *
 * @author Anmolpreet
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();

        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
            String email2 = null;
            if(request.getParameter("change") != null){
            if (request.getParameter("change").equals("edit")) {
            try {
                email2 = request.getParameter("email2");
                User user2 = us.get(email2);
                request.setAttribute("user2", user2);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else if (request.getParameter("change").equals("delete")) {
            try {
                email2 = request.getParameter("email2");
                us.delete(email2);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            }

        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        Role role = null;
       
            String email = request.getParameter("email");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String roleName = request.getParameter("role");
            if (roleName.equals("regular user")) {
                role = new Role(2, roleName);
            } else {
                role = new Role(1, roleName);
            }
          try {
              if(request.getParameter("change").equals("Add user")){
              us.insert(email, fname, lname, password, role);
              }
              else if(request.getParameter("change").equals("Update")){
              us.update(email, fname, lname, password, role);
              }
              else  if(request.getParameter("change").equals("Cancel")){
              us.update(email, fname, lname, password, role);
              request.setAttribute("message", "Cancelled");
              }
        } catch (Exception e) {

        }
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        


        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

}
