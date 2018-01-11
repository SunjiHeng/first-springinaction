package mvc;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import springinaction.mvc.controller.HomeController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author HP
 * @create 2018-01-09-13:45
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController con = new HomeController ();

        MockMvc moc = standaloneSetup (con).build ();
        moc.perform (get ("/test")).andExpect (view ().name ("home"));

    }
}
