package lgcns.eegoba.api.review.vo;

import java.util.Date;
import lgcns.eegoba.api.review.model.ReviewType;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {

  private Long reviewId;
  private ReviewType type;
  private Long bookId;
  private Long lectureId;
  private Long userId;
  private String content;
  private Boolean isRecommend;
  private Date createdAt;
  private Date updatedAt;
}
