package cn.mogeek.rmi.ptteng.server.util.tencent;

import cn.mogeek.rmi.ptteng.server.PttengWebServerApplication;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TencentSmsUtilTest
 * @Description 测试腾讯云短信工具类
 * @Author owlwinter
 * @Date 2020/7/21 18:51
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PttengWebServerApplication.class)
public class TencentSmsUtilTest {

    @Autowired
    private TencentSmsUtil smsUtil;

    @Before
    public void init(){
        Assert.assertNotNull("TencentSmsUtil 为空", smsUtil);
    }

    @Test
    public void testSend() throws TencentCloudSDKException {
        smsUtil.send("111111111111", "183642");
    }
}
