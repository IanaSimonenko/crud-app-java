import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.jsp'>Add New User</a>");
        out.println("<h1>Users List</h1>");

        List<Users> list=UsersDAO.getAllEmployees();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Login</th><th>Password</th><th>Email</th><th>Country</th> <th>Edit</th><th>Delete</th></tr>");
        for(Users users:list){
            out.print("<tr><td>"+users.getId()+"</td><td>"+users.getLogin()+"</td><td>"+users.getPassword()+"</td> <td>"+users.getEmail()+"</td><td>"+users.getCountry()+"</td><td><a href='EditServlet?id="+users.getId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+users.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
