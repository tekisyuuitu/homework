package servlet.apaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ApInfoDto;
import dto.LoginInfoDto;
import service.ApService;
import util.MessageUtil;

/**
 * Servlet implementation class ApServlet
 */
@WebServlet("/ApServlet")
public class ApServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApServlet() {
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
		String url = "AllView.jsp";
		request.setCharacterEncoding("UTF-8");
		MessageUtil messageUtil = new MessageUtil();
		HttpSession session = request.getSession();
		LoginInfoDto loginInfo = (LoginInfoDto)session.getAttribute("LoginInfo");

		ApService ApRS = new ApService();
		List<ApInfoDto> apInfoList = new ArrayList<ApInfoDto>();
		List<String> msgList = new ArrayList<String>();
		ApInfoDto searchApDto = new ApInfoDto();

			// 検索条件を設定

			// 予約情報検索
			apInfoList = ApRS.doSelect(searchApDto);
			if (apInfoList.size() == 1) {
				session = request.getSession(true);
				session.setAttribute("searchAp", apInfoList.get(0));
			} else  {

			// 検索結果ゼロ件
			msgList.add("検索結果が０件です。");
		}


	}


}
