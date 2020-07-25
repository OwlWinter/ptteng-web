package cn.mogeek.rmi.ptteng.server.util.tencent;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TencentSmsUtil
 * @Description 腾讯云短信工具类
 * @Author owlwinter
 * @Date 2020/7/21 17:35
 * @Version 1.0
 **/
@Component
public class TencentSmsUtil {
    private static final Logger LOGGER = LogManager.getLogger(TencentSmsUtil.class);

    @Autowired
    private TencentSmsSource smsSource;

    public String send(String phoneNumber, String captcha) throws TencentCloudSDKException {
        System.out.println(smsSource);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(smsSource.getEndpoint());

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        SmsClient client = new SmsClient(smsSource.getCredential(), smsSource.getRegion(), clientProfile);

        String params = "{\"PhoneNumberSet\":[\"+86" + phoneNumber +
                "\"],\"TemplateID\":\"" + smsSource.getTemplateId() +
                "\",\"Sign\":\"" + smsSource.getSign() +
                "\",\"TemplateParamSet\":[\"" + captcha +
                "\"],\"SmsSdkAppid\":\"" + smsSource.getSdkAppid() + "\"}";
        SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);

        LOGGER.info("发送参数: {}", params);

        SendSmsResponse resp = client.SendSms(req);

        LOGGER.info("验证码发送成功! phoneNumber:{} code:{}", phoneNumber, captcha);

        return SendSmsRequest.toJsonString(resp);
    }
}
