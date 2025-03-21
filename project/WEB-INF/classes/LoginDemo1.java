import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo1 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///yuvidb","root","muskan143");
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from regis where UNAME='"+s1+"' AND UPASS='"+s2+"'");
			if(rs.next()){
				response.sendRedirect("menu.html");
			}
			else{
			    out.println("<h1>Invalid Username And Password</h1>");	
			}
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