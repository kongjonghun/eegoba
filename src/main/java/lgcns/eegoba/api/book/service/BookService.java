package lgcns.eegoba.api.book.service;

import java.util.List;
import lgcns.eegoba.api.book.mapper.BookMapper;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {
  private final BookMapper bookMapper;

  public BookVO getBookById(Long bookId) {
    return bookMapper.getBookById(bookId);
  }

  public List<BookVO> getBookList() {
    return bookMapper.getBookList();
  }

  public int createBook(BookVO bookVO) {
    return bookMapper.insertBook(bookVO);
  }

  public int updateBook(BookVO bookVO) {
    return bookMapper.updateBook(bookVO);
  }

  public List<ReviewVO> getReviewListByBookId(Long bookId) {
    return bookMapper.getBookReviewListByBookId(bookId);
  }
}
