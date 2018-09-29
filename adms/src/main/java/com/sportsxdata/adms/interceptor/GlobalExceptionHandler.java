package com.sportsxdata.adms.interceptor;

import com.sportsxdata.adms.model.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;


/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午3:19:56
 */
@ControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 拦截业务异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DataResult notFount(Exception e) {
        log.error("业务异常:", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("对用户操作时,参数非法!");
        return dataResult;
    }

    /**
     * 用户未登录异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public DataResult unAuth(AuthenticationException e) {
        log.error("用户未登陆：", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("用户未登陆!");
        return dataResult;
    }

    /**
     * 账号被冻结异常
     */
    @ExceptionHandler(DisabledAccountException.class)
    @ResponseBody
    public DataResult accountLocked(DisabledAccountException e, Model model) {
        log.error("账户被冻结",e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("账户被冻结!");
        return dataResult;
    }

    /**
     * 账号密码错误异常
     */
    @ExceptionHandler(CredentialsException.class)
    @ResponseBody
    public DataResult credentials(CredentialsException e, Model model) {
        log.error("账户或密码错误",e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("账户或密码错误!");
        return dataResult;
    }


    /**
     * 无权访问该资源异常
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseBody
    public DataResult credentials(UndeclaredThrowableException e) {
        log.error("权限异常!", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("权限异常!");
        return dataResult;
    }

    /**
     * 无权访问该资源异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public DataResult authorization(UnauthorizedException e) {
        log.error("无这个角色!", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("角色异常!");
        return dataResult;
    }
    /**
     * 无权访问该资源异常
     */
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public DataResult authorization(AuthorizationException e) {
        log.error("无权调用方法!", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("无权执行方法!");
        return dataResult;
    }


    /**
     * 全局空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public DataResult nullException(NullPointerException e) {
        log.error("空指针异常:", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(500);
        dataResult.setMessage("业务处理异常!");
        return dataResult;
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResult notFount(RuntimeException e) {
        log.error("服务器未知运行时异常:", e);
        DataResult dataResult = new DataResult();
        dataResult.setCode(400);
        dataResult.setMessage("服务器未知运行时异常!");
        return dataResult;
    }




}
