package lgcns.eegoba.api.book.mapper;

import java.util.List;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.api.review.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

  BookVO getBookById(Long bookId);

  List<BookVO> getBookList();

  void addBook(BookVO bookVO);

  void deleteBook(Long bookId);

  void updateBook(BookVO bookVO);

  List<ReviewVO> getBookReviewListByBookId(Long bookId);
}
