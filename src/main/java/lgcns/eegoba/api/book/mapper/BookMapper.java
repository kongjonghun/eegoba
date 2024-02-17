package lgcns.eegoba.api.book.mapper;

import lgcns.eegoba.api.book.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<BookVO> getAllBooks();

    BookVO getBookById(Integer bookId);

    List<String> getBookReviews(Integer bookId);

}
