package lgcns.eegoba.api.book.mapper;

import java.util.List;
import lgcns.eegoba.api.book.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

  List<BookVO> getAllBooks();

  BookVO getBookById(Long bookId);

  List<String> getBookReviews(Integer bookId);
}
