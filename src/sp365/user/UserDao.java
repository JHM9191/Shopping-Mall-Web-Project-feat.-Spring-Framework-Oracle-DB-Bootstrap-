package sp365.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.UserMapper;
import sp365.vo.UserVO;

@Repository("udao")
public class UserDao implements Dao<String, UserVO> {

	@Autowired
	UserMapper um;

	@Override
	public void insert(UserVO user) throws Exception {
		um.insert(user);
	}

	@Override
	public int update(UserVO user) throws Exception {
		return um.update(user);
	}

	@Override
	public int delete(String u_id) throws Exception {
		return um.delete(u_id);
	}

	@Override
	public UserVO select(String u_id) throws Exception {
		return um.select(u_id);
	}

	@Override
	public ArrayList<UserVO> selectall() throws Exception {
		return um.selectall();
	}


}
