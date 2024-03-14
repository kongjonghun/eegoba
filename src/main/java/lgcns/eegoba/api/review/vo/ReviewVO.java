package lgcns.eegoba.api.review.vo;

import java.util.Date;
import lgcns.eegoba.api.review.model.ContentType;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {

  private Long reviewId;
  private ContentType contentType;
  private Long bookId;
  private Long lectureId;
  private Long userId;
  private String reviewContent;
  private Boolean isRecommend;
  private Date createdAt;
  private Date updatedAt;
}
