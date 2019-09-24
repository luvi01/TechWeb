package mvc.controller;

import java.sql.*;
import java.util.*;

public class NotesDAO {
	private Connection connection = null;
	private String url = System.getenv("jdbc:mysql://172.31.44.51:3306/28a82586fa9c4a19ad1aa28f7fa6gbd2");
	private String user = System.getenv("4216873195694gf8910f56c57gd0d36b");
	private String password = System.getenv("2655a7216992414789f42fcdf2g2b39c");
	public NotesDAO() throws SQLException {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
			url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	
	public void adicionaNote(Note note) {
			
			try {
				String sql = "INSERT INTO notes" +
						"(user,text,date,title) values(?,?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1,note.getUser());
				stmt.setString(2,note.getText());
				stmt.setString(3, note.getDate());
				stmt.setString(4, note.getTitle());
				
				//(java.sql.Date) new Date(note.getDate().getTimeInMillis())
				
				//stmt.setBlob(5,note.getImage());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
	
	public void delNote(Integer id) {
		
		PreparedStatement stmt;
		try {
			stmt = connection
					 .prepareStatement("DELETE FROM notes WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
	
	
	
	
	
	
	
	
	
	
	public List<Note> getNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM notes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Note note = new Note();
				
				note.setUser(rs.getString("user"));
				//Calendar date = Calendar.getInstance();
				//date.setTime(rs.getDate("date"));
				note.setDate(rs.getString("date"));
				
				//note.setImage(rs.getBlob("image"));
				note.setId(rs.getInt("id"));
				note.setText(rs.getString("text"));
				note.setTitle(rs.getString("title"));
				
				
				
				notes.add(note);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return notes;
		
	}
	
	public void editNote(Note note) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE notes SET text=? WHERE id=?");
			stmt.setString(1, note.getText());
			stmt.setInt(2, note.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
