package cn.mogeek.rmi.ptteng.model.vo;

import cn.mogeek.rmi.ptteng.model.LoginUser;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @ClassName UserSignOnVO
 * @Description 用于接收注册用户提交的信息
 * @Author owlwinter
 * @Date 2020/7/20 16:38
 * @Version 1.0
 **/
public class UserSignOnVO extends LoginUser {
    private static final long serialVersionUID = 4465035893282204916L;
    /**注册用户提交的验证码*/
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserSignOnVO{" +
                "code='" + code + '\'' +
                '}';
    }
}
