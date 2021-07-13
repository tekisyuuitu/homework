/**
 * 共通定数クラス。
 */
package common;

/**
 * 共通定数クラス。
 * @author yanase
 *
 */
public final class CommonConstant {
	/** JDBCドライバー */
	public static final String JDBC_DRIVER_POSTGRESQL = "com.mysql.cj.jdbc.Driver";// MYSQL:"com.mysql.cj.jdbc.Driver";
	/** プロジェクト名 */
	public static final String PROJECT_NAME = "/MeetingRooms";

	/** イベント情報：検索 */
	public static final String EVENT_SEARCH = "search";
	/** イベント情報：新規登録 */
	public static final String EVENT_ADD = "add";
	/** イベント情報：編集 */
	public static final String EVENT_UPDATE = "update";
	/** イベント情報：確認 */
	public static final String EVENT_CHECK = "check";
	/** イベント情報：登録 */
	public static final String EVENT_REGISTER = "register";

	/** セッション情報：ログインデータ */
	public static final String SESSION_KEY_LOGIN_INFO = "LoginInfo";
	/** セッション情報：一覧検索条件データ */
	public static final String SESSION_KEY_SEARCH_DTO = "searchDto";
	/** セッション情報：会員情報データ */
	public static final String SESSION_KEY_ENTRY_USER = "EntryUser";
	/** セッション情報：会社マスタ登録データ */
	public static final String SESSION_KEY_COMPANY_MASTER = "CompanyMaster";
	/** セッション情報：部マスタ登録データ */
	public static final String SESSION_KEY_DEPARTMENT_MASTER = "DepartmentMaster";
	/** セッション情報：クライアントユーザ情報登録データ */
	public static final String SESSION_KEY_EMPLOYEE_INFO = "EmployeeInfo";

	/** ページ属性：メッセージリスト */
	public static final String ATTRIBUTE_MSGLIST = "msgList";
	/** ページ属性：入力データ */
	public static final String ATTRIBUTE_INPUT_DATE = "inputDto";
	/** ページ属性：検索条件データ */
	public static final String ATTRIBUTE_KEY_SEARCH = "searchDto";
	/** ページ属性：検索データ */
	public static final String ATTRIBUTE_LIST = "searchList";
	/** ページ属性：都道府県リスト */
	public static final String ATTRIBUTE_PREFECTURE_LIST = "prefectureList";
	/** ページ属性：学歴リスト */
	public static final String ATTRIBUTE_EDUCATIONAL_LIST = "educationalBackgroundList";
	/** ページ属性：会社リスト */
	public static final String ATTRIBUTE_COMPANY_LIST = "companyList";
	/** ページ属性：株式市場区分リスト */
	public static final String ATTRIBUTE_STOCK_DIVISION_LIST = "listStockDivision";
	/** ページ属性：部マスタ階層リスト */
	public static final String ATTRIBUTE_HIERARCHY_LIST = "listHierarchy";
	/** ページ属性：部マスタ階層リスト */
	public static final String ATTRIBUTE_DIRECT_TOP_LIST = "listDirectTopDepartmentCd";
	/** ページ属性：部マスタ階層（onchange用）リスト */
	public static final String ATTRIBUTE_DIRECT_TOP_CHANGE_LIST = "listDirectTopForChange";

	/** カテゴリー区分：都道府県 */
	public static final String CATEGORY_PREFECTURE = "000001";
	/** カテゴリー区分：有効フラグ */
	public static final String CATEGORY_ACTIVE  = "000002";
	/** カテゴリー区分：株式市場区分 */
	public static final String CATEGORY_STOCK_MARKET  = "000003";
	/** カテゴリー区分：学歴 */
	public static final String CATEGORY_EDUCATIONAL_BACKGROUND  = "000004";
	/** カテゴリー区分：性別 */
	public static final String CATEGORY_SEX  = "000005";

	/** メッセージプロパティーファイル（日本語） */
	public static final String PROPERTIES_MESSAGE_JAPAN = "messageInfo";

	/** メッセージ */
	public static final String FREE_MSG = "msg";
	/** データベース接続エラー */
	public static final String MSG_DB_ACESS_ERROR = "msg.db.access.error";
	/** データベースドライバー取得エラー */
	public static final String MSG_DB_DRIVER_ERROR = "msg.db.driver.error";
	/** データベースSQLエラー */
	public static final String MSG_DB_SQL_ERROR = "msg.db.sql.error";
	/** データベース：対象データ（{0}）が取得できません。 */
	public static final String MSG_DB_DATE_NOT_FOUND = "msg.sql.date.not.found";
	/** データベース：対象データ（{0}）が登録できません。 */
	public static final String MSG_DB_DATE_NOT_REGISTER = "msg.sql.date.not.register";
	/** データベース：対象データ（{0}）が更新できません。 */
	public static final String MSG_DB_DATE_NOT_UPDATE = "msg.sql.date.not.update";
	/** メッセージ：セッションタイムアウトのため、ログインし直してください。 */
	public static final String SESSION_TIMEOUT = "msg.session.timeout";

	/** メッセージ（汎用メッセージ：画面出力は使用しない）：{0} */
	public static final String MSG_INFO_0000 = "msg";
	/** メッセージ：{0}を入力してください */
	public static final String MSG_INFO_0001 = "msg.required.input";
	/** メッセージ：{0}を選択してください */
	public static final String MSG_INFO_0002 = "msg.required.select";
	/** メッセージ：正しい{0}を入力してください */
	public static final String MSG_INFO_0003 = "msg.correct.input";
	/** メッセージ：{0}は半角数字を入力してください */
	public static final String MSG_INFO_0004 = "msg.enter.numbers";
	/** メッセージ：{0}がありません */
	public static final String MSG_INFO_0005 = "msg.not.date";
	/** メッセージ：{0}は{1}桁を入力ください */
	public static final String MSG_INFO_0006 = "msg.input.digit";

	/** メッセージ：不正アクセスの為、管理者に問い合わせ下さい。 */
	public static final String MSG_ERROR_0001 = "msg.illegality.access";
	/** メッセージ：ログイン不正があるのでシステム管理者に連絡ください。 */
	public static final String MSG_ERROR_0002 = "msg.illegality.login";

	/** メッセージ：対象ファイル（{0}）の削除が失敗しました。 */
	public static final String MSG_FILE_0001 = "msg.file.delete.failure";
	/** メッセージ：対象ファイル（{0}）がありません。 */
	public static final String MSG_FILE_0002 = "msg.file.not.found";
	/** メッセージ：対象ファイル（{0}）のエンコード（{1}）が認識しません。 */
	public static final String MSG_FILE_0003 = "msg.file.Unsupported.Encoding";
	/** メッセージ：対象ファイル（{0}）の読み込みが失敗しました。 */
	public static final String MSG_FILE_0004 = "msg.file.read.failure";
	/** メッセージ：対象ファイル（{0}）書き込みが失敗しました。 */
	public static final String MSG_FILE_0005 = "msg.file.write.failure";
	/** メッセージ：対象ファイル（{0}）の移動が失敗しました。 */
	public static final String MSG_FILE_0006 = "msg.file.rmove.failure";
	/** メッセージ：対象ファイル（コピー元：{0}）（コピー先：{1}）のコピーが失敗しました。 */
	public static final String MSG_FILE_0007 = "msg.file.rmove.failure";
	/** メッセージ：対象フォルダ（{0}）配下の削除が失敗しました。 */
	public static final String MSG_FOLDER_0001 = "msg.file.copy.failure";
}
