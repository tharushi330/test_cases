import edu.icet.ecom.Main;
import edu.icet.ecom.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)

public class StudentServiceTest {
    @Autowired
    CustomerService service;

    @Test
    public void testCalc(){
        assertEquals(20,service.calc(10,10));
    }

    @Test
    public void testUnitNames(){
        assertEquals("A" ,service.getNames("Nimal"));
    }

}
