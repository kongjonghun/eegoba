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
import lgcns.eegoba.common.response.CommonApiResponse;
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
  public ResponseEntity<CommonApiResponse> getBookById(@PathVariable(value = "bookId") Long bookId)
      throws Exception {
    try {
      BookVO book = bookService.getBookById(bookId);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, book));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping(value = "")
  public ResponseEntity<CommonApiResponse> getBookList(
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      List<BookVO> bookList = bookService.getBookList();
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, bookList));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/create")
  public ResponseEntity<CommonApiResponse> createBook(@RequestBody BookVO bookVO) throws Exception {
    try {
      if (bookService.getBookById(bookVO.getBookId()) != null) {
        throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
      }
      bookService.createBook(bookVO);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, bookVO));
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PutMapping(value = "/update/{bookId}")
  public ResponseEntity<CommonApiResponse> updateBook(
      @PathVariable(value = "bookId") Long bookId, @RequestBody BookVO bookVO) throws Exception {
    try {
      if (bookService.getBookById(bookId) == null) {
        throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
      }
      bookService.updateBook(bookVO);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, bookVO));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(value = "/review/{bookId}")
  public ResponseEntity<CommonApiResponse> getReviewListByBookId(
      @PathVariable(value = "bookId") Long bookId) throws Exception {
    try {
      if (bookService.getBookById(bookId) == null) {
        throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
      }
      List<ReviewVO> reviewList = bookService.getReviewListByBookId(bookId);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, reviewList));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
  }
}
