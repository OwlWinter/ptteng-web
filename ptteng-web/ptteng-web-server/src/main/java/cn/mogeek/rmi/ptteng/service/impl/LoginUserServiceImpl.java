package cn.mogeek.rmi.ptteng.service.impl;

import cn.mogeek.rmi.ptteng.mapper.LoginUserMapper;
import cn.mogeek.rmi.ptteng.model.LoginUser;
import cn.mogeek.rmi.ptteng.server.util.BCrypt;
import cn.mogeek.rmi.ptteng.service.LoginUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LoginUserServiceImpl
 * @Description 用户登陆表 service 实现类
 * @Author owlwinter
 * @Date 2020/6/15 16:32
 * @Version 1.0
 **/
@Service
public class LoginUserServiceImpl implements LoginUserService {
    private static final Logger LOGGER = LogManager.getLogger(LoginUserServiceImpl.class);

    @Autowired
    LoginUserMapper loginUserMapper;

    /**
      * @Description: 对用户信息进行校验
      * @Param: [key, password]
      * @return: cn.mogeek.jsptiles.model.LoginUser
      * @Author: owlwinter
      * @Date: 2020/6/16
      */
    @Override
    public boolean checkUser(String name, String password){
        LOGGER.debug("LoginUserServiceImpl.checkUser({})", name);

        List<LoginUser> loginUserList = loginUserMapper.selectByKey(name);

        if (loginUserList.size() == 1){
            String passwd = loginUserList.get(0).getPasswd();

            if (passwd != null && passwd != "" && BCrypt.checkpw(password, passwd)){
                LOGGER.debug("密码校验成功");
                return true;
            }else {
                LOGGER.debug("密码校验失败， username:{}, password:{}", name, password);
                return false;
            }
        }

        return false;
    }

    /**
      * @Description: 根据用户名获取用户数据更新时间
      * @Param: [key]
      * @return: java.lang.Long
      * @Author: owlwinter
      * @Date: 2020/6/17
      */
    @Override
    public Long updateDateOf(String key){
        List<LoginUser> loginUserList = loginUserMapper.selectByKey(key);

        if (loginUserList.size() == 1){
            return loginUserList.get(0).getUpdateat().getTime();
        }else {
            return null;
        }
    }

    /**
      * @Description: 对传入的密码加盐加密存储
      * @Param: key：用户名 password：明文密码
      * @return: boolean：true 成功，false 失败
      * @Author: owlwinter
      * @Date: 2020/6/17
      */
    @Override
    public boolean insertUser(LoginUser loginUser){
        // 加盐加密
        loginUser.setPasswd(BCrypt.hashpw(loginUser.getPasswd(), BCrypt.gensalt()));

        int result = 0;
        try {
            result = loginUserMapper.insertSelective(loginUser);
        } catch (Exception e){
            LOGGER.info("新增用户失败! {}", loginUser);
            e.printStackTrace();
        }

        return result == 1 ? true : false;
    }

    /**
      * @Description: 根据用户 id 删除用户，注解上的 beforeInvocation = true 表示在方法执行之前就删除缓存
      * @Param: [id]
      * @return: boolean
      * @Author: owlwinter
      * @Date: 2020/6/17
      */
    @Override
    public boolean deleteUser(int id){
        int result = loginUserMapper.deleteByPrimaryKey(id);
        return result == 1 ? true : false;
    }

    /**
     * @Description: 更新用户头像
     * @Param: [name, logoFileName]
     * @return: boolean
     * @Author: owlwinter
     * @Date: 2020/7/22
     */
    @Override
    public boolean updateHeadLogo(String name, String logoFileName) {
        List<LoginUser> loginUserList = loginUserMapper.selectByKey(name);
        LoginUser loginUser;
        if (loginUserList.size() == 1){
            int id = loginUserList.get(0).getId();
            loginUser = new LoginUser();
            loginUser.setId(id);
            loginUser.setHead(logoFileName);

            return loginUserMapper.updateByPrimaryKeySelective(loginUser) == 1 ? true : false;
        }

        return false;
    }

    /**
      * @Description: 根据用户名获取用户信息
      * @Param: [key]
      * @return: cn.mogeek.jsptiles.model.LoginUser
      * @Author: owlwinter
      * @Date: 2020/6/17
      */

    @Override
    public LoginUser selectByName(String name){
        List<LoginUser> loginUserList = loginUserMapper.selectByKey(name);

        switch (loginUserList.size()){
            case 0:{
                return null;
            }

            case 1:{
                return loginUserList.get(0);
            }

            default:{
                LOGGER.error("关键词查询到多个用户:{}", loginUserList);
                return null;
            }
        }

    }

}
