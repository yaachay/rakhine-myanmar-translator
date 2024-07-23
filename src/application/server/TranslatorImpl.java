package application.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TranslatorImpl extends UnicastRemoteObject implements TranslatorService {
	private Connection conn;

	protected TranslatorImpl() throws RemoteException {
		try {

			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "root";
			String password = "";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the database.....");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Database connection error.....");
		}
	}

	@Override
	public String translateRK2MY(String text) throws RemoteException {
		
		JSONArray rule = new JSONArray();
		String query = "SELECT * FROM knowledgebase";
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				JSONObject ruleObj = new JSONObject();
				ruleObj.put("from", rs.getString("rakhine"));
				ruleObj.put("to", rs.getString("myanmar"));

				rule.put(ruleObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Error fatching data....");
		}
		return ReplaceText(rule, text);
	}

	@Override
	public String translateMY2RK(String text) throws RemoteException {
		
		JSONArray rule = new JSONArray();
		String query = "SELECT * FROM knowledgebase";
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				JSONObject ruleObj = new JSONObject();
				ruleObj.put("from", rs.getString("myanmar"));
				ruleObj.put("to", rs.getString("rakhine"));

				rule.put(ruleObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Error fatching data....");
		}
		return ReplaceText(rule, text);
	}

	public static String ReplaceText(JSONArray rule, String output) {

		try {
			int max_loop = rule.length();

			for (int i = 0; i < max_loop; i++) {

				JSONObject obj = rule.getJSONObject(i);
				String from = obj.getString("from");
				String to = obj.getString("to");

				output = output.replaceAll(from, to);
				output = output.replace("null", "");

			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return output;
	}

}
