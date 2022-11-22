package fooddelivery.common;


import fooddelivery.AlarmApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { AlarmApplication.class })
public class CucumberSpingConfiguration {
    
}
