package sp365.board;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.BoardVO;

@Service("bbiz")
public class BoardBiz implements Biz<String, BoardVO> {

	@Resource(name = "bdao")
	Dao<String, BoardVO> dao;

	@Transactional
	@Override
	public void register(BoardVO v) throws Exception {
		dao.insert(v);
	}

	@Transactional
	@Override
	public int remove(String k) throws Exception {
		return dao.delete(k);
	}

	@Transactional
	@Override
	public int modify(BoardVO v) throws Exception {
		return dao.update(v);
	}

	@Override
	public BoardVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<BoardVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public ArrayList<BoardVO> mypageget(String u_id) throws Exception {
	
		return dao.mypageselect(u_id);
	}
}
