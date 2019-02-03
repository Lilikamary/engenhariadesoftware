package br.ufpe.cin.vimperial.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JPAUtil {
	
	//jdbc:mysql://localhost:3306/fiemt
	private String url = "jdbc:postgresql://localhost:5432/videolocadoraeng";
	private String usuario = "postgres";
	private String senha = "diario26";

	// A partir do java 7, nao precisa carregar o driver
	// mas o TOMCAT pede para qe você o faça
	static {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection obterConexao() throws SQLException{
		Connection con = DriverManager.getConnection(url,usuario,senha);
		return con;
	}
}
