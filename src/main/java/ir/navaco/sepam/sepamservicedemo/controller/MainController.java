package ir.navaco.sepam.sepamservicedemo.controller;

import ir.navaco.sepam.sepamservicedemo.controller.dto.BankDTO;
import ir.navaco.sepam.sepamservicedemo.controller.dto.LoanDTO;
import ir.navaco.sepam.sepamservicedemo.model.domain.BankEntity;
import ir.navaco.sepam.sepamservicedemo.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MainController {

    private BankService bankService;

    private RestTemplate restTemplate;


    @GetMapping("/getBank/{code}")
    public String getBank(@PathVariable Long code) {
        BankEntity bank = bankService.getBank(code);
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setLoanCode(1L);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <LoanDTO> entity = new HttpEntity<LoanDTO>(loanDTO,headers);

        /*Long loanCode = restTemplate.getForObject("http://10.12.46.70:8080/api/v1/loan/getLoanId",
                Long.class,
                loanDTO);
        System.out.println("DDDDDDDDDDDDDDD: " + loanCode);*/
        Long body = restTemplate.exchange("http://10.12.46.70:8080/api/v1/loan/getLoanId",
                HttpMethod.POST, entity, Long.class).getBody();
        System.out.println("DDDDDDDDDDDDDDD: " + body);
        return bank.getName();
    }

    private BankDTO setBank(BankEntity bank) {
        BankDTO bankDTO = new BankDTO();
        bankDTO.setCode(bank.getCode());
        bankDTO.setName(bank.getName());
        bankDTO.setId(bank.getId());
        return bankDTO;
    }
}
