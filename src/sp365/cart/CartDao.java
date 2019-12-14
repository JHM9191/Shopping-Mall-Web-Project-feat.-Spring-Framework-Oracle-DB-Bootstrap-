package sp365.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.CartMapper;
import sp365.vo.CartVO;

@Repository("cdao")
public class CartDao implements Dao<String, CartVO> {
	
	@Autowired
	CartMapper cm;

	@Override
	public void insert(CartVO cart) throws Exception {
		cm.insert(cart);;
	}

	@Override
	public int update(CartVO product) throws Exception {
		return cm.update(product);
	}

	@Override
	public int delete(String c_id) throws Exception {
		return cm.delete(c_id);
	}

	@Override
	public ArrayList<CartVO> selectmycart(String u_id) throws Exception {
		return cm.selectmycart(u_id);
	}

	@Override
	public ArrayList<CartVO> selectall() throws Exception {
		return cm.selectall();
	}
}
