package servlet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.LoginInfoDto;
import service.LoginService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "SignUp.jsp";
		request.setCharacterEncoding("UTF-8");
		LoginInfoDto loginInfoList = new LoginInfoDto();
		String empID = request.getParameter("registerId");
		String name = request.getParameter("fullname");
		String department = request.getParameter("department");
		String mailAdress = request.getParameter("email");
		String passWord = request.getParameter("PassWord");
		if (empID != "" && name !="" && department !="" && passWord !="") {
		loginInfoList.setEmpID(empID);
		loginInfoList.setName(name);
		loginInfoList.setDepartment(department);
		loginInfoList.setMailAdress(mailAdress);
		loginInfoList.setPassWord(passWord);
		LoginService signUp = new LoginService();
		signUp.doInsertLogin(loginInfoList);
		url = "Intro.jsp";}
		else {url = "SignUp.jsp";}
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);

	}

}
