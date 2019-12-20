package sp365.stat;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.StatVO;

@Service("sbiz")
public class StatBiz implements Biz<String, StatVO> {

	@Resource(name = "sdao")
	Dao<String, StatVO> dao;


	@Override
	public ArrayList<StatVO> getyearly() {
		return dao.selectyearly();
	}

	@Override
	public ArrayList<StatVO> getmonthly() {
		return dao.selectmonthly();
	}

	@Override
	public ArrayList<StatVO> getdaily() {
		return dao.selectdaily();
	}

	@Override
	public ArrayList<StatVO> getyearlyfor(int period) {
		return dao.selectyearlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getmonthlyfor(int period) {
		return dao.selectmonthlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getdailyfor(int period) {
		return dao.selectdailyfor(period);
	}

	// New Arrival
	@Override
	public ArrayList<StatVO> getnewyearly() {
		return dao.selectnewyearly();
	}

	@Override
	public ArrayList<StatVO> getnewmonthly() {
		return dao.selectnewmonthly();
	}

	@Override
	public ArrayList<StatVO> getnewdaily() {
		return dao.selectnewdaily();
	}

	@Override
	public ArrayList<StatVO> getnewyearlyfor(int period) {
		return dao.selectnewyearlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getnewmonthlyfor(int period) {
		return dao.selectnewmonthlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getnewdailyfor(int period) {
		return dao.selectnewdailyfor(period);
	}

	// Best
	@Override
	public ArrayList<StatVO> getbestyearly() {
		return dao.selectbestyearly();
	}

	@Override
	public ArrayList<StatVO> getbestmonthly() {
		return dao.selectbestmonthly();
	}

	@Override
	public ArrayList<StatVO> getbestdaily() {
		return dao.selectbestdaily();
	}

	@Override
	public ArrayList<StatVO> getbestyearlyfor(int period) {
		return dao.selectbestyearlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getbestmonthlyfor(int period) {
		return dao.selectbestmonthlyfor(period);
	}

	@Override
	public ArrayList<StatVO> getbestdailyfor(int period) {
		return dao.selectbestdailyfor(period);
	}
}
