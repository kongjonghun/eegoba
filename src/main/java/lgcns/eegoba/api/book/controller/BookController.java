package lgcns.eegoba.api.book.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lgcns.eegoba.api.base.vo.ApiResponseVO;
import lgcns.eegoba.api.book.service.BookService;
import lgcns.eegoba.common.constant.StatusConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RequiredArgsConstructor
@RestController("bookController")
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "")
    public ApiResponseVO bookList(HttpServletRequest request, HttpServletResponse response) throws HttpStatusCodeException {
        try{
            // 로직 구현
            return ApiResponseVO.builder().code(StatusConst.Success.getStatus()).message(StatusConst.Success.getMessage()).build();
        }catch (ServiceException se){
            return ApiResponseVO.builder().code(StatusConst.InternalServerError.getStatus()).message(StatusConst.InternalServerError.getMessage()).build();
        }
    }
}

