package lgcns.eegoba.api.book.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lgcns.eegoba.api.base.vo.ApiResponseVO;
import lgcns.eegoba.api.book.service.BookService;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.common.constant.StatusConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@RestController("bookController")
@RequestMapping(value = "/book")
public class BookController {

  private final BookService bookService;
  // test
  // test2
  @GetMapping(value = "")
  public ApiResponseVO<Object> bookList(HttpServletRequest request, HttpServletResponse response)
      throws HttpStatusCodeException {
    try {
      ArrayList<BookVO> bookList = new ArrayList<>();
      bookList.add(BookVO.builder().bookId(1L).build());
      bookList.add(BookVO.builder().bookId(2L).build());
      bookList.add(BookVO.builder().bookId(3L).build());
      bookList.add(BookVO.builder().bookId(4L).build());

      // 로직 구현
      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(bookList)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }
}
