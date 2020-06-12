package practice9;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import dao.BoardDao;

/**
 * Servlet implementation class topservlet
 */
@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String mail = request.getParameter("mail");
		BoardBean s;
		if(name == null || message==null || mail==null){
			s = null;
		} else {
			s = new BoardBean(name, message,mail);
		}
		if( s != null ){
			BoardDao.insert(s);
		}
		response.sendRedirect("http://localhost:8080/practice9");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
