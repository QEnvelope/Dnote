package edu.whu.sim.cloudnote.service;

import edu.whu.sim.cloudnote.dao.User;
import edu.whu.sim.cloudnote.dao.mapper.UserMapper;
import edu.whu.sim.cloudnote.exception.UserExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     * @param user
     */
    public int registerUser(User user){
        User existUser = userMapper.findByName(user.getUsername());
        if(existUser != null){
//            throw new UserExistException("用户名已存在");
            return -1;
        }
        user.setDeleteFlag(false);
        user.setCreateDate(new Date());
        return userMapper.addUser(user);
    }

    /**
     * 注销用户
     * @param id
     */
    public void removeUser(Integer id){
        userMapper.deleteUser(id);
    }

    /**
     * 验证数据库中的用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        User user = userMapper.findByName(username);
        if(user == null){
            throw new RuntimeException("用户名不存在");
        }else{
            return user;
        }
    }
}
