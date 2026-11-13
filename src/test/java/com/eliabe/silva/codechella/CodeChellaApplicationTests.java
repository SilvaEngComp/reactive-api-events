package com.eliabe.silva.codechella;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.enums.TipoEvento;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CodeChellaApplicationTests {

	@Autowired private WebTestClient webTestClient;

	@Test
	void cadastraNovoEvento() {
		EventoDTO eventoDTO = new EventoDTO(null, TipoEvento.CONCERTO, "Filamônica", "Banda clássica de uma cidade", LocalDate.of(2024, 6, 15));

		webTestClient.post()
				.uri("/eventos")
				.bodyValue(eventoDTO)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(EventoDTO.class)
				.value(response -> {
					assert response.id() != null;
					assert response.tipoEvento() == TipoEvento.CONCERTO;
					assert response.nome().equals("Filamônica");
					assert response.descricao().equals("Banda clássica de uma cidade");
					assert response.data().equals(LocalDate.of(2024, 6, 15));
				});
	}

	@Test
	void consultaUmEventoExistente(){
		webTestClient.get()
				.uri("/eventos")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(EventoDTO.class)
				.value(response -> {
					assert response.size() > 0;
					EventoDTO evento = response.get(13);
					assert evento.id() != null;
					assert evento.tipoEvento() == TipoEvento.WORKSHOP;
					assert evento.nome().equals("Café com Ideias");
					assert evento.descricao().equals("Um evento que ensina técnicas de brainstorming e priorização para alavancar projetos.");
					assert evento.data().equals(LocalDate.parse("2025-01-25"));
				});
	}

}
