package edu.whu.sim.cloudnote.util;

import edu.whu.sim.cloudnote.dao.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

/**
 * 获取用户信息
 */
public class UserUtils {

    /**
     * 利用SecurityContextHolder获取登录用户信息，SecurityContextHolder本身是用ThreadLocal实现的
     * @return
     */
    public static User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }
        return null;
    }
}
