package br.com.recode.ag.connfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	private static String user = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/agviagem";
	
	
	public static Connection createConnectionToMySQL(){
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = createConnectionToMySQL();
		
		if(conn != null) {
			System.out.println("Banco de dados conectado com sucesso. "+ conn);
			conn.close();
		}else {
			System.out.println("O banco de dados n�o foi conectado.");
		}
	}
}
