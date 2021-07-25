package pro.paullezin.telefonbuch.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.paullezin.telefonbuch.model.Person;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addPersonAndFindByName() throws Exception {
        Person newPerson = new Person(1,"New Person");

        mockMvc.perform(post("/api/persons")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newPerson)))
                .andExpect(status().is(201));

        mockMvc.perform(get("/api/persons/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(new MediaType("application", "*+json")))
                .andExpect(jsonPath("$.name", Matchers.containsString("New")));
    }
}