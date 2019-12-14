package app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sp365.frame.Biz;
import sp365.vo.ProductVO;

public class ProductTest {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, ProductVO> biz = (Biz) factory.getBean("pbiz");

		ArrayList<ProductVO> list = null;
		try {

			// Insert Test
//			biz.register(
//					new ProductVO("top_001", "thisistop", 10000, 0, 10000, 10000, 0, 1, "M", "y", "n", "5", "top", "img_top_001",null));

			// select one Test
			ProductVO product = null;
			product = biz.get("top_0");
			System.out.println("get: " + product.toString());
//			
//			// Delete Test
//			int res = biz.remove("top_001");
//			System.out.println("delete: " + res);
//
//			// Update Test
//			product.setP_stock(777);
//			System.out.println("updated: " + product.toString());
//			int result = biz.modify(product);
//			System.out.println("modify: " + result);
//
//			// selectall Test
//			list = biz.get();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}
//			
			// get_main_new Test
//			list = biz.get_main_new();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}

			// get_main_best Test
//			list = biz.get_main_best();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
