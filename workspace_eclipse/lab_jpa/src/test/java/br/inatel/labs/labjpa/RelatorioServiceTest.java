package br.inatel.labs.labjpa;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.service.RelatorioService;

@SpringBootTest
public class RelatorioServiceTest {
	
	@Autowired
	private RelatorioService service;
	
	@Test
	public void test() {
		List<TotalCompradoPorFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPorFornecedor();
		
		assertFalse(listaDTO.isEmpty());
		
		listaDTO.forEach(System.out::println);
	}

}
