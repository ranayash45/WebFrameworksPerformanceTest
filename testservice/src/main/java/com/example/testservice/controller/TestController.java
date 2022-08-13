package com.example.testservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/Test")
public class TestController {

    @RequestMapping(value = "/Hello",method = RequestMethod.GET)
    public String Hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/mockUpstream/{workTime}/execute")
    public Map<String,Object> testUpstreamService(@PathVariable int workTime){
        Map<String, Object> result = new HashMap<>();
        try {
            long startTime,endTime,elapsedTime;

            startTime = System.currentTimeMillis();
            Thread.sleep(workTime);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;

            result.put("message","work is done");
            result.put("timeTaken",elapsedTime+"ms");
            return result;
        }catch (Exception ex){
            result.put("message","Failed To Process Request");
            return result;
        }
    }

    @RequestMapping(value = "/mockUpstream/{workTime}/execute/{statusCode}")
    public ResponseEntity<Map<String, Object>> testUpstreamServiceWithStatusCode(@PathVariable("workTime") int workTime,
                                                                                 @PathVariable("statusCode")int statusCode){
        Map<String,Object> result = new HashMap<>();

        try {
            long startTime,endTime,elapsedTime;

            startTime = System.currentTimeMillis();
            Thread.sleep(workTime);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;

            result.put("message","work is done");
            result.put("timeTaken",elapsedTime+"ms");
            result.put("statusCode",statusCode);
        }catch (Exception ex){
            result.clear();
            result.put("message","Failed To Process Request");
        }
        return ResponseEntity.status(statusCode).body(result);
    }

    private <T> List<T> toList(Iterator<T> headers){
        List<T> headerList = new ArrayList<>();
        while (headers.hasNext()){
            headerList.add(headers.next());
        }
        return headerList;
    }

    @RequestMapping("/mockUpstream/sentCommand*")
    public Map<String,Object> getWhatRequestSent(HttpServletRequest servletRequest){
        Map<String,Object> result = new HashMap<>();
        result.put("AuthType",servletRequest.getAuthType());
        result.put("ContextPath",servletRequest.getContextPath());
        result.put("Cookies",servletRequest.getCookies());
        result.put("RequestUri",servletRequest.getRequestURI());
        Map<String,Object> headers = new HashMap<>();
        for (Iterator<String> it = servletRequest.getHeaderNames().asIterator(); it.hasNext(); ) {
            String headerName = it.next();
            headers.put(headerName,toList(servletRequest.getHeaders(headerName).asIterator()));
        }
        result.put("Headers",headers);
        result.put("ServletMappings",servletRequest.getHttpServletMapping());
        result.put("Method",servletRequest.getMethod());
        result.put("PathInfo",servletRequest.getPathInfo());
        result.put("QueryString",servletRequest.getQueryString());
        result.put("ChracterEncoding",servletRequest.getCharacterEncoding());
        result.put("Locales",toList(servletRequest.getLocales().asIterator()));
        result.put("Content-Type",servletRequest.getContentType());
        result.put("Parameters",servletRequest.getParameterMap());
        result.put("Protocol",servletRequest.getProtocol());
        result.put("ServerName",servletRequest.getServerName());
        result.put("ServerPort",servletRequest.getServerPort());
        result.put("RemoteUser",servletRequest.getRemoteUser());
        result.put("RemotePort",servletRequest.getRemotePort());
        result.put("RemoteAddr",servletRequest.getRemoteAddr());
        result.put("Scheme",servletRequest.getScheme());
        try {
            result.put("Body", servletRequest.getReader().lines().toArray());
        }catch (Exception io){

        }
        return result;
    }

}
