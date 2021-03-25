package br.projeto.leilao.tests.app;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.projeto.leilao.app.Main;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
public class MainTests {

	public static void main(String[] args) {
		log.info("Iniciando aplicação de teste");
	}
}
