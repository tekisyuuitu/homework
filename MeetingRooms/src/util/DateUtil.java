/**
 *
 */
package util;

import java.sql.Date;
import java.util.Calendar;

/**
 * @author yanas
 *
 */
public class DateUtil {
	/**
	 * 引数の日付がNULLの場合、9999/12/31に変換する。
	 * @param dt 変換元日付
	 * @return 変換された日付
	 */
	public Date getMaxDate(java.util.Date dt) {
		if (dt == null) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 9999);
			cal.set(Calendar.MONTH, 11);
			cal.set(Calendar.DAY_OF_MONTH, 31);
			dt = cal.getTime();
		}
		Date date = new Date(dt.getTime());
		return date;
	}

}
