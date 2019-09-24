package mvc.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TarefasController {
	
	@RequestMapping("NotePage")
	public String NotePage() {
		return "notes";
	}
	
	
	@RequestMapping("AddNote")
	 public String AddNote(Note note, ModelMap model) throws SQLException {
		NotesDAO dao = new NotesDAO();
		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date = formatter.format(calendar.getTime());
		
		
		
		note.setDate(date);
		
		
		String userSession = note.getUserSession();
		
		
		
		model.addAttribute("user", userSession);
		
		
		
		
		
		dao.adicionaNote(note);
		
	 return "redirect:NotePage";
	 }
	
	
	
	
	
	@RequestMapping(value = "RemoveNote", method = RequestMethod.POST)
	 public String RemoveNote(Note note, ModelMap model) throws SQLException {
		NotesDAO dao = new NotesDAO();
		
		
		String userTask = note.getUser();
		
		String userSession = note.getUserSession();
		
		Integer id = note.getId();
		
		
		
		
		
		
		
		
		//if (userSession.contentEquals(userTask)) {
			
			//System.out.println("entrou no if");
			
		dao.delNote(Integer.valueOf(id));
			
		//}
		
		
		
	
		model.addAttribute("user", userSession);
		
		
		
	 return "redirect:NotePage";
	 }
	
	
	
	
	@RequestMapping("EditNote")
	 public String EditNote(Note note, ModelMap model) throws SQLException {
		NotesDAO dao = new NotesDAO();
		
		
		
		
		
		String userSession = note.getUserSession();
		
		
		
		model.addAttribute("user", userSession);
		
		
		
		dao.editNote(note);
		
	 return "notes";
	 }
	
	
	
	

	
	
	
	
	
	
	
}
