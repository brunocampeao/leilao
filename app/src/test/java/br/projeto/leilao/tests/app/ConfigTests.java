package br.projeto.leilao.tests.app;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.ImmutableList;

import br.projeto.leilao.model.entities.Member;
import br.projeto.leilao.services.repos.MemberRepo;
import br.projeto.leilao.tests.app.util.DataUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigTests {

	public void loadData(@Autowired MemberRepo repo) {
		List<String> fullNames = DataUtils.memberNames();
		fullNames.forEach(n -> repo.save(
				Member
				.builder()
					.code(RandomStringUtils.random(8))
					.name(n)
				.build()));
		log.debug("Buscando membros na tabela");
		List<Member> members = repo.findAll();
		members.forEach(m -> log.info("Usuário {} cadastrado com o código {}", m.getName(), m.getCode()));
		log.debug("");
	}


}
