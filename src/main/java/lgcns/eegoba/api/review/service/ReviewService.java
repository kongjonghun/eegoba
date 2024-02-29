package lgcns.eegoba.api.review.service;

import static java.util.Objects.requireNonNull;

import java.util.Date;
import java.util.List;
import lgcns.eegoba.api.review.mapper.ReviewMapper;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lgcns.eegoba.common.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewMapper reviewMapper;

  public List<ReviewVO> getReviewList() {

    if (reviewMapper.getReviewCount() > 0) {
      return reviewMapper.getReviewList();
    } else {
      throw new IllegalArgumentException();
    }
  }

  public List<ReviewVO> getReviewListByUserId(Long userId) {
    return reviewMapper.getReviewListByUserId(userId);
  }

  public ReviewVO getReviewByReviewId(Long reviewId) {
    return reviewMapper.getReviewByReviewId(reviewId);
  }

  public int saveReview(ReviewVO reviewVO) {
    try {
      requireNonNull(reviewVO);

      reviewVO.setCreatedAt(DateTimeUtil.getSeoulDateTime());
      reviewVO.setUpdatedAt(DateTimeUtil.getSeoulDateTime());

      return reviewMapper.insertReview(reviewVO);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  public int updateReview(ReviewVO reviewVO) {
    try {
      requireNonNull(reviewVO);

      reviewVO.setUpdatedAt(DateTimeUtil.getSeoulDateTime());

      return reviewMapper.updateReview(reviewVO);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  public int deleteReview(Long reviewId) {
    if (reviewMapper.getReviewCount() > 0) {
      Date updatedAt = DateTimeUtil.getSeoulDateTime();

      return reviewMapper.deleteReview(reviewId, updatedAt);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
