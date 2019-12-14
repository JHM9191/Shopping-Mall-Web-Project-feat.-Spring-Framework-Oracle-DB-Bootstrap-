package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.UserVO;

public interface UserMapper {
	public void insert(UserVO user);
	public int delete(String u_id);
	public int update(UserVO user);
	public UserVO select(String u_id);
	public ArrayList<UserVO> selectall();
}



