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
//			biz.register(new ProductVO("top_100000", "Å×½ºÆ®", 5000, 10, 5500, 5000, 500, 100, "S,M,L", "y", "n", "1"));
			
			// select one Test
			ProductVO product = null;
			
			product = biz.get("top_100000");
			
			System.out.println(product.toString());
			
			
			// Update Test
			
			product.setP_stock(777);
			int result = biz.modify(product);
			
			System.out.println(result);
			System.out.println(product.toString());
			
			
			// selectall Test
//			list = biz.get();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}
//			
			// selectallnew Test
//			list = biz.getnew();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}
			
			//  selectallbest Test
//			list = biz.getbest();
//			for (ProductVO p : list) {
//				System.out.println(p.toString());
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
