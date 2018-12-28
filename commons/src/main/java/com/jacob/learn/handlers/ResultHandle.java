package com.jacob.learn.handlers;

import com.alibaba.fastjson.JSONObject;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;

import com.jacob.learn.response.RestRespond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice
public class ResultHandle implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return Match(returnType.getMethod().getName()).of(
                Case($("getConf"), false),
                Case($("pullConf"), false),
                Case($(), true)
        );
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return Match(body).of(
                Case($(instanceOf(RestRespond.class)), body),
                Case($(instanceOf(String.class)),
                        JSONObject.toJSONString(getResp(body))),
                Case($(), getResp(body))
        );
    }

    private RestRespond getResp(Object data) {
        RestRespond respond = new RestRespond();
        respond.setSuccess(true);
        respond.setData(data);
        return respond;
    }
}
