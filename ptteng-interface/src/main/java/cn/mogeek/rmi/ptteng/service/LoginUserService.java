package cn.mogeek.rmi.ptteng.service;

import cn.mogeek.rmi.ptteng.model.LoginUser;

import java.util.List;

public interface LoginUserService {
    LoginUser selectByName(String name);
    boolean checkUser(String name, String password);
    Long updateDateOf(String key);
    boolean insertUser(LoginUser loginUser);
    boolean deleteUser(int id);
    boolean updateHeadLogo(String name, String logoFileName);
}
