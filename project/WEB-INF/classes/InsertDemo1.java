import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class InsertDemo1 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		String s3=request.getParameter("u3");
		String s4=request.getParameter("u4");
		String s5=request.getParameter("u5");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///yuvidb","root","muskan143");
			Statement st=con.createStatement();
			int x =  st.executeUpdate("insert into marks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			if(x!=0){
				response.sendRedirect("ShowAll");
			}
			else{
				out.println("<h1>Data is Not Inserted</h1>");
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