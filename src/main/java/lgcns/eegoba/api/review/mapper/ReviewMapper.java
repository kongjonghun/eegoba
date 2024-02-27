package lgcns.eegoba.api.review.mapper;

import lgcns.eegoba.api.review.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int getReviewCount();

    List<ReviewVO> getAllReviews();

    ReviewVO getReviewByReviewId(Long reviewId);

    List<ReviewVO> getReviewByUserId(Long userId);

    int insertReview(ReviewVO reviewVO);

    int updateReview(ReviewVO reviewVO);

    int deleteReview(Long reviewId);

}
