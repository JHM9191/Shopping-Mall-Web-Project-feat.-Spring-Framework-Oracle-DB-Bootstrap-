package sp365.cart;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.CartVO;

@Service("cbiz")
public class CartBiz implements Biz<String, CartVO> {
	
	@Resource(name = "cdao")
	Dao<String, CartVO> dao;
	
	@Transactional
	@Override
	public void register(CartVO cart) throws Exception {
		dao.insert(cart);
	}

	@Transactional
	@Override
	public int modify(CartVO cart) throws Exception {
		return dao.update(cart);
	}
	
	@Transactional
	@Override
	public int setorderid(CartVO cart) throws Exception {
		return dao.updateorderid(cart);
	}

	@Transactional
	@Override
	public int remove(String c_id) throws Exception {
		return dao.delete(c_id);
	}
	
	@Override
	public ArrayList<CartVO> getbyorder(String o_id) throws Exception {
		return dao.selectbyorder(o_id);
	}

	@Override
	public ArrayList<CartVO> getmycart(String u_id) throws Exception {
		return dao.selectmine(u_id);
	}

	@Override
	public ArrayList<CartVO> get() throws Exception {
		return dao.selectall();
	}

}
