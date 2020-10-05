package murach.sql;

import java.sql.*;

public class SQLUtil {
	public static String getHtmlTable(ResultSet resultSet) throws SQLException {

		StringBuilder htmlTable = new StringBuilder();
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();

		htmlTable.append("<table>");

		//add header row
		htmlTable.append("<tr>");
		//String[] columnNames;
		for (int i=1; i<=columnCount; i++) {
		//	columnNames.add(resultSetMetaData.getColumnName(i));
			htmlTable.append("<th>");
			htmlTable.append(resultSetMetaData.getColumnName(i));
			htmlTable.append("<th>");
		}
		htmlTable.append("</tr>");

		//add other rows
		while(resultSet.next())	{
			htmlTable.append("<tr>");
			for (int i=1; i<=columnCount; i++) {
				htmlTable.append("<td>");
				htmlTable.append(resultSet.getString(i));
				htmlTable.append("<td>");
			}
			htmlTable.append("</tr>");
		}
		htmlTable.append("<table>");
		return htmlTable.toString();
	}
}