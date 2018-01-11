package mvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import springinaction.mvc.basic.Spittle;
import springinaction.mvc.controller.SpittleController;
import springinaction.mvc.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HP
 * @create 2018-01-10-11:55
 */
public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList (20);

        SpittleRepository mockRespository = mock (SpittleRepository.class);
        when (mockRespository.findSpittle (Long.MAX_VALUE, 20))
                .thenReturn (expectedSpittles);
        SpittleController controller =
                new SpittleController (mockRespository);
        MockMvc mockMvc = standaloneSetup (controller)
                .setSingleView (new InternalResourceView ("/WEB-INF/views/spittle.jsp"))
                .build ();
        mockMvc.perform (get ("/spittle"))
               .andExpect (view ().name ("spittle"))
               .andExpect (model ().attributeExists ("spittleList"))
               .andExpect (model ().attribute ("spittleList",
                       hasItems (expectedSpittles.toArray ())));
    }

    private List<Spittle> createSpittleList(int count) {
        ArrayList<Spittle> spittles = new ArrayList<> ();
        for (int i = 0; i < count; i++) {
            spittles.add (new Spittle ("spittle" + i, new Date ()));
        }
        return spittles;
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList (50);
        SpittleRepository mockRespisitory = mock (SpittleRepository.class);

        when (mockRespisitory.findSpittle (238900, 50))
                .thenReturn (expectedSpittles);
        SpittleController controller =
                new SpittleController (mockRespisitory);
        MockMvc mockMvc = standaloneSetup (controller)
                .setSingleView (new InternalResourceView ("/WEB-INF/views/spittle.jsp"))
                .build ();

        mockMvc.perform (get ("/spittle?max=238900&count=50"))
               .andExpect (view ().name ("spittle"))
               .andExpect (model ().attributeExists ("spittleList"))
               .andExpect (model ().attribute ("spittleList",
                       hasItems(expectedSpittles.toArray ())));
    }
}
