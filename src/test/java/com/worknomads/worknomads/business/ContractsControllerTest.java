package com.worknomads.worknomads.business;

import com.worknomads.worknomads.controllers.business.ContractsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContractsController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ContractsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private String CREATE_CONTRACT_REQUEST_STRING = "{\n" +
            "\t\"employeeName\": \"panos\",\n" +
            "  \t\"employeeSur\": \"mavr\",\n" +
            "  \t\"address\": \"some\",\n" +
            "  \t\"countryOfResidence\": \"GR\",\n" +
            "  \t\"email\": \"panamavr@hotmail.com\",\n" +
            "  \t\"phoneNum\": \"+447478259681\",\n" +
            "  \t\"companyWalletAddress\": \"0xca0fc0957f148497f9e2ce6ed104a550c04d9374\",\n" +
            "  \t\"employeeWalletAddress\": \"0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65\",\n" +
            "  \t\"contractDetails\": {\n" +
            "    \t\"contractExpiry\": \"2016-06-23T09:07:21Z\",\n" +
            "      \t\"grossSalary\": 2000.0,\n" +
            "      \t\"remoteLocation\": \"GR\",\n" +
            "      \t\"paymentInstallments\": 10,\n" +
            "      \t\"paymentTerm\": \"MONTHLY\",\n" +
            "      \t\"balanceUnit\": \"USD_TETHER\"\n" +
            "    }\n" +
            "}";

//    @Test
//    public void creatingAContract_shouldReturnAcknowledgment() throws Exception {
//        mockMvc.perform(post("/app/v1/{companyId}/contracts/create")
//        .contentType(MediaType.APPLICATION_JSON).content(CREATE_CONTRACT_REQUEST_STRING)).andExpect(status().isOk());
//    }
}
