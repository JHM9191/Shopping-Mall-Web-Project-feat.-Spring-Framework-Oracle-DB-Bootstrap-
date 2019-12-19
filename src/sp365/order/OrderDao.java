package sp365.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.OrderMapper;
import sp365.vo.OrderVO;

@Repository("odao")
public class OrderDao implements Dao<String, OrderVO> {

	@Autowired
	OrderMapper om;
	
	@Override
	public void insert(OrderVO order) throws Exception{
		om.insert(order);
	}

	@Override
	public int delete(String o_id) throws Exception{
		return om.delete(o_id);
	}

	@Override
	public int update(OrderVO order) throws Exception{
		return om.update(order);
	}
	
	
	@Override
	public OrderVO select(String o_id) throws Exception{
		return om.select(o_id);
	}

	@Override
	public ArrayList<OrderVO> selectmine(String u_id) throws Exception{
		return om.selectmine(u_id);
	}

	@Override
	public ArrayList<OrderVO> selectall() throws Exception{
		return om.selectall();
	}
}
