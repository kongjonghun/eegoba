package lgcns.eegoba.api.book.vo;

import java.util.List;
import lgcns.eegoba.api.review.vo.ReviewVO;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {

  private Integer bookId;
  private String title;
  private String author;
  private String publisher;
  private String isbn;
  private String imageUrl;
  private List<ReviewVO> reviewVOList;
}
