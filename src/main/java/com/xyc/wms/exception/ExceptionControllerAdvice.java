package com.xyc.wms.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyc.wms.utils.ApiResult;
import com.xyc.wms.utils.Code;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.xyc.wms.controller"}) // 注意哦，这里要加上需要扫描的包
public class ExceptionControllerAdvice implements ResponseBodyAdvice<Object> {
    @ExceptionHandler(APIException.class)
    public ApiResult<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里返回类型是自定义响应体
        return new ApiResult<String>(e.getCode(), "响应失败", e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        FieldError error = e.getBindingResult().getFieldError();
        // 注意哦，这里返回类型是自定义响应体
        return new ApiResult<>(Code.VALID_ERROR, error.getField() + ":" + error.getDefaultMessage());
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getParameterType().equals(ApiResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ApiResult<>(body));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误");
            }
        }
        // 将原本的数据包装在ResultVO里
        return new ApiResult<>(body);

    }
}
