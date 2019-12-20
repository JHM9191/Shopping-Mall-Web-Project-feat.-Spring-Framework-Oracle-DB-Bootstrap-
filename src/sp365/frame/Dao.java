package sp365.frame;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import sp365.vo.CartVO;
import sp365.vo.InputVO;
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
	default public ArrayList<V> selectmine(K k) throws Exception {
		return null;
	}
	
	default public ArrayList<V> selectbyorder(K k) throws Exception {
		return null;
	}
	
	default public int updateorderid(V v) throws Exception {
		return 0;
	}

////Stat

	default public ArrayList<V> selectpayment() {
		return null;
	};

	default public ArrayList<V> selectbypayment() {
		return null;
	};

	// All products
	default public ArrayList<V> selectyearly() {
		return null;
	};

	default public ArrayList<V> selectmonthly() {
		return null;
	};

	default public ArrayList<V> selectdaily() {
		return null;
	};

	default public ArrayList<V> selectyearlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectmonthlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectdailyfor(int period) {
		return null;
	};

	// New Arrivals
	default public ArrayList<V> selectnewyearly() {
		return null;
	};

	default public ArrayList<V> selectnewmonthly() {
		return null;
	};

	default public ArrayList<V> selectnewdaily() {
		return null;
	};

	default public ArrayList<V> selectnewyearlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectnewmonthlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectnewdailyfor(int period) {
		return null;
	};

	// Best
	default public ArrayList<V> selectbestyearly() {
		return null;
	};

	default public ArrayList<V> selectbestmonthly() {
		return null;
	};

	default public ArrayList<V> selectbestdaily() {
		return null;
	};

	default public ArrayList<V> selectbestyearlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectbestmonthlyfor(int period) {
		return null;
	};

	default public ArrayList<V> selectbestdailyfor(int period) {
		return null;
	};
	
//// Search
	default public ArrayList<V> search(int startRow, int endRow, String search) throws Exception {
		return null;
	}

	default public int count_search(String search) throws Exception{
		return 0;
	}

//// UserBoard
	default public ArrayList<V> mypageselect(String u_id) throws Exception{
		return null;
		
	}
}
