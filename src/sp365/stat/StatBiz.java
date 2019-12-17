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
	public ArrayList<StatVO> getbypayment() {
		return dao.selectbypayment();
	}

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

}
