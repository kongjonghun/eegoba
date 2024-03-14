package lgcns.eegoba.api.book.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lgcns.eegoba.api.book.service.BookService;
import lgcns.eegoba.api.book.vo.BookVO;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.exception.ApiException;
import lgcns.eegoba.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController("bookController")
@RequestMapping(value = "/book")
public class BookController {

  private final BookService bookService;

  @GetMapping(value = "/{bookId}")
  public ResponseEntity<ApiResponse> getBookById(@PathVariable(value = "bookId") Long bookId)
      throws Exception {
    try {
      BookVO book = bookService.getBookById(bookId);
      return ResponseEntity.ok(ApiResponse.of(ResultCode.Success, book));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping(value = "")
  public ResponseEntity<ApiResponse> getBookList(
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      List<BookVO> bookList = bookService.getBookList();
      return ResponseEntity.ok(ApiResponse.of(ResultCode.Success, bookList));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/create")
  public ResponseEntity<ApiResponse> createBook(@RequestBody BookVO bookVO) throws Exception {
    try {
      if (bookService.getBookById(bookVO.getBookId()) != null) {
        throw new ApiException(ErrorCode.InternalServerError);
      }
      bookService.createBook(bookVO);
      return ResponseEntity.ok(ApiResponse.of(ResultCode.Success, bookVO));
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PutMapping(value = "/update/{bookId}")
  public ResponseEntity<ApiResponse> updateBook(
      @PathVariable(value = "bookId") Long bookId, @RequestBody BookVO bookVO) throws Exception {
    try {
      if (bookService.getBookById(bookId) == null) {
        throw new ApiException(ErrorCode.InternalServerError);
      }
      bookService.updateBook(bookVO);
      return ResponseEntity.ok(ApiResponse.of(ResultCode.Success, bookVO));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }

  @PutMapping(value = "/review/{bookId}")
  public ResponseEntity<ApiResponse> getReviewListByBookId(
      @PathVariable(value = "bookId") Long bookId) throws Exception {
    try {
      if (bookService.getBookById(bookId) == null) {
        throw new ApiException(ErrorCode.InternalServerError);
      }
      List<ReviewVO> reviewList = bookService.getReviewListByBookId(bookId);
      return ResponseEntity.ok(ApiResponse.of(ResultCode.Success, reviewList));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }
}
