package org.bees.box;


import com.alibaba.fastjson.JSONObject;
import org.bees.box.controller.LoginController;
import org.bees.box.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/abx.xml")
public class ControllerTest {

    private final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Autowired
    private LoginController loginController;

    @Test
    public void validTest() throws InterruptedException {
        Student student = new Student();
        Student login = loginController.login(student);
        logger.info(JSONObject.toJSONString(login));
    }
}
