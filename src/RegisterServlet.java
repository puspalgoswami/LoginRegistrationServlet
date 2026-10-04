import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String enrollment = request.getParameter("enrollment");
        String batch = request.getParameter("batch");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_db", "root", "root");

            String sql = "INSERT INTO students " +
                "(name,enrollment,batch,email,mobile,dob,address,state,city,username,password) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, enrollment);
            ps.setString(3, batch);
            ps.setString(4, email);
            ps.setString(5, mobile);
            ps.setString(6, dob);
            ps.setString(7, address);
            ps.setString(8, state);
            ps.setString(9, city);
            ps.setString(10, username);
            ps.setString(11, password);

            ps.executeUpdate();

            out.println("<h1>Registration Successful!</h1>");
            out.println("<a href='login.html'>Go to Login</a>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h2>Registration Error: " + e.getMessage() + "</h2>");
        }
    }
}
