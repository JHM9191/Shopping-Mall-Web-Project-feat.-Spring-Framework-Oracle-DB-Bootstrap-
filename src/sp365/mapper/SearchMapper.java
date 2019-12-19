package sp365.mapper;



import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import sp365.vo.InputVO;
import sp365.vo.ProductVO;

public interface SearchMapper {
	public ArrayList<ProductVO> search(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("search") String search) throws Exception;
	public int count_search(String search) throws Exception;
	
	
}
