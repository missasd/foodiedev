package com.imooc.exception;

import com.imooc.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * controller增强器
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    // 上传文件超过500k, 捕获异常: MaxUploadSizeExceededException
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public JSONResult handlerMaxUploadFile(MaxUploadSizeExceededException ex){

        return JSONResult.errorMsg("文件上传大小不能超过500k, 请压缩图片或者降低图片质量再上传! ");
    }

}
