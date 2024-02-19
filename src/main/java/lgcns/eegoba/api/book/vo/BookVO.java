package lgcns.eegoba.api.book.vo;

import lgcns.eegoba.api.review.vo.ReviewVO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {

    private Long bookId;
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;
    private List<ReviewVO> reviewVOList;
}
