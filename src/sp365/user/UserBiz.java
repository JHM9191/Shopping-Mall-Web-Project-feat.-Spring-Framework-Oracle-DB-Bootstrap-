package sp365.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.UserVO;

@Service("ubiz")
public class UserBiz implements Biz<String, UserVO> {

	@Resource(name = "udao")
	Dao<String, UserVO> dao;

	@Transactional
	@Override
	public void register(UserVO user) throws Exception {
		dao.insert(user);
	}

	@Transactional
	@Override
	public int modify(UserVO user) throws Exception {
		return dao.update(user);
	}

	@Transactional
	@Override
	public int remove(String u_id) throws Exception {
		return dao.delete(u_id);
	}

	@Override
	public UserVO get(String u_id) throws Exception {
		return dao.select(u_id);
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		return dao.selectall();
	}

}