package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.CommonConstant;
import dto.ApInfoDto;
import util.MessageUtil;
import util.StringUtil;

public class ApService extends SuperService{
	/**
	 * コンストラクタ。
	 */
	public ApService () {}
	private StringUtil stringUtil = new StringUtil();
	private MessageUtil messageUtil = new MessageUtil();

	/**
	 * 予約情報検索
	 * @param conditions 検索条件
	 * @param msgList エラーメッセージ
	 * @return 予約情報リスト
	 */
	public List<ApInfoDto> doSelect(ApInfoDto apInfoDto) {
	List<ApInfoDto> listApInfoDto = new ArrayList<ApInfoDto>();
	Connection con = null; // コネクション
	try {
	// １、JDBCドライバー確認
	Class.forName(CommonConstant.JDBC_DRIVER_POSTGRESQL);
	// ２、コネクション取得
	con = getCon();
	StringBuilder sb = new StringBuilder();
	// ３、SQL文生成
	sb.append(" SELECT ");
	sb.append(" ap_time1 AS ApTime1, ");
	sb.append(" ap_time2 AS ApTime2, ");
	sb.append(" ap_time3 AS ApTime3, ");
	sb.append(" ap_time4 AS ApTime4, ");
	sb.append(" ap_time5 AS ApTime5, ");
	sb.append(" ap_time6 AS ApTime6, ");
	sb.append(" emp_id AS EmpID, ");
	sb.append(" update_time AS UpdateTime ");
	sb.append(" FROM ap_info ");
	sb.append(" WHERE 0 = 0 ");
	System.out.println(sb.toString());
	// ４、コネクションにSQLを取り込む
	PreparedStatement pstmt = con.prepareStatement(sb.toString());
//	// ５、SQLを補完（外部データ部）
//	String productId = productDto.getProductId();
//	if (!isStr(productId)) {
//	productId = null;
//	}
//	pstmt.setString(1, productId);
//	Date dateStart = null;
//	if (null != productDto.getStartDay()) {
//	dateStart = new Date(productDto.getStartDay().getTime());
//	}
//	pstmt.setDate(2, dateStart);
//	System.out.println(productDto.toString());
	// ６、SQL実行
	ResultSet rs = pstmt.executeQuery();
	// ７、検索結果を取得

	while (rs.next()) {
		ApInfoDto dto = new ApInfoDto();
		dto.setApTime1(rs.getString("ApTime1"));
		dto.setApTime2(rs.getString("ApTime2"));
		dto.setApTime3(rs.getString("ApTime3"));
		dto.setApTime4(rs.getString("ApTime4"));
		dto.setApTime5(rs.getString("ApTime5"));
		dto.setApTime6(rs.getString("ApTime6"));
		dto.setEmpID(rs.getString("EmpID"));
		Date UpdateTime = rs.getDate("UpdateTime");
		java.util.Date dt = new java.util.Date();
		dt.setTime(UpdateTime.getTime());
		dto.setUpdateTime(dt);
		listApInfoDto.add(dto);
		}
		System.out.println("件数：" + listApInfoDto.size());
		// ８、コネクション等をクローズ
		rs.close();
		pstmt.close();
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		return listApInfoDto;
		}

	public int doUpdate(ApInfoDto apInfoDto) {
	int count = 0;
	Connection con = null;
	try {
	//1、JDBCドライバー確認
	Class.forName(CommonConstant.JDBC_DRIVER_POSTGRESQL);
	//2、コネクション生成
	con = getCon();
	//3、オートコミット解除（Select以外）
	con.setAutoCommit(false);
	//4、SQL生成
	StringBuilder sb = new StringBuilder();
	sb.append(" UPDATE ap_info ");
	sb.append(" SET ap_time1 = COALESCE(?, ap_time1) ");
	sb.append(" , ap_time2 = COALESCE(?, ap_time2) ");
	sb.append(" , ap_time3 = COALESCE(?, ap_time3) ");
	sb.append(" , ap_time4 = COALESCE(?, ap_time4) ");
	sb.append(" , ap_time5 = COALESCE(?, ap_time5) ");
	sb.append(" , ap_time6 = COALESCE(?, ap_time6) ");
	sb.append(" , emp_id = COALESCE(?, emp_id) ");
	sb.append(" , update_time = COALESCE(?, update_time) ");
	sb.append(" WHERE 0 = 0 ");
	System.out.println(sb.toString());
	//5、コネクションにSQLを取り込む
	PreparedStatement pstmt = con.prepareStatement(sb.toString());
	//6、SQLを補完（外部データ部）
	pstmt.setString(1, apInfoDto.getApTime1());
	pstmt.setString(2, apInfoDto.getApTime2());
	pstmt.setString(3, apInfoDto.getApTime3());
	pstmt.setString(4, apInfoDto.getApTime4());
	pstmt.setString(5, apInfoDto.getApTime5());
	pstmt.setString(6, apInfoDto.getApTime6());
	pstmt.setString(7, apInfoDto.getEmpID());
	Date UpdateTime = new Date(apInfoDto.getUpdateTime().getTime());
	pstmt.setDate(8, UpdateTime);
	System.out.println(apInfoDto.toString());
	System.out.println(UpdateTime);
	//7、SQL実行
	count = pstmt.executeUpdate();
	//8、DBコミット
	con.commit();
	//9、コネクションをクローズ
	pstmt.close();
	con.close();
	} catch (SQLException e) {
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
		* nullまたは空文字列の判定。
		* 指定された文字列がnullまたは空文字列かを判定する。
		* @param str 判定する文字列
		* @return 引数で与えられた文字がnullまたは空文字列の場合はfalse、
		* そうでない場合はtrueを返す。
		*/
		private boolean isStr(String str) {
		if (str == null || str.length() == 0) {
		return false;
		}
		return true;
		}
	}






