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

	
	// All products
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
	
	@Override
	public ArrayList<StatVO> selectyearlyfor(int period) {
		return sm.selectyearlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectmonthlyfor(int period) {
		return sm.selectmonthlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectdailyfor(int period) {
		return sm.selectdailyfor(period);
	}
	
	// New Arrivals
	@Override
	public ArrayList<StatVO> selectnewyearly() {
		return sm.selectnewyearly();
	}

	@Override
	public ArrayList<StatVO> selectnewmonthly() {
		return sm.selectnewmonthly();
	}

	@Override
	public ArrayList<StatVO> selectnewdaily() {
		return sm.selectnewdaily();
	}
	
	@Override
	public ArrayList<StatVO> selectnewyearlyfor(int period) {
		return sm.selectnewyearlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectnewmonthlyfor(int period) {
		return sm.selectnewmonthlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectnewdailyfor(int period) {
		return sm.selectnewdailyfor(period);
	}
	
	// Best
	@Override
	public ArrayList<StatVO> selectbestyearly() {
		return sm.selectbestyearly();
	}

	@Override
	public ArrayList<StatVO> selectbestmonthly() {
		return sm.selectbestmonthly();
	}

	@Override
	public ArrayList<StatVO> selectbestdaily() {
		return sm.selectbestdaily();
	}
	
	@Override
	public ArrayList<StatVO> selectbestyearlyfor(int period) {
		return sm.selectbestyearlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectbestmonthlyfor(int period) {
		return sm.selectbestmonthlyfor(period);
	}
	
	@Override
	public ArrayList<StatVO> selectbestdailyfor(int period) {
		return sm.selectbestdailyfor(period);
	}
}
