package servlet.apaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonConstant;
import dto.ApInfoDto;
import dto.LoginInfoDto;
import service.ApService;
import util.MessageUtil;

/**
 * Servlet implementation class ConfirmApServlet
 */
@WebServlet("/ConfirmApServlet")
public class ConfirmApServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmApServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/ConfirmAp.jsp";
		request.setCharacterEncoding("UTF-8");
		MessageUtil messageUtil = new MessageUtil();
		HttpSession session = request.getSession();
		LoginInfoDto loginInfo = (LoginInfoDto)session.getAttribute(CommonConstant.SESSION_KEY_LOGIN_INFO);// "LoginInfo"


		ApInfoDto searchAp = new ApInfoDto();
		ApService apService = new ApService();
		List<ApInfoDto> listAp = apService.doSelect(searchAp);
		ApInfoDto ApInfo = listAp.get(0);

		session = request.getSession(true);
		session.setAttribute("AP_INFO", listAp.get(0));

		String checkedTime = request.getParameter("time");
		String updateConfirm = request.getParameter("confirmAp");
		List<String> msgList = new ArrayList<String>();
		List<String> checkList = new ArrayList<String>();

			checkList.add(ApInfo.getApTime1());
			checkList.add(ApInfo.getApTime2());
			checkList.add(ApInfo.getApTime3());
			checkList.add(ApInfo.getApTime4());
			checkList.add(ApInfo.getApTime5());
			checkList.add(ApInfo.getApTime6());

		if (checkList.get(Integer.valueOf(checkedTime)) == null) {
			ApInfoDto updateDto = new ApInfoDto();
			ApService updateAp = new ApService();
			checkList.set(Integer.valueOf(checkedTime), loginInfo.getDepartment());
			updateDto.setApTime1(checkList.get(0));
			updateDto.setApTime2(checkList.get(1));
			updateDto.setApTime3(checkList.get(2));
			updateDto.setApTime4(checkList.get(3));
			updateDto.setApTime5(checkList.get(4));
			updateDto.setApTime6(checkList.get(5));
			updateDto.setEmpID(loginInfo.getEmpID());
			Date dt = new Date();
			updateDto.setUpdateTime(dt);
			updateAp.doUpdate(updateDto);
			url = "./AllView.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(url);
			dispatch.forward(request, response);
			} else {
				msgList.add("空いている時間帯を選んでください。");
				RequestDispatcher dispatch = request.getRequestDispatcher(url);
				dispatch.forward(request, response);
			}



	}

}
