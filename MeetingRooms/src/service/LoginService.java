package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.CommonConstant;
import dto.LoginInfoDto;
import util.MessageUtil;
import util.StringUtil;

public class LoginService extends SuperService{
	/**
	 * コンストラクタ。
	 */
	public LoginService() {}
    private StringUtil stringUtil = new StringUtil();
	private MessageUtil messageUtil = new MessageUtil();

	/**
	 * Entryデータ登録。
	 * @param insertDto 登録データ
	 * @param msgList メッセージリスト
	 * @return 登録件数
	 */
	public int doInsertLogin(LoginInfoDto insertDto) {
		int count = 0;
		Connection con = null;
		try {
			// １、JDBCドライバー確認
			Class.forName(CommonConstant.JDBC_DRIVER_POSTGRESQL);
			// ２、コネクション生成
			con = getCon();
			// ３、オートコミット解除
			con.setAutoCommit(false);
			// ４、SQL生成
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO login_info ( ");
			sb.append("emp_id,department,name,mailadress,password) ");
			sb.append(" VALUES (?, ?, ?, ?, ?) ");
			System.out.println(sb.toString());
			// ５、コネクションにSQLを取り込む
			PreparedStatement pstmt = con.prepareStatement(sb.toString());
			// ６、SQLを補完（外部データ部）
			pstmt.setString(1, insertDto.getEmpID());
			pstmt.setString(2, insertDto.getDepartment());
			pstmt.setString(3, insertDto.getName());
			pstmt.setString(4, insertDto.getMailAdress());
			pstmt.setString(5, insertDto.getPassWord());
			System.out.println(insertDto.toString());
			// ７、SQL実行
			count = pstmt.executeUpdate();
			// ８、DBコミット
			con.commit();
			// ９、コネクション等をクローズ
			pstmt.close();
			con.close();}
		catch (SQLException e) {
				e.printStackTrace();
				try {
				// DBロールバック
				con.rollback();
				// DBコネクションをクローズ
				con.close();
				} catch (SQLException e1) {
				// SQLエラーメッセージ出力
				e1.printStackTrace();
				}
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
				return count;
				}

	/**
	 * Entryデータ更新。
	 * @param updateDto 更新データ
	 * @param msgList メッセージリスト
	 * @return 更新件数
	 */
	public int doUpdateLogin(LoginInfoDto updateDto, List<String> msgList) {

		int count = 0;
		Connection con = null;
		try {
			// １、JDBCドライバー確認
			Class.forName(CommonConstant.JDBC_DRIVER_POSTGRESQL);
			// ２、コネクション生成
			con = getCon();
			// ３、オートコミット解除
			con.setAutoCommit(false);
			// ４、SQL生成
			StringBuilder sb = new StringBuilder();
			sb.append(" UPDATE login_info");
			sb.append(" SET ");
			sb.append(" mailadress = ? ");
			sb.append(" , password = ? ");
			System.out.println(sb.toString());
			// ５、コネクションにSQLを取り込む
			PreparedStatement pstmt = con.prepareStatement(sb.toString());
			// ６、SQLを補完（外部データ部）
			pstmt.setString(1, updateDto.getMailAdress());
			pstmt.setString(2, updateDto.getPassWord());
			System.out.println(updateDto.toString());
			// ７、SQL実行
			count = pstmt.executeUpdate();
			// ８、DBコミット
			con.commit();
			// ９、コネクション等をクローズ
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_DB_SQL_ERROR));
			e.printStackTrace();
			try {
				// １、ロールバック
				con.rollback();
				// ２、コネクションをクローズ
				con.close();
			} catch (SQLException e1) {
				msgList.add(messageUtil.getMessage(CommonConstant.MSG_DB_SQL_ERROR));
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_DB_DRIVER_ERROR));
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * Entryデータ検索。
	 * @param conditions 検索条件
	 * @param msgList エラーメッセージ
	 * @return 検索結果
	 */
	public List<LoginInfoDto> doSelectLogin(LoginInfoDto conditions, List<String> msgList) {
		List<LoginInfoDto> listDto = new ArrayList<LoginInfoDto>();
		Connection con = null;
		try {
			// １、JDBCドライバー確認
			Class.forName(CommonConstant.JDBC_DRIVER_POSTGRESQL);
			// ２、コネクション生成
			con = getCon();
			StringBuilder sb = new StringBuilder();
			// ３、SQL生成
			sb.append(" SELECT ");
			sb.append(" emp_id AS EmpID, ");
			sb.append(" department AS Department, ");
			sb.append(" name AS Name, ");
			sb.append(" mailadress AS MailAdress, ");
			sb.append(" password AS PassWord ");
			sb.append(" FROM login_info ");
			sb.append(" WHERE 0 = 0");
			sb.append(" AND emp_id = COALESCE(?, emp_id) ");
			sb.append(" AND department = COALESCE(?, department) ");
			sb.append(" AND name = COALESCE(?, name) ");
			sb.append(" AND mailadress = COALESCE(?, mailadress) ");
			sb.append(" AND password = COALESCE(?, password) ");
			System.out.println(sb.toString());
			// ４、コネクションにSQLを取り込む
			PreparedStatement pstmt = con.prepareStatement(sb.toString());
			String EmpID = conditions.getEmpID();
			String Department = conditions.getDepartment();
			String Name = conditions.getName();
			String MailAdress = conditions.getMailAdress();
			String PassWord = conditions.getPassWord();
			if (!stringUtil.isStr(EmpID)) {
				EmpID = null;
			}
			if (!stringUtil.isStr(Department)) {
				Department = null;
			}
			if (!stringUtil.isStr(Name)) {
				Name = null;
			}
			if (!stringUtil.isStr(MailAdress)) {
				MailAdress = null;
			}
			if (!stringUtil.isStr(PassWord)) {
				PassWord = null;
			}
			// ５、SQLを補完（外部データ部）
			pstmt.setString(1, EmpID);
			pstmt.setString(2, Department);
			pstmt.setString(3, Name);
			pstmt.setString(4, MailAdress);
			pstmt.setString(5, PassWord);
			System.out.println(conditions.toString());
			// ６、SQL実行
			ResultSet rs = pstmt.executeQuery();
			// ７、検索結果を取得
			while (rs.next()) {
				LoginInfoDto dto = new LoginInfoDto();
				dto.setEmpID(rs.getString("EmpID"));
				dto.setDepartment(rs.getString("Department"));
				dto.setName(rs.getString("Name"));
				dto.setMailAdress(rs.getString("MailAdress"));
				dto.setPassWord(rs.getString("PassWord"));
				listDto.add(dto);
			}
			System.out.println("件数：" + listDto.size());
			// ８、コネクション等をクローズ
			rs.close();
			con.close();
		} catch (SQLException e) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_DB_SQL_ERROR));
			msgList.add("SQLエラー");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			msgList.add(messageUtil.getMessage(CommonConstant.MSG_DB_DRIVER_ERROR));
			msgList.add("JDBCドライバーエラー");
			e.printStackTrace();
		}
		return listDto;
	}


}
