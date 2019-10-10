package edu.whu.sim.cloudnote.web;

import javax.servlet.http.HttpServletRequest;

/**
 * httpServletRequest线程缓存
 */
public class HttpRequestCache {
    private static ThreadLocal<HttpServletRequest> httpRequestCache = new ThreadLocal<>();

    public static HttpServletRequest getRequest(){
        return httpRequestCache.get();
    }

    public static void setRequest(HttpServletRequest httpServletRequest){
        httpRequestCache.set(httpServletRequest);
    }
}
