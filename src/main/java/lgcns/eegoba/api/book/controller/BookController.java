package lgcns.eegoba.api.book.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import lgcns.eegoba.common.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Book", description = "도서 관리 API")
@RequiredArgsConstructor
@RestController("bookController")
@RequestMapping(value = "/book")
public class BookController {

  private final BookService bookService;

  @Operation(summary = "도서 조회 (By ID)", description = "ID로 도서 조회")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "조회 성공",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "조회 실패",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
  })
  @GetMapping(value = "/{bookId}")
  public ResponseEntity<CommonApiResponse> getBookById(@PathVariable(value = "bookId") Long bookId)
      throws Exception {
    try {
      BookVO book = bookService.getBookById(bookId);
      if (ValidationUtil.isEmpty(book)) {
        throw new ApiException(ErrorCode.NotFound);
      }
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, book));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "도서 목록 조회", description = "전체 도서 목록 조회")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "조회 성공",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "조회 실패",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
  })
  @GetMapping(value = "")
  public ResponseEntity<CommonApiResponse> getBookList(
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      List<BookVO> bookList = bookService.getBookList();
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, bookList));
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "도서 생성", description = "bookVO 객체 내용을 입력받아 도서 생성")
  @ApiResponses({
    @ApiResponse(
        responseCode = "201",
        description = "생성 성공",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "생성 실패",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
  })
  @PostMapping(value = "/create")
  public ResponseEntity<CommonApiResponse> createBook(@RequestBody BookVO bookVO) throws Exception {
    try {
      if (ValidationUtil.isNotEmpty(bookService.getBookById(bookVO.getBookId()))) {
        throw new ApiException(ErrorCode.BadRequest);
      }
      int createdBookCnt = bookService.createBook(bookVO);
      return ResponseEntity.status(ResultCode.Created.getStatus())
          .body(CommonApiResponse.of(ResultCode.Created, createdBookCnt));
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "도서 수정", description = "bookVO 객체 내용을 입력받아 도서 수정")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "수정 성공",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "수정 실패",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
  })
  @PutMapping(value = "/update/{bookId}")
  public ResponseEntity<CommonApiResponse> updateBook(
      @PathVariable(value = "bookId") Long bookId, @RequestBody BookVO bookVO) throws Exception {
    try {
      if (ValidationUtil.isEmpty(bookService.getBookById(bookId))) {
        throw new ApiException(ErrorCode.NotFound);
      }
      int updatedBookCnt = bookService.updateBook(bookVO);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, updatedBookCnt));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }

  @Operation(summary = "도서의 리뷰 목록 조회", description = "도서의 전체 리뷰 목록 조회")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "조회 성공",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "조회 실패",
        content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
  })
  @PutMapping(value = "/review/{bookId}")
  public ResponseEntity<CommonApiResponse> getReviewListByBookId(
      @PathVariable(value = "bookId") Long bookId) throws Exception {
    try {
      if (ValidationUtil.isEmpty(bookService.getBookById(bookId))) {
        throw new ApiException(ErrorCode.NotFound);
      }
      List<ReviewVO> reviewList = bookService.getReviewListByBookId(bookId);
      return ResponseEntity.ok(CommonApiResponse.of(ResultCode.Success, reviewList));
    } catch (Exception e) {
      throw new ApiException(ErrorCode.InternalServerError);
    }
  }
}
