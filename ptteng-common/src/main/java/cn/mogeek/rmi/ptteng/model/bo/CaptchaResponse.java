package cn.mogeek.rmi.ptteng.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CaptchaMailResponse
 * @Description 邮件发送后返回状态信息的对象
 * @Author owlwinter
 * @Date 2020/7/21 16:39
 * @Version 1.0
 **/
@Data
public class CaptchaResponse implements Serializable {
    private static final long serialVersionUID = -3747567354108543390L;
//    用户联系方式
    private String contact;
//    状态
    private String status;
//    错误信息
    private String message;

    public Map getMap(){
        Map<String, String> info = new HashMap<>();
        info.put("contact", contact);
        info.put("status", status);
        info.put("message", message);
        return info;
    }
}
