package cn.mogeek.rmi.ptteng.server.util.tencent;

import com.tencentcloudapi.common.Credential;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName TencentSmsSource
 * @Description 腾讯云短信配置类
 * @Author owlwinter
 * @Date 2020/7/21 17:59
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties("sdk.tencent.sms")
public class TencentSmsSource {

    private String secretid;
    private String secretkey;

    /**短信模板 id*/
    private String templateId;
    /**短信签名*/
    private String sign;
    /**短信服务区*/
    private String region;
    private String endpoint;
    private String sdkAppid;

    /**返回一个权限类*/
    public Credential getCredential(){
        Credential credential = new Credential(secretid, secretkey);
        return credential;
    }

}
