package cn.mogeek.rmi.ptteng.service;

import cn.mogeek.rmi.ptteng.model.bo.CaptchaResponse;

public interface CaptchaService {
    CaptchaResponse sendEmail(String emailAddress);
    CaptchaResponse sendSms(String phoneNumber);
    boolean checkCaptcha(String key, String captcha);
}
