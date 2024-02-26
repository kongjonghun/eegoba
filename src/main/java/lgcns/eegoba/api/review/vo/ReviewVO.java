package lgcns.eegoba.api.review.vo;

import lombok.*;
import java.util.Date;

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
    private Boolean isRecommend;
    private Date createdAt;
    private Date updatedAt;

}
