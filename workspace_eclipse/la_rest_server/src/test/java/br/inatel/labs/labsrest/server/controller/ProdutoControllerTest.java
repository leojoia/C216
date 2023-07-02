package br.inatel.labs.labsrest.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.labsrest.server.model.Produto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProdutoControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void deveListarProdutos() {
		webTestClient
			.get()
			.uri("/produto")
			.exchange()
			.expectStatus()
				.isOk()
			.expectBody()
				.returnResult()
			;
	}
	
	@Test
	void dadoProdutoIdValido() {
		Long produtoIdValido = 1L;
		
		Produto produtorespondido = webTestClient.get()
				.uri("produto/"+produtoIdValido)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Produto.class)
					.returnResult()
					.getResponseBody();
		assertNotNull(produtorespondido);
		assertEquals(produtorespondido.getId(), produtoIdValido);
	}
	
	@Test
	void dadoProdutoIdInvalido() {
		Long idInvalido = 99L;
		
		webTestClient
			.get()
			.uri("/produto/"+ idInvalido)
			.exchange()
			.expectStatus()
				.isNotFound();
	}
}
