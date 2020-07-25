package cn.mogeek.rmi.ptteng.server.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName SendEmail
 * @Description 发送邮件工具类
 * @Author owlwinter
 * @Date 2020/7/20 20:56
 * @Version 1.0
 **/
@Component
public class EmailUtil {
    private static final Logger LOGGER = LogManager.getLogger(EmailUtil.class);

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    public void send(String to, String subject, String templateName, Map<String, Object> info) throws MessagingException, IOException, TemplateException {
        LOGGER.info("FROM:{} TO:{} TEMPLATE:{}", from, to, templateName);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        Template template = configuration.getTemplate(templateName);
        String context = FreeMarkerTemplateUtils.processTemplateIntoString(template, info);
        helper.setText(context, true);
        mailSender.send(message);
    }
}
