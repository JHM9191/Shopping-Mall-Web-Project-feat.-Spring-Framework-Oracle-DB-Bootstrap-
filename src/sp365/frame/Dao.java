package sp365.frame;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import sp365.vo.CartVO;
import sp365.vo.ProductVO;
import sp365.vo.StatVO;

public interface Dao<K, V> {
	default public void insert(V v) throws Exception {
	}

	default public int delete(K k) throws Exception {
		return 0;
	}

	default public int update(V v) throws Exception {
		return 0;
	}

	default public V select(K k) throws Exception {
		return null;
	}

	default public ArrayList<V> selectall() throws Exception {
		return null;
	};

//// Product
	// All
	default public ArrayList<V> select_all(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_all() throws Exception {
		return 0;
	};

	// All > Category
	default public ArrayList<V> select_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// New
	default public ArrayList<V> select_new(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_new() throws Exception {
		return 0;
	};

	// New > Category
	default public ArrayList<V> select_new_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_new_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// Best
	default public ArrayList<V> select_best(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_best() throws Exception {
		return 0;
	};

	// Best > Category
	default public ArrayList<V> select_best_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_best_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

////Random 6 products for Main Page
	// New
	default public ArrayList<V> select_main_new() throws Exception {
		return null;
	};

	// Best
	default public ArrayList<V> select_main_best() throws Exception {
		return null;
	};

//// Cart
	default public ArrayList<V> selectmycart(K k) throws Exception {
		return null;
	}

//// Stat

	default public ArrayList<StatVO> selectpayment() {
		return null;
	};

	default public ArrayList<StatVO> selectbypayment() {
		return null;
	};

	// All products
	default public ArrayList<StatVO> selectyearly() {
		return null;
	};

	default public ArrayList<StatVO> selectmonthly() {
		return null;
	};

	default public ArrayList<StatVO> selectdaily() {
		return null;
	};

	default public ArrayList<StatVO> selectyearlyfor(int period) {
		return null;
	};

	default public ArrayList<StatVO> selectmonthlyfor(int period) {
		return null;
	};

	default public ArrayList<StatVO> selectdailyfor(int period) {
		return null;
	};

	// New Arrivals
	default public ArrayList<StatVO> selectnewyearly() {
		return null;
	};

	default public ArrayList<StatVO> selectnewmonthly() {
		return null;
	};

	default public ArrayList<StatVO> selectnewdaily() {
		return null;
	};

	default public ArrayList<StatVO> selectnewyearlyfor(int period) {
		return null;
	};

	default public ArrayList<StatVO> selectnewmonthlyfor(int period) {
		return null;
	};

	default public ArrayList<StatVO> selectnewdailyfor(int period) {
		return null;
	};

}
