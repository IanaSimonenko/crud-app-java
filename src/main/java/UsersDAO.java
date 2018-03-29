import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    public static void main(String[] args) throws ClassNotFoundException {
        getConnection();
    }

    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;

        String URL = "jdbc:postgresql://127.0.0.1:5432/users";
        String NAME = "postgres";
        String PASSWORD = "2017";

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, NAME, PASSWORD);

//            Statement statement = null;
//            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static int saveUsers(Users users){
        int status=0;
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "INSERT INTO users(login,password,email,country) values (?,?,?,?)");
            ps.setString(1,users.getLogin());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getEmail());
            ps.setString(4,users.getCountry());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int updateUsers(Users users){
        int status=0;
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "UPDATE users SET login=?,password=?,email=?,country=? WHERE id=?");
            ps.setString(1,users.getLogin());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getEmail());
            ps.setString(4,users.getCountry());
            ps.setInt(5,users.getId());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int deleteUsers(int id){
        int status=0;
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    public static Users getEmployeeById(int id){
        Users users=new Users();

        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                users.setId(rs.getInt(1));
                users.setLogin(rs.getString(2));
                users.setPassword(rs.getString(3));
                users.setEmail(rs.getString(4));
                users.setCountry(rs.getString(5));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return users;
    }
    public static List<Users> getAllEmployees(){
        List<Users> list=new ArrayList<Users>();

        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM users");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Users users=new Users();
                users.setId(rs.getInt(1));
                users.setLogin(rs.getString(2));
                users.setPassword(rs.getString(3));
                users.setEmail(rs.getString(4));
                users.setCountry(rs.getString(5));
                list.add(users);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

}
