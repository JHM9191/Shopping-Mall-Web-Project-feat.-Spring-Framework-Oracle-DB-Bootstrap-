package sp365.stat;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.StatMapper;
import sp365.vo.StatVO;

@Repository("sdao")
public class StatDao implements Dao<String, StatVO> {

	@Autowired
	StatMapper sm;

	@Override
	public ArrayList<StatVO> selectbypayment() {
		return sm.selectbypayment();
	}
	
	@Override
	public ArrayList<StatVO> selectpayment() {
		return sm.selectpayment();
	}

	@Override
	public ArrayList<StatVO> selectyearly() {
		return sm.selectyearly();
	}

	@Override
	public ArrayList<StatVO> selectmonthly() {
		return sm.selectmonthly();
	}

	@Override
	public ArrayList<StatVO> selectdaily() {
		return sm.selectdaily();
	}
}
