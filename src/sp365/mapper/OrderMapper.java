package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.OrderVO;

public interface OrderMapper {
	public void insert(OrderVO order) throws Exception;

	public int delete(String o_id) throws Exception;

	public int update(OrderVO order) throws Exception;
	
	public int updateorderid(OrderVO order) throws Exception;
	
	public OrderVO select(String o_id) throws Exception;

	public ArrayList<OrderVO> selectmine(String u_id) throws Exception;

	public ArrayList<OrderVO> selectall() throws Exception;
}
