package sp365.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
import sp365.vo.InputVO;
import sp365.vo.ProductVO;

@Service("pbiz")
public class ProductBiz implements Biz<String, ProductVO> {

	@Resource(name = "pdao")
	Dao<String, ProductVO> dao;

	@Transactional
	@Override
	public void register(ProductVO product) throws Exception {
		dao.insert(product);
	}

	@Transactional
	@Override
	public int modify(ProductVO product) throws Exception {
		return dao.update(product);
	}

	@Transactional
	@Override
	public int remove(String p_id) throws Exception {
		return dao.delete(p_id);
	}

	@Override
	public ProductVO get(String p_id) throws Exception {
		return dao.select(p_id);
	}

	@Override
	public ArrayList<ProductVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public ArrayList<ProductVO> get_all(int startRow, int endRow) throws Exception {
		return dao.select_all(startRow, endRow);
	}

	@Override
	public int count_all() throws Exception {
		return dao.count_all();
	}

	@Override
	public ArrayList<ProductVO> get_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return dao.select_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_by_cat(String p_category) throws Exception {
		return dao.count_by_cat(p_category);
	}

	@Override
	public ArrayList<ProductVO> get_new(int startRow, int endRow) throws Exception {
		return dao.select_new(startRow, endRow);
	}

	@Override
	public int count_new() throws Exception {
		return dao.count_new();
	}

	@Override
	public ArrayList<ProductVO> get_new_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return dao.select_new_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_new_by_cat(String p_category) throws Exception {
		return dao.count_new_by_cat(p_category);
	}

	@Override
	public ArrayList<ProductVO> get_best(int startRow, int endRow) throws Exception {
		return dao.select_best(startRow, endRow);
	}

	@Override
	public int count_best() throws Exception {
		return dao.count_best();
	}

	@Override
	public ArrayList<ProductVO> get_best_by_cat(int startRow, int endRow, String p_category) throws Exception {
		return dao.select_best_by_cat(startRow, endRow, p_category);
	}

	@Override
	public int count_best_by_cat(String p_category) throws Exception {
		return dao.count_best_by_cat(p_category);
	}

	// Random 6 NEW products for Main Page
	@Override
	public ArrayList<ProductVO> get_main_new() throws Exception {
		return dao.select_main_new();
	}

	// Random 6 BEST products for Main Page
	@Override
	public ArrayList<ProductVO> get_main_best() throws Exception {
		return dao.select_main_best();
	}

	// Search
	@Override
	public ArrayList<ProductVO> getsearch(int startRow, int endRow, String input) throws Exception {
		return dao.search(startRow, endRow, input);
	}

	public int count_search(String search) throws Exception {
		return dao.count_search(search);
	}
}
