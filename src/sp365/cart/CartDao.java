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
	public int update(CartVO cart) throws Exception {
		return cm.update(cart);
	}
	
	@Override
	public int updateorderid(CartVO cart) throws Exception {
		return cm.updateorderid(cart);
	}

	@Override
	public int delete(String c_id) throws Exception {
		return cm.delete(c_id);
	}

	@Override
	public ArrayList<CartVO> selectbyorder(String o_id) throws Exception {
		return cm.selectbyorder(o_id);
	}
	
	@Override
	public ArrayList<CartVO> selectmine(String u_id) throws Exception {
		return cm.selectmine(u_id);
	}

	@Override
	public ArrayList<CartVO> selectall() throws Exception {
		return cm.selectall();
	}
}
