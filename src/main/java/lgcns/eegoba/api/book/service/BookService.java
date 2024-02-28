package lgcns.eegoba.api.book.service;

import lgcns.eegoba.api.book.mapper.BookMapper;
import lgcns.eegoba.api.book.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

  private final BookMapper bookMapper;

  public BookVO getBook(Long bookId) {
    return bookMapper.getBookById(bookId);
  }
}
