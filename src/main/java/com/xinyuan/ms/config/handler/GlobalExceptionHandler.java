package com.xinyuan.ms.config.handler;

import com.xinyuan.ms.common.util.ResultUtil;
import com.xinyuan.ms.common.web.Message;
import com.xinyuan.ms.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常的处理
 *
 * @author
 * @since 2018-03-07
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Message> baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(), ex);
        Message message = ResultUtil.error(ex.getStatus(),ex.getMessage());

        return ResponseEntity.status(ex.getStatus()).body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> otherExceptionHandler(HttpServletResponse response, Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    /**
     * 参数校验产生的异常
     *
     * @author 2018-01-01 16:28
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validExceptionHandler(HttpServletResponse response, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuffer stringBuffer = new StringBuffer();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                //该格式仅仅作为response展示和log作用，前端应自己做校验
                stringBuffer.append(fieldError.getObjectName() + "--" + fieldError.getDefaultMessage() + " ");
            }
        }
        logger.error(stringBuffer.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringBuffer.toString());
    }


}
