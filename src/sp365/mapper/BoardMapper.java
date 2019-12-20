package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.BoardVO;

public interface BoardMapper {
	public void insert(BoardVO board) throws Exception;

	public int delete(String b_id) throws Exception;

	public int update(BoardVO board) throws Exception;

	public BoardVO select(String b_id) throws Exception;

	public ArrayList<BoardVO> selectall() throws Exception;
	
	public ArrayList<BoardVO> mypageselect(String u_id)throws Exception;
}
