package lgcns.eegoba.api.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lgcns.eegoba.api.review.service.ReviewService;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lgcns.eegoba.common.constant.ErrorCode;
import lgcns.eegoba.common.constant.ResultCode;
import lgcns.eegoba.common.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Review", description = "후기 관리 API")
@RestController("reviewController")
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewController {

  private final ReviewService reviewService;

  @Operation(summary = "후기 목록 조회", description = "전체 후기 목록 조회")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "성공",
        content =
            @Content(
                schema = @Schema(implementation = lgcns.eegoba.common.response.ApiResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "조회에 실패하였습니다.",
        content =
            @Content(
                schema = @Schema(implementation = lgcns.eegoba.common.response.ApiResponse.class)))
  })
  @GetMapping("")
  public lgcns.eegoba.common.response.ApiResponse getReviewList() throws Exception {
    try {
      List<ReviewVO> reviewList = reviewService.getReviewList();

      return new lgcns.eegoba.common.response.ApiResponse<>(ResultCode.Success, reviewList);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "후기 조회 (By ID)", description = "ID로 후기 조회")
  @GetMapping("/{reviewId}")
  public lgcns.eegoba.common.response.ApiResponse getReviewById(@PathVariable Long reviewId)
      throws Exception {
    try {
      ReviewVO reviewVO = reviewService.getReviewById(reviewId);

      return new lgcns.eegoba.common.response.ApiResponse<>(ResultCode.Success, reviewVO);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "후기 목록 조회 (By 사용자ID)", description = "사용자ID로 후기 목록 조회")
  @GetMapping("/user")
  public lgcns.eegoba.common.response.ApiResponse getReviewListByUserId(
      @Parameter(description = "사용자ID", required = true)
          @RequestParam(value = "userId", required = false)
          Long userId)
      throws Exception {
    //    public ApiResponseVO<Object> getReviewByUserId(@SessionAttribute(name = USER_ID, required
    // = false) Long userId) { // TODO 세션으로 변경
    try {
      List<ReviewVO> reviewList = reviewService.getReviewListByUserId(userId);

      return new lgcns.eegoba.common.response.ApiResponse(ResultCode.Success, reviewList);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "후기 생성", description = "Review 객체의 내용을 입력받아 후기 생성")
  @PostMapping("/create")
  public lgcns.eegoba.common.response.ApiResponse saveReview(@RequestBody ReviewVO reviewVO)
      throws Exception {
    try {
      int newReviewCnt = reviewService.saveReview(reviewVO);

      return new lgcns.eegoba.common.response.ApiResponse(ResultCode.Success, newReviewCnt);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "후기 수정", description = "Review 객체의 내용으로 후기 수정")
  @PostMapping("/update")
  public lgcns.eegoba.common.response.ApiResponse updateReview(@RequestBody ReviewVO reviewVO)
      throws Exception {
    try {
      int updatedReviewCnt = reviewService.updateReview(reviewVO);

      return new lgcns.eegoba.common.response.ApiResponse<>(ResultCode.Success, updatedReviewCnt);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Operation(summary = "후기 삭제", description = "후기ID에 해당하는 후기 삭제")
  @PostMapping("/delete/{reviewId}")
  public lgcns.eegoba.common.response.ApiResponse deleteReview(@PathVariable Long reviewId)
      throws Exception {
    try {
      int deletedReviewCnt = reviewService.deleteReview(reviewId);

      return new lgcns.eegoba.common.response.ApiResponse<>(ResultCode.Success, deletedReviewCnt);
    } catch (ApiException e) {
      throw new ApiException(ErrorCode.InternalServerError);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
