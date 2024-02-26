package lgcns.eegoba.api.review.vo;

import java.util.Date;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {

  private Long bookId;
  private Long reviewId;
  private Long userId;
  private String content;
  private int rating; // 추천:1, 비추천:0
  private Date createdAt;
  private Date updatedAt;
}
