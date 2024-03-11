package lgcns.eegoba.api.book.mapper;

import java.util.List;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.api.review.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

  BookVO getBookById(Integer bookId);

  List<BookVO> getBookList();
  
  void insertBook(BookVO bookVO);

  void updateBook(BookVO bookVO);

  List<ReviewVO> getBookReviewListByBookId(Integer bookId);
}
