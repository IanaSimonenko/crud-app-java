import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Users</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        Users users=UsersDAO.getEmployeeById(id);

        out.print("<form action='EditServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+users.getId()+"'/></td></tr>");
        out.print("<tr><td>Login:</td><td><input type='text' name='name' value='"+users.getLogin()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+users.getPassword()+"'/> </td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+users.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Country:</td><td>");
        out.print("<select name='country' style='width:150px'>");
        out.print("<option>Russia</option>");
        out.print("<option>Ukraine</option>");
        out.print("<option>USA</option>");
        out.print("<option>Other</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
