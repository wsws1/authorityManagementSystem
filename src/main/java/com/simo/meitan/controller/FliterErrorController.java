package com.simo.meitan.controller;

import com.simo.meitan.utils.RestResponse;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//@Controller
public class FliterErrorController extends AbstractErrorController {
        public FliterErrorController(ErrorAttributes errorAttributes) {
            super(errorAttributes);
        }
        @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        @ResponseStatus(code= HttpStatus.OK)
        public RestResponse handleError(HttpServletRequest request) {
            Map<String, Object> errorAttributes = super.getErrorAttributes(request, true);

            RestResponse restResponse=RestResponse.fail(errorAttributes.get("message").toString());
            errorAttributes.clear();
            errorAttributes.replace("status",200);
            errorAttributes.put("data",restResponse);
            return restResponse;
        }


//        @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
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


        @Override
        public String getErrorPath() {
            return "/error";
        }
    }