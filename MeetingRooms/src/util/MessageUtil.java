/**
 * メッセージユーティリティクラス。
 */
package util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author yanase
 *
 */
public class MessageUtil {
	private final String MSG_PROPERTIES = "messageInfo";	// メッセージプロパティーファイル名
	/**
	 * コンストラクタ。
	 */
	public MessageUtil () {
	}

	/**
	 * メッセージを取得。
	 * @param keyCode キーコード
	 * @return メッセージ
	 */
	public String getMessage(String keyCode) {
		if (null != keyCode && keyCode.length() > 0) {
			ResourceBundle rb = ResourceBundle.getBundle(MSG_PROPERTIES);
			return rb.getString(keyCode);
		}
		return "";
	}

	/**
	 * パラメータ付きメッセージを取得。
	 * @param keyCode キーコード
	 * @param arguments パラメータ
	 * @return メッセージ
	 */
	public String getMessage(String keyCode, String param) {
		ResourceBundle rb = ResourceBundle.getBundle(MSG_PROPERTIES);
		Object[] arguments = new Object[1];
		arguments[0] = param;
		String format = MessageFormat.format(rb.getString(keyCode), arguments);
		return format;
	}

	/**
	 * パラメータ付きメッセージを取得。
	 * @param keyCode キーコード
	 * @param param1 パラメータ１
	 * @param param2 パラメータ２
	 * @return メッセージ
	 */
	public String getMessage(String keyCode, String param1, String param2) {
		ResourceBundle rb = ResourceBundle.getBundle(MSG_PROPERTIES);
		Object[] arguments = new Object[2];
		arguments[0] = param1;
		arguments[1] = param2;
		String format = MessageFormat.format(rb.getString(keyCode), arguments);
		return format;
	}

	/**
	 * パラメータ付きメッセージを取得。
	 * @param keyCode キーコード
	 * @param param1 パラメータ１
	 * @param param2 パラメータ２
	 * @param param3 パラメータ３
	 * @return メッセージ
	 */
	public String getMessage(String keyCode, String param1, String param2, String param3) {
		ResourceBundle rb = ResourceBundle.getBundle(MSG_PROPERTIES);
		Object[] arguments = new Object[3];
		arguments[0] = param1;
		arguments[1] = param2;
		arguments[2] = param3;
		String format = MessageFormat.format(rb.getString(keyCode), arguments);
		return format;
	}

	/**
	 * パラメータ付きメッセージを取得。
	 * @param keyCode キーコード
	 * @param arguments パラメータ
	 * @return メッセージ
	 */
	public String getMessage(String keyCode, Object[] arguments) {
		ResourceBundle rb = ResourceBundle.getBundle(MSG_PROPERTIES);
		String format = MessageFormat.format(rb.getString(keyCode), arguments);
		return format;
	}

}
