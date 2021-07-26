package java.com.worknomads.worknomads.business;

import com.worknomads.worknomads.controllers.business.ContractsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContractsController.class)
public class ContractsControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void creatingAContract_shouldReturnAcknowledgment() throws Exception {
        mockMvc.perform(post("/app/v1/{companyId}/contracts/create")).andExpect(status().isOk());
    }
}
