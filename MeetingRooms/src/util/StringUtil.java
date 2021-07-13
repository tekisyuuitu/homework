/**
 *
 */
package util;

/**
 * @author yanas
 *
 */
public class StringUtil {
	/**
	 * 空文字列の判定。
	 * 指定された文字列が空文字列かを判定する。
	 * @param str 判定する文字列
	 * @return 引数で与えられた文字が空文字列の場合はfalse、
	 * 			そうでない場合はtrueを返す。
	 */
	public boolean isStr (String str) {
		if (str != null && str.length() == 0) {
			return false;
		}
		return true;
	}
	/**
	 * ゼロパディングを行う。
	 * 引数から取得した文字列の先頭ゼロ埋めを行う。
	 * @param variousCode ゼロ埋め対象コード
	 * @param variousCodeDigits コード桁数
	 * @return 先頭ゼロ埋めされた文字列
	 */
	public String getZeroPadding(String variousCode, int variousCodeDigits) {
		String retVal = variousCode;
		String zeroValue = "";
		String ZERO = "0";
		if (variousCode == null || variousCode.equals("")) {
			retVal = "";
		}
		if (variousCodeDigits == 0) {
			return null;
		}
		int variousCodeLength = variousCode.length();
		if (variousCodeDigits < variousCodeLength) {
			return retVal;
		} else if (variousCodeDigits > variousCodeLength) {
			int zeropadCount = variousCodeDigits - variousCodeLength;
			for (int i = 0; i < zeropadCount; i++) {
				zeroValue = zeroValue + ZERO;
			}
		}
		retVal = zeroValue + retVal;
		return retVal;
	}

}
