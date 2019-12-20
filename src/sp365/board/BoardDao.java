package sp365.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.BoardMapper;
import sp365.vo.BoardVO;

@Repository("bdao")
public class BoardDao implements Dao<String, BoardVO> {

	@Autowired
	BoardMapper bm;

	@Override
	public void insert(BoardVO board) throws Exception {
		bm.insert(board);
	}

	@Override
	public int delete(String b_id) throws Exception {
		return bm.delete(b_id);
	}

	@Override
	public int update(BoardVO board) throws Exception {
		return bm.update(board);
	}

	@Override
	public BoardVO select(String b_id) throws Exception {
		return bm.select(b_id);
	}

	@Override
	public ArrayList<BoardVO> selectall() throws Exception {
		return bm.selectall();
	}

	@Override
	public ArrayList<BoardVO> mypageselect(String u_id) throws Exception {
		return bm.mypageselect(u_id);
	}
}
