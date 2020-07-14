package com.simo.meitan.controller;


import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 这个异常处理主要是处理一些 filter 中的异常
 * 但是，这个类无法修改 http 的状态码，从而无法让前端根据状态码，返回定制的信息
 */
//@RestController
public class MyErrorController implements  ErrorController {


//
//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public  ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
//        HttpStatus status = getStatus(request);
//        //自定义的错误信息类
//        //status.value():错误代码，
//        //body.get("message").toString()错误信息
//        RestResponse ret=RestResponse.fail( body.get("message").toString());
//        body.put("data",ret);
//        return new ResponseEntity(body, status);
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "error/error";
//    }
    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public RestResponse errorApiHandler(HttpServletRequest request, final Exception ex, final WebRequest req) {

        RequestAttributes requestAttributes = new ServletRequestAttributes(request);

        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(req, false);
        int status = getStatus(request);

        return RestResponse.fail(status, String.valueOf(attr.getOrDefault("message", "error")));
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }
}