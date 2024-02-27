package lgcns.eegoba.api.review.service;

import lgcns.eegoba.api.review.mapper.ReviewMapper;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public List<ReviewVO> getAllReviews() {

            if (reviewMapper.getReviewCount() > 0) {
                return reviewMapper.getAllReviews();
            } else {
                throw new IllegalArgumentException();
            }
    }

    public List<ReviewVO> getReviewByUserId(Long userId) {
        return reviewMapper.getReviewByUserId(userId);
    }

    public ReviewVO getReviewByReviewId(Long reviewId) {
        return reviewMapper.getReviewByReviewId(reviewId);
    }

    public int saveReview(ReviewVO reviewVO) {
        try {
            requireNonNull(reviewVO);
            return reviewMapper.insertReview(reviewVO);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int updateReview(ReviewVO reviewVO) {
        try {
            requireNonNull(reviewVO);
            return reviewMapper.updateReview(reviewVO);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int deleteReview(Long reviewId) {
        if (reviewMapper.getReviewCount() > 0) {
            return reviewMapper.deleteReview(reviewId);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
