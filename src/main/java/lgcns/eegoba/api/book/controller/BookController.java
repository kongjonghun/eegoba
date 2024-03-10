package lgcns.eegoba.api.book.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import lgcns.eegoba.api.book.service.BookService;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController("bookController")
@RequestMapping(value = "/book")
public class BookController {

  private final BookService bookService;

  @GetMapping(value = "")
  public ApiResponse getBookList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    try {
      ArrayList<BookVO> bookList = new ArrayList<>();
      bookList.add(BookVO.builder().bookId(1L).build());
      bookList.add(BookVO.builder().bookId(2L).build());
      bookList.add(BookVO.builder().bookId(3L).build());
      bookList.add(BookVO.builder().bookId(4L).build());

      // 로직 구현
      return new ApiResponse<>(ResultCode.Success, bookList);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping(value = "/{bookId}")
  public ApiResponse getBook(@PathVariable(value = "bookId") Long bookId) throws Exception {
    try {
      BookVO book = bookService.getBook(bookId);
      // 로직 구현
      return new ApiResponse<>(ResultCode.Success, book);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
