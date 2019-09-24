package mvc.model;

import java.io.*;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
	private Connection connection = null;
	private String url = System.getenv("jdbc:mysql://172.31.44.51:3306/28a82586fa9c4a19ad1aa28f7fa6gbd2");
	private String user = System.getenv("4216873195694gf8910f56c57gd0d36b");
	private String password = System.getenv("2655a7216992414789f42fcdf2g2b39c");

	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					url, user, password);
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
	public void adiciona(Usuario usuario) throws IOException {

		try {
			String sql = "INSERT INTO usuario1 (login, senha) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT COUNT(*) FROM usuario1 WHERE login=? AND senha=? LIMIT 1");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				if(rs.getInt(1) != 0) {existe=true;}
			}
			rs.close();
			stmt.close();
		} catch(SQLException e) {System.out.println(e);}
		return existe;
	}

}