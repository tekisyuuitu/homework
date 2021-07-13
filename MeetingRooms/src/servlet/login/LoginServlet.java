package servlet.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonConstant;
import dto.LoginInfoDto;
import service.LoginService;
import util.MessageUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "ログイン", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String url = "/Login.jsp";
		request.setCharacterEncoding("UTF-8");
		MessageUtil messageUtil = new MessageUtil();
		List<String> msgList = new ArrayList<String>();
		List<LoginInfoDto> listLogin = new ArrayList<LoginInfoDto>();
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		// フロント側データ取得
		String EmpID = request.getParameter("EmpID");
		String PassWord = request.getParameter("PassWord");
		// 入力チェック
		if (EmpID.isBlank() | EmpID.length() != 6) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_INFO_0001, "雇員ID"));
		}
		if (PassWord.isBlank()) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_INFO_0001, "ログインパスワード"));
		}

		if (msgList.size() == 0) {
			// ログイン有効性チェック
						LoginService service = new LoginService();
						loginInfoDto.setEmpID(EmpID);
						listLogin = service.doSelectLogin(loginInfoDto, msgList);
						if (listLogin.size() > 0) {
							if (listLogin.size() == 1) {
								if (!listLogin.get(0).getPassWord().equals(PassWord)) {
									msgList.add(messageUtil.getMessage(CommonConstant.MSG_INFO_0003, "パスワード"));
								} else {
									url = "/TopPage.jsp";
								}
							} else {
								msgList.add(messageUtil.getMessage(CommonConstant.MSG_ERROR_0002));
							}
						}
						if (msgList.size() > 0) {
							url = "/Login.jsp";
						}else {
							// ログイン情報をセッションに登録
							HttpSession session = request.getSession(true);
							session.setAttribute(CommonConstant.SESSION_KEY_LOGIN_INFO, listLogin.get(0));
							session.setMaxInactiveInterval(60000);
						}
						// フロント側に渡すデータを設定
						request.setAttribute(CommonConstant.ATTRIBUTE_MSGLIST, msgList);
						request.setAttribute("EmpID", EmpID);
						request.setAttribute("PassWord", PassWord);
						// 画面遷移
						RequestDispatcher dispatch = request.getRequestDispatcher(url);
						dispatch.forward(request, response);
		}
	}

}
