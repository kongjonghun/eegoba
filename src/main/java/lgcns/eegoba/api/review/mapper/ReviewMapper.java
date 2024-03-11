package lgcns.eegoba.api.review.mapper;

import java.util.Date;
import java.util.List;
import lgcns.eegoba.api.review.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
  int getReviewCount();

  List<ReviewVO> getReviewList();

  ReviewVO getReviewById(Long reviewId);

  List<ReviewVO> getReviewListByUserId(Long userId);

  int insertReview(ReviewVO reviewVO);

  int updateReview(ReviewVO reviewVO);

  int deleteReview(Long reviewId, Date updatedAt);
}
