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

  public void addBook(BookVO bookVO) {
    bookMapper.addBook(bookVO);
  }

  public void deleteBook(Long bookId) {
    bookMapper.deleteBook(bookId);
  }

  public void updateBook(BookVO bookVO) {
    bookMapper.updateBook(bookVO);
  }

  public List<ReviewVO> getBookReviewListByBookId(Long bookId) {
    return bookMapper.getBookReviewListByBookId(bookId);
  }
}
