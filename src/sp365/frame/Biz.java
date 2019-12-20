package sp365.frame;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import sp365.vo.BoardVO;
import sp365.vo.CartVO;
import sp365.vo.InputVO;
import sp365.vo.ProductVO;
import sp365.vo.StatVO;

public interface Biz<K, V> {

	@Transactional
	default public void register(V v) throws Exception {
	};

	@Transactional
	default public int remove(K k) throws Exception {
		return 0;
	};

	@Transactional
	default public int modify(V v) throws Exception {
		return 0;
	};

	default public V get(K k) throws Exception {
		return null;
	};

	default public ArrayList<V> get() throws Exception {
		return null;
	};

	//// Product
	// All
	default public ArrayList<V> get_all(@Param("startRow") int startRow, @Param("endRow") int endRow) throws Exception {
		return null;
	};

	default public int count_all() throws Exception {
		return 0;
	};

	// All > Category
	default public ArrayList<V> get_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// New
	default public ArrayList<V> get_new(@Param("startRow") int startRow, @Param("endRow") int endRow) throws Exception {
		return null;
	};

	default public int count_new() throws Exception {
		return 0;
	};

	// New > Category
	default public ArrayList<V> get_new_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_new_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// Best
	default public ArrayList<V> get_best(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_best() throws Exception {
		return 0;
	};

	// Best > Category
	default public ArrayList<V> get_best_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_best_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

////Random 6 products for Main Page
	// New
	default public ArrayList<V> get_main_new() throws Exception {
		return null;
	};

	// Best
	default public ArrayList<V> get_main_best() throws Exception {
		return null;
	};

//// Cart
	public default ArrayList<V> getmycart(K k) throws Exception {
		return null;
	}
	
	public default ArrayList<V> getbyorder(K k) throws Exception {
		return null;
	}
	
	default public int setorderid(V v) throws Exception {
		return 0;
	}
	
////Order
	default public ArrayList<V> getmyorder(K k) throws Exception {
		return null;
	}
	
	// All products
		default public ArrayList<V> getyearly() {
			return null;
		};

		default public ArrayList<V> getmonthly() {
			return null;
		};

		default public ArrayList<V> getdaily() {
			return null;
		}

		default public ArrayList<V> getyearlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getmonthlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getdailyfor(int period) {
			return null;
		};

		// New Arrivals
		default public ArrayList<V> getnewyearly() {
			return null;
		};

		default public ArrayList<V> getnewmonthly() {
			return null;
		};

		default public ArrayList<V> getnewdaily() {
			return null;
		}

		default public ArrayList<V> getnewyearlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getnewmonthlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getnewdailyfor(int period) {
			return null;
		};

		// Best
		default public ArrayList<V> getbestyearly() {
			return null;
		};

		default public ArrayList<V> getbestmonthly() {
			return null;
		};

		default public ArrayList<V> getbestdaily() {
			return null;
		}

		default public ArrayList<V> getbestyearlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getbestmonthlyfor(int period) {
			return null;
		}

		default public ArrayList<V> getbestdailyfor(int period) {
			return null;
		};

//// Search
	default ArrayList<ProductVO> getsearch(int startRow, int endRow, String search) throws Exception{
		return null;
	}
	
	default public int count_search(String search) throws Exception{
		return 0;
	}
	
//// UserBoard
	default public ArrayList<BoardVO> mypageget(String u_id) throws Exception {
		return null;
	}
}
