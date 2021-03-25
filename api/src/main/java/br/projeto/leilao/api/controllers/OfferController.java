package br.projeto.leilao.api.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.projeto.leilao.model.entities.Offer;
import br.projeto.leilao.services.repos.OfferRepo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/api/offer")
public class OfferController {

	@Autowired
	OfferRepo offerRepo;
	@Autowired
	ObjectMapper mapper;

	@RequestMapping(
			method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
			produces = {MediaType.APPLICATION_JSON_VALUE},
			path = "/teste")
	@ResponseBody
	public String index() {
		ObjectNode ob = mapper.createObjectNode();
		log.debug("Lance recebido");

		Offer offer = Offer
				.builder()
					.offer(new BigDecimal(10))
				.build();
		offerRepo.save(offer);
		log.trace("Fim da requisicao:\n\t {}", offer);
		log.debug("Finalizando recebimento do lance");
		return "";
	}
}