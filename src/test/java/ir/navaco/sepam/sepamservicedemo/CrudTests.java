package ir.navaco.sepam.sepamservicedemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ir.navaco.sepam.sepamservicedemo.controller.dto.BankDTO;
import ir.navaco.sepam.sepamservicedemo.model.domain.BankEntity;
import ir.navaco.sepam.sepamservicedemo.repository.BankRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.transaction.annotation.Transactional;


import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrudTests {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private MockMvc mockMvc;

    private static final URI FIND_NEAREST_FIREHOSES_QUERY_URI = URI.create("/api/rest");

    @Test
    public void crudTest() {
        BankEntity bankE = new BankEntity();
        bankE.setCode(1111L);
        bankE.setActive(true);
        bankE.setName("Bank");
        bankRepository.save(bankE);

        assertThat(bankRepository.findByCode(1111L).get().getCode())
                .isEqualTo(1111L);
    }

    @Test
    public void deleteTest() {
        final BankEntity bankE = new BankEntity();
        bankE.setCode(1113L);
        bankE.setActive(true);
        bankE.setName("Bank");
        bankRepository.save(bankE);

        assertThat(bankRepository.findByCode(1113L).get().getCode())
                .isEqualTo(1113L);

        bankRepository.delete(bankE);

        assertThat(bankRepository.findByCode(1113L))
                .isEmpty();
    }

    @Test
    public void updateTest() {
        final BankEntity bankE = new BankEntity();
        bankE.setCode(1114L);
        bankE.setActive(true);
        bankE.setName("Bank");
        bankRepository.save(bankE);

        assertThat(bankRepository.findByCode(1114L).get().getCode())
                .isEqualTo(1114L);

        bankE.setCode(1115L);

        bankRepository.save(bankE);

        assertThat(bankRepository.findByCode(1114L))
                .isEmpty();
        assertThat(bankRepository.findByCode(1115L).get().getCode())
                .isEqualTo(1115L);
    }

    @Test
    @Transactional
    public void getBankNameWhitService() throws Exception {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setName("Mostaghel");
        bankEntity.setCode(1111L);

        bankRepository.save(bankEntity);

        /*RequestBuilder req = get(FIND_NEAREST_FIREHOSES_QUERY_URI+"/{id}",1111)
               *//* .contentType(MediaType.APPLICATION_JSON) // for DTO*//*
                .content("1111");*/

        BankDTO bankDTO = new BankDTO();
        bankDTO.setName("Mostaghel");
        bankDTO.setCode(1111L);

        /*this.mockMvc.perform(get("/api/getBank/{code}", bankEntity.getCode()))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$code"));*/


    }
}
