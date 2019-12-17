package sp365.mapper;

import java.util.ArrayList;

import sp365.vo.StatVO;

public interface StatMapper {
	public ArrayList<StatVO> selectbypayment();

	public ArrayList<StatVO> selectyearly();

	public ArrayList<StatVO> selectmonthly();

	public ArrayList<StatVO> selectdaily();
}
