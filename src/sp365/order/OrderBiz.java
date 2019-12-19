package sp365.order;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.OrderVO;

@Service("obiz")
public class OrderBiz implements Biz<String, OrderVO> {
	@Resource(name = "odao")
	Dao<String, OrderVO> dao;
	
	@Transactional
	@Override
	public void register(OrderVO order) throws Exception {
		dao.insert(order);
	}

	@Transactional
	@Override
	public int modify(OrderVO order) throws Exception {
		return dao.update(order);
	}

	@Transactional
	@Override
	public int remove(String o_id) throws Exception {
		return dao.delete(o_id);
	}

	@Override
	public OrderVO get(String o_id) throws Exception {
		return dao.select(o_id);
	}
	
	@Override
	public ArrayList<OrderVO> getmyorder(String u_id) throws Exception {
		return dao.selectmine(u_id);
	}

	@Override
	public ArrayList<OrderVO> get() throws Exception {
		return dao.selectall();
	}
	
}
