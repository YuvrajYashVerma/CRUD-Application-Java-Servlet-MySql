import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ShowAll extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
        out.println("<link rel='stylesheet' href='abc.css' />");
        out.println("</head>");
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<ul><li>Home</li><li><a href='insertdemo.html'>Insert</a></li><li><a href='ShowAll'>Show</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li><a href='login.html'>LogOut</a></li><li>About</li><li>Contact</li></ul></div");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///yuvidb","root","muskan143");
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from marks");
			out.println("<center>");
			out.println("<table align='center' cellpadding='12'>");
			out.println("<tr>");
			out.println("<th> URNO </th>");
			out.println("<th> UNAME </th>");
			out.println("<th> UPHY </th>");
			out.println("<th> UCHEM </th>");
			out.println("<th> UMATHS </th>");
			out.println("</tr>");
			while(rs.next()){
			    out.println("<tr>");
				out.println("<th>"+rs.getString(1)+"</th>");
				out.println("<th>"+rs.getString(2)+"</th>");
				out.println("<th>"+rs.getString(3)+"</th>");
				out.println("<th>"+rs.getString(4)+"</th>");
				out.println("<th>"+rs.getString(5)+"</th>");
				out.println("</tr>");				
			}
			out.println("</table>");
			out.println("</center>");
			con.close();
		}
		catch(Exception e){
			out.println("<h1>"+e+"<h2>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}