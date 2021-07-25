package pro.paullezin.telefonbuch.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.paullezin.telefonbuch.model.Phone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PhoneRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    void addPhoneAndFindByNumber() throws Exception {

        mockMvc.perform(post("/api/phones")
                .contentType("application/json")
                .content("{\"code\":7,\"number\":\"123456789\",\"person\":\"http://localhost/api/persons/2\"}"))
                .andExpect(status().is(201));

        mockMvc.perform(get("/api/phones/search/by-number?number=123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(new MediaType("application", "*+json")));

        Phone createdPhone = phoneRepository.findPhoneByNumberContains("4567").get(0);
        assertThat(createdPhone.getNumber()).isEqualTo("123456789");
    }
}