package ir.navaco.sepam.sepamservicedemo;

import ir.navaco.sepam.sepamservicedemo.model.domain.BranchEntity;
import ir.navaco.sepam.sepamservicedemo.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@AllArgsConstructor
public class SepamServiceDemoApplication implements CommandLineRunner {

	BranchRepository branchRepository;
	public static void main(String[] args) {
		SpringApplication.run(SepamServiceDemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		/*BranchEntity branchEntity = new BranchEntity();
		branchEntity.setAddress("gf");
		branchEntity.setCode(12L);
		branchEntity.setFax("gf");
		branchEntity.setId(1L);
		branchRepository.save(branchEntity);*/


	}
}
