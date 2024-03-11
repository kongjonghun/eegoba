package lgcns.eegoba.api.book.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lgcns.eegoba.api.base.vo.ApiResponseVO;
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

  @GetMapping(value = "/{bookId}")
  public ApiResponse getBookById(@PathVariable(value = "bookId") Integer bookId)
      throws Exception {
    try {
      BookVO book = bookService.getBookById(bookId);

      // 로직 구현
        return new ApiResponse<>(ResultCode.Success, book);
    } catch (ApiException e) {
        throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
        throw new Exception(e);
    }
  }

  @GetMapping(value = "")
  public ApiResponse getBookList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    try {
      List<BookVO> bookList = bookService.getBookList();

      // 로직 구현
      return new ApiResponse<>(ResultCode.Success, bookList);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/create")
  public ApiResponseVO<Object> createBook(@RequestBody BookVO bookVO)
      throws HttpStatusCodeException {
    try {
      if (bookService.getBookById(bookVO.getBookId()) != null) {
        return ApiResponseVO.builder()
            .code(StatusConst.BadRequest.getStatus())
            .message("Data already exist.")
            .build();
      }
      bookService.createBook(bookVO);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(bookVO)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PutMapping(value = "/update/{bookId}")
  public ApiResponseVO<Object> updateBook(
      @PathVariable(value = "bookId") Integer bookId, @RequestBody BookVO bookVO)
      throws HttpStatusCodeException {
    try {
      BookVO book = bookService.getBook(bookId);
      // 로직 구현
      return new ApiResponse<>(ResultCode.Success, book);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
      if (bookService.getBookById(bookId) == null) {
        return ApiResponseVO.builder()
            .code(StatusConst.BadRequest.getStatus())
            .message("Data not exist.")
            .build();
      }

      bookService.updateBook(bookVO);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(bookVO)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PutMapping(value = "/review/{bookId}")
  public ApiResponseVO<Object> getReviewListByBookId(@PathVariable(value = "bookId") Integer bookId)
      throws HttpStatusCodeException {
    try {
      if (bookService.getBookById(bookId) == null) {
        return ApiResponseVO.builder()
            .code(StatusConst.BadRequest.getStatus())
            .message("Data not exist.")
            .build();
      }

      List<ReviewVO> reviewList = bookService.getReviewListByBookId(bookId);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(reviewList)
          .build();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
