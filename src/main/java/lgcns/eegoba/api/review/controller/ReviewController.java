package lgcns.eegoba.api.review.controller;

import java.util.List;
import lgcns.eegoba.api.base.vo.ApiResponseVO;
import lgcns.eegoba.api.review.service.ReviewService;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lgcns.eegoba.common.constant.StatusConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RestController("reviewController")
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewController {

  private final ReviewService reviewService;

  @GetMapping("")
  public ApiResponseVO<Object> getReviewList() throws HttpStatusCodeException {
    try {
      List<ReviewVO> reviewList = reviewService.getReviewList();

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(reviewList)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @GetMapping("/{reviewId}")
  public ApiResponseVO<Object> getReviewById(@PathVariable Long reviewId) {
    try {
      ReviewVO reviewVO = reviewService.getReviewById(reviewId);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(reviewVO)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @GetMapping("/user")
  public ApiResponseVO<Object> getReviewListByUserId(
      @RequestParam(value = "userId", required = false) Long userId) throws Exception {
    //    public ApiResponseVO<Object> getReviewByUserId(@SessionAttribute(name = USER_ID, required
    // = false) Long userId) { // TODO 세션으로 변경
    try {
      List<ReviewVO> reviewList = reviewService.getReviewListByUserId(userId);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(reviewList)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping("/create")
  public ApiResponseVO<Object> saveReview(@RequestBody ReviewVO reviewVO) throws Exception {
    try {
      int newReviewCnt = reviewService.saveReview(reviewVO);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(newReviewCnt)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping("/update")
  public ApiResponseVO<Object> updateReview(@RequestBody ReviewVO reviewVO) throws Exception {
    try {
      int updatedReviewCnt = reviewService.updateReview(reviewVO);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(updatedReviewCnt)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }

  @PostMapping("/delete/{reviewId}")
  public ApiResponseVO<Object> deleteReview(@PathVariable Long reviewId) throws Exception {
    try {
      int deletedReviewCnt = reviewService.deleteReview(reviewId);

      return ApiResponseVO.builder()
          .code(StatusConst.Success.getStatus())
          .message(StatusConst.Success.getMessage())
          .result(deletedReviewCnt)
          .build();
    } catch (Exception e) {
      return ApiResponseVO.builder()
          .code(StatusConst.InternalServerError.getStatus())
          .message(e.getMessage())
          .build();
    }
  }
}
