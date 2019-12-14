package sp365.frame;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import sp365.vo.CartVO;
import sp365.vo.ProductVO;

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

	
	// All
	default public ArrayList<ProductVO> get_all(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_all() throws Exception {
		return 0;
	};

	// All > Category
	default public ArrayList<ProductVO> get_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// New
	default public ArrayList<ProductVO> get_new(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_new() throws Exception {
		return 0;
	};

	// New > Category
	default public ArrayList<ProductVO> get_new_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_new_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};

	// Best
	default public ArrayList<ProductVO> get_best(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception {
		return null;
	};

	default public int count_best() throws Exception {
		return 0;
	};

	// Best > Category
	default public ArrayList<ProductVO> get_best_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception {
		return null;
	};

	default public int count_best_by_cat(@Param("p_category") String p_category) throws Exception {
		return 0;
	};
}
