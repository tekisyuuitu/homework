/**
 *
 */
package servlet.login;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dto.ApInfoDto;
import service.ApService;

/**
 * @author lynch
 *
 */
public class Testclass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		doUpdate();
		doSelect();

	}

	private static void doUpdate() {

		ApInfoDto apInfoDto = new ApInfoDto();
		apInfoDto.setApTime2("開発部");
//		apInfoDto.setProductName("日立冷蔵庫");
//		apInfoDto.setInPrice(2000);
//		apInfoDto.setOutPrice(3500);
		apInfoDto.setEmpID("000004");
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		Date date = cal.getTime();
		apInfoDto.setUpdateTime(date);

		ApService productService = new ApService();
		int updateCount = productService.doUpdate(apInfoDto);
		System.out.println("更新件数：" + updateCount);

	}

	private static void doSelect() {

		ApInfoDto productDto = new ApInfoDto();
		ApService productService = new ApService();
		List<ApInfoDto> listProduct = productService.doSelect(productDto);
		for (ApInfoDto dto : listProduct) {
			System.out.println("---------------------------");
			System.out.println("商品ID：" + dto.getApTime1());
			System.out.println("商品名：" + dto.getApTime2());
			System.out.println("仕入れ値：" + dto.getApTime3());
			System.out.println("売値：" + dto.getEmpID());
			System.out.println("開始基準日：" + dto.getUpdateTime());
			System.out.println("---------------------------");
		}
	}
}
