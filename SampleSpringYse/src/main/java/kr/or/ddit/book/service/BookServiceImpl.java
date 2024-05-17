package kr.or.ddit.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.book.dao.BookDAO;

/*
 * 일반적으로 서비스 레이어는 인터페이스와 클래스를 함께 사용한다.
 * 스프링은 직접 클래스를 생성하는 것을 지양하고 인터페이스를 통해 접근하는 것을 권장하는 프레임워크입니다.
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;
	
	/**
	 * <p>책등록</p>
	 * @since SampleSpringYse 1.0
	 * @author PC-03
	 * @param map 등록할 책 데이터
	 * @return 성공 책 ID, 실패 null 
	 */
	@Override
	public String insertBook(Map<String, Object> map) {
		int status = bookDao.insert(map);
		if(status == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}

	/**
	 * <p>책등록</p>
	 * @since SampleSpringYse 1.0
	 * @author PC-03
	 * @param map 책 ID
	 * @return ID에 해당하는 책 정보 
	 */
	@Override
	public Map<String, Object> selectBook(Map<String, Object> map) {
		// 서비스 내 selectBook함수는 dao를 호출한 결과를 바로 리턴하는 일만 한다.
		return bookDao.selectBook(map);
	}

	/**
	 * <p>책 수정</p>
	 * @since SampleSpringYse 1.0
	 * @author PC-03
	 * @param map 책 ID
	 * @return 성공 1, 실패 0
	 */
	@Override
	public boolean updateBook(Map<String, Object> map) {
		// 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차가 필요 없으므로 행이 정상적으로 영향 받았는지만 검사하면 된다.
		int affectRowCount = bookDao.update(map);
			
		return affectRowCount == 1;
	}

	/**
	 * <p>책 삭제</p>
	 * @since SampleSpringYse 1.0
	 * @author ddit_june
	 * @param map 책 ID
	 * @return 성공 1, 실패 0 
	 */
	@Override
	public boolean deleteBook(Map<String, Object> map) {
		int affectRowCount = bookDao.delete(map);
		return affectRowCount == 1;
	}

	/**
	 * <p>책 목록</p>
	 * @since SampleSpringYse 1.0
	 * @author ddit_june
	 * @param 
	 * @return 성공 리스트(책), 실패 null 
	 */
	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.selectBookList(map);
	}


}
