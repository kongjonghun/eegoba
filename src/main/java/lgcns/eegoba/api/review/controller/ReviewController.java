package lgcns.eegoba.api.review.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lgcns.eegoba.api.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Review", description = "후기 관리 API")
@RestController("reviewController")
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewController {

  private final ReviewService reviewService;

  //  @Operation(summary = "후기 목록 조회", description = "전체 후기 목록 조회")
  //  @ApiResponses({
  //    @ApiResponse(
  //        responseCode = "200",
  //        description = "성공",
  //        content = @Content(schema = @Schema(implementation = ApiExceptionEntity.class))),
  //    @ApiResponse(
  //        responseCode = "500",
  //        description = "조회에 실패하였습니다.",
  //        content = @Content(schema = @Schema(implementation = ApiExceptionEntity.class)))
  //  })
  //  @GetMapping("")
  //  public ApiResponseVO<Object> getReviewList() throws HttpStatusCodeException {
  //    try {
  //      List<ReviewVO> reviewList = reviewService.getReviewList();
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(reviewList)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
  //
  //  @Operation(summary = "후기 조회 (By ID)", description = "ID로 후기 조회")
  //  @GetMapping("/{reviewId}")
  //  public ApiResponseVO<Object> getReviewById(@PathVariable Long reviewId) {
  //    try {
  //      ReviewVO reviewVO = reviewService.getReviewById(reviewId);
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(reviewVO)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
  //
  //  @Operation(summary = "후기 목록 조회 (By 사용자ID)", description = "사용자ID로 후기 목록 조회")
  //  @GetMapping("/user")
  //  public ApiResponseVO<Object> getReviewListByUserId(
  //      @Parameter(description = "사용자ID", required = true)
  //          @RequestParam(value = "userId", required = false)
  //          Long userId)
  //      throws Exception {
  //    //    public ApiResponseVO<Object> getReviewByUserId(@SessionAttribute(name = USER_ID,
  // required
  //    // = false) Long userId) { // TODO 세션으로 변경
  //    try {
  //      List<ReviewVO> reviewList = reviewService.getReviewListByUserId(userId);
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(reviewList)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
  //
  //  @Operation(summary = "후기 생성", description = "Review 객체의 내용을 입력받아 후기 생성")
  //  @PostMapping("/create")
  //  public ApiResponseVO<Object> saveReview(@RequestBody ReviewVO reviewVO) throws Exception {
  //    try {
  //      int newReviewCnt = reviewService.saveReview(reviewVO);
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(newReviewCnt)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
  //
  //  @Operation(summary = "후기 수정", description = "Review 객체의 내용으로 후기 수정")
  //  @PostMapping("/update")
  //  public ApiResponseVO<Object> updateReview(@RequestBody ReviewVO reviewVO) throws Exception {
  //    try {
  //      int updatedReviewCnt = reviewService.updateReview(reviewVO);
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(updatedReviewCnt)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
  //
  //  @Operation(summary = "후기 삭제", description = "후기ID에 해당하는 후기 삭제")
  //  @PostMapping("/delete/{reviewId}")
  //  public ApiResponseVO<Object> deleteReview(@PathVariable Long reviewId) throws Exception {
  //    try {
  //      int deletedReviewCnt = reviewService.deleteReview(reviewId);
  //
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.Success.getStatus())
  //          .message(StatusConst.Success.getMessage())
  //          .result(deletedReviewCnt)
  //          .build();
  //    } catch (Exception e) {
  //      return ApiResponseVO.builder()
  //          .code(StatusConst.InternalServerError.getStatus())
  //          .message(e.getMessage())
  //          .build();
  //    }
  //  }
}
