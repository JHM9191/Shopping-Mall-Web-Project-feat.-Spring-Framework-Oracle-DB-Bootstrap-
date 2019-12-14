package sp365.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp365.frame.Biz;
import sp365.frame.Dao;
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

	

}
