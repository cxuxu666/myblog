package com.cxd.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cxd on 2020/10/13.
 */
@ControllerAdvice//拦截所有有@Controller注解的类
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());//日志


    @ExceptionHandler(Exception.class)//标识这个方法可以做异常处理，Exception.class表示拦截的是Exception级别的异常
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);//{}占位符

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());//url
        mv.addObject("exception", e);//异常
        mv.setViewName("error/error");//返回去异常页面
        return mv;
    }
}
