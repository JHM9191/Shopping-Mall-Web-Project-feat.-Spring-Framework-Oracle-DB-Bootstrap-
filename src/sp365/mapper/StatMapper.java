package sp365.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import sp365.vo.StatVO;

public interface StatMapper {
	public ArrayList<StatVO> selectbypayment();

	public ArrayList<StatVO> selectpayment();

	
	// All Products
	public ArrayList<StatVO> selectyearly();

	public ArrayList<StatVO> selectmonthly();

	public ArrayList<StatVO> selectdaily();

	public ArrayList<StatVO> selectyearlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectmonthlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectdailyfor(@Param("period") int period);
	
	
	// New Arrivals
	public ArrayList<StatVO> selectnewyearly();

	public ArrayList<StatVO> selectnewmonthly();

	public ArrayList<StatVO> selectnewdaily();

	public ArrayList<StatVO> selectnewyearlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectnewmonthlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectnewdailyfor(@Param("period") int period);
	
	
	
	// Best Products
	public ArrayList<StatVO> selectbestyearly();

	public ArrayList<StatVO> selectbestmonthly();

	public ArrayList<StatVO> selectbestdaily();

	public ArrayList<StatVO> selectbestyearlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectbestmonthlyfor(@Param("period") int period);

	public ArrayList<StatVO> selectbestdailyfor(@Param("period") int period);
}
