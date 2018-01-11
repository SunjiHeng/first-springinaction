package mvc;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import springinaction.mvc.controller.SpitterController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
/**
 * @author HP
 * @create 2018-01-10-19:00
 */
public class SpitterControllerTest {
    @Test
    public void spitter() {
        SpitterController controller = new SpitterController ();
        MockMvc mockMvc = standaloneSetup (controller).build ();

        try {
            mockMvc.perform (get ("/spitter/register"))
                   .andExpect (view ().name ("registerForm"));
        } catch (Exception e) { }
    }

    @Test
    public void shouldProcessRegistration() {
    }
}
