package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.CartVO;

public interface CartMapper {
	public void insert(CartVO cart) throws Exception;

	public int delete(String c_id) throws Exception;

	public int update(CartVO cart) throws Exception;

	public ArrayList<CartVO> selectmycart(String u_id) throws Exception;

	public ArrayList<CartVO> selectall() throws Exception;
}
