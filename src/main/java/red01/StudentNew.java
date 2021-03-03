package red01;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/student/new")
public class StudentNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(StudentNew.class);

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.trace("enter");
			String name = request.getParameter("first_name");
			String surname = request.getParameter("last_name");
			String number = request.getParameter("number");
			String email= request.getParameter("mail");
			String password= request.getParameter("pw");
			
			String param = request.getParameter("id");
	        long id = Long.parseLong(param);
			
			Student student = new Student(id, name, surname, number, email, password);
			
			if (new StudentDao().create(student)) {
	            log.debug("Student persisted with id " + student.getId());
	            request.setAttribute("student", student);
	        } else {
	            log.info("Can't create " + student);
	        }

	        request.getRequestDispatcher("/newstpickRoom.jsp").forward(request, response);
	    }			

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}