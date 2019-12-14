package sp365.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import sp365.vo.ProductVO;

public interface ProductMapper {
	public void insert(ProductVO product) throws Exception;

	public int delete(String p_id) throws Exception;

	public int update(ProductVO product) throws Exception;

	public ProductVO select(String p_id) throws Exception;

	public ArrayList<ProductVO> selectall() throws Exception;

	//// Random 6 products for Main Page
	// New
	public ArrayList<ProductVO> select_main_new() throws Exception;
	
	// Best
	public ArrayList<ProductVO> select_main_best() throws Exception;
	
	
	//// Product(Pagination Applied)
	// All
	public ArrayList<ProductVO> select_all(@Param("startRow") int startRow, @Param("endRow") int endRow) throws Exception;
	public int count_all() throws Exception;

	// All > Category
	public ArrayList<ProductVO> select_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception;
	public int count_by_cat(@Param("p_category") String p_category) throws Exception;

	// New
	public ArrayList<ProductVO> select_new(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception;
	public int count_new() throws Exception;

	// New > Category
	public ArrayList<ProductVO> select_new_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception;
	public int count_new_by_cat(@Param("p_category") String p_category) throws Exception;

	// Best
	public ArrayList<ProductVO> select_best(@Param("startRow") int startRow, @Param("endRow") int endRow)
			throws Exception;
	public int count_best() throws Exception;

	// Best > Category
	public ArrayList<ProductVO> select_best_by_cat(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("p_category") String p_category) throws Exception;
	public int count_best_by_cat(@Param("p_category") String p_category) throws Exception;
}
