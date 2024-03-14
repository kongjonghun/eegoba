package lgcns.eegoba.api.review.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lgcns.eegoba.api.review.model.ReviewType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "후기VO")
public class ReviewVO {
  @Schema(description = "후기ID", required = true, type = "Long", example = "23")
  private Long reviewId;

  @Schema(description = "후기 종류", required = true, type = "ReviewType", example = "BOOK")
  private ReviewType type;

  @Schema(description = "책ID", required = false, type = "Long", example = "123")
  private Long bookId;

  @Schema(description = "강의ID", required = false, type = "Long", example = "123")
  private Long lectureId;

  @Schema(description = "사용자ID", required = true, type = "Long", example = "123")
  private Long userId;

  @Schema(
      description = "후기 내용",
      required = true,
      type = "String",
      example = "학습하면서 많이 배울 수 있었습니다. 추천해요!")
  private String content;

  @Schema(description = "추천여부", required = true, type = "Boolean", example = "true")
  private Boolean isRecommend;

  @Schema(description = "생성일시", required = true, type = "Date", example = "2024-01-23 10:23:07")
  private Date createdAt;

  @Schema(description = "최종 수정일시", required = true, type = "Date", example = "2024-01-23 10:23:07")
  private Date updatedAt;
}
