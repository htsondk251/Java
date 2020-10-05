package murach.sql;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;		//to use jdbc classes

public class SQLGatewayServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sqlStatement = request.getParameter("sqlStatement");
		String sqlResult = "";

		try {
			//explicit loads MySQL database driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//get a connection
			String dbURL = "jdbc:mysql://127.0.0.1:3306/murach";
			String username = "murach_user";
			String password = "sesame";
			Connection connection = DriverManager.getConnection(dbURL, username, password);

			System.out.println("connected to MySQL");
			// log("connected to MySQL");	

			Statement statement = connection.createStatement();
			
			sqlStatement = sqlStatement.trim();
			if (sqlStatement.length() >= 6)	{
				String sqlType = sqlStatement.substring(0, 6);
				if (sqlType.equalsIgnoreCase("select")) {
					ResultSet resultSet = statement.executeQuery(sqlStatement);
					sqlResult = SQLUtil.getHtmlTable(resultSet);
					resultSet.close();
				} else {
					int i = statement.executeUpdate(sqlStatement);
					if (i == 0) {
						sqlResult = "<p>The statement executed successfully.</p>";
					} else {
						sqlResult = 
							"<p>The statement executed successfully.<br>" 
							+ i + " row(s) affected.</p>";
					}
				}
			}
			statement.close();	
			connection.close();

		} catch(ClassNotFoundException e) {
			sqlResult = 
				"<p>Error loading the database dirver: <br>"
				+ e.getMessage() + "</p>";

		} catch(SQLException e) {
			sqlResult = 
				"<p>Error executing the SQL statement: <br>"
				+ e.getMessage() + "</p>";
		}

		HttpSession session = request.getSession();
		session.setAttribute("sqlResult", sqlResult);
		session.setAttribute("sqlStatement", sqlStatement);

		String url = "/index.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}
}