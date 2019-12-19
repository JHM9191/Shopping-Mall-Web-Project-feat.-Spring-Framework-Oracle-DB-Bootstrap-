package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.CartVO;

public interface CartMapper {
	public void insert(CartVO cart) throws Exception;

	public int delete(String c_id) throws Exception;

	public int update(CartVO cart) throws Exception;
	
	public int updateorderid(CartVO cart) throws Exception;

	public ArrayList<CartVO> selectbyorder(String o_id) throws Exception;

	public ArrayList<CartVO> selectmine(String u_id) throws Exception;

	public ArrayList<CartVO> selectall() throws Exception;
}
