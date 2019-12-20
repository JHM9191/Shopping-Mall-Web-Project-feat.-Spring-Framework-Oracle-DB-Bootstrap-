package sp365.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sp365.frame.Dao;
import sp365.mapper.ProductMapper;
import sp365.mapper.SearchMapper;
import sp365.vo.InputVO;
import sp365.vo.ProductVO;

@Repository("pdao")
public class ProductDao implements Dao<String, ProductVO> {

	@Autowired
	ProductMapper pm;

	@Autowired
	SearchMapper sm;
	
	

	@Override
	public void insert(ProductVO product) throws Exception {
		pm.insert(product);
	}

	@Override
	public int update(ProductVO product) throws Exception {
		return pm.update(product);
	}

	@Override
	public int delete(String p_id) throws Exception {
		return pm.delete(p_id);
	}

	@Override
	public ProductVO select(String p_id) throws Exception {
		return pm.select(p_id);
	}

	@Override
	public ArrayList<ProductVO> selectall() throws Exception {
		return pm.selectall();
	}

	// All
	@Override
	public ArrayList<ProductVO> select_all(int startRow, int endRow) throws Exception {
		return pm.select_all(startRow, endRow);
	}

	@Override
	public int count_all() throws Exception {
		return pm.count_all();
	}

	// All > Category
	@Override
	public ArrayList<ProductVO> select_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return pm.select_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_by_cat(String p_category) throws Exception {
		return pm.count_by_cat(p_category);
	}

	// New
	@Override
	public ArrayList<ProductVO> select_new(int startRow, int endRow) throws Exception {
		return pm.select_new(startRow, endRow);
	}

	@Override
	public int count_new() throws Exception {
		return pm.count_new();
	}

	// New > Category
	@Override
	public ArrayList<ProductVO> select_new_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return pm.select_new_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_new_by_cat(String p_category) throws Exception {
		return pm.count_new_by_cat(p_category);
	}

	// Best
	@Override
	public ArrayList<ProductVO> select_best(int startRow, int endRow) throws Exception {
		return pm.select_best(startRow, endRow);
	}

	@Override
	public int count_best() throws Exception {
		return pm.count_best();
	}

	// Best > Category
	@Override
	public ArrayList<ProductVO> select_best_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return pm.select_best_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_best_by_cat(String p_category) throws Exception {
		return pm.count_best_by_cat(p_category);
	}
	
	// Random 6 NEW products for Main Page
	@Override
	public ArrayList<ProductVO> select_main_new() throws Exception {
		return pm.select_main_new();
	}
	
	// Random 6 BEST products for Main Page
	@Override
	public ArrayList<ProductVO> select_main_best() throws Exception {
		return pm.select_main_best();
	}
	
	// Search
	@Override
	public ArrayList<ProductVO> search(int startRow, int endRow, String input) throws Exception{
		return sm.search(startRow,endRow,input);
	}
	
	@Override
	public int count_search(String search) throws Exception{
		System.out.println("count_search: " + sm.count_search(search));
		return sm.count_search(search);
	}
	
}
