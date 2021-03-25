package br.projeto.leilao.tests.app.util;

import static java.util.Collections.emptyList;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.assertj.core.util.Strings;

import com.google.common.collect.ImmutableList;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DataUtils {

	public static List<String> product(List<String> a, List<String> b) {
		List<String> list = of(a.stream()
                .map(e1 -> of(b.stream()
                		.map(e2 -> Strings.concat(e1, " ", e2))
                		.collect(toList()))
                		.orElse(emptyList()))
                .flatMap(List::stream)
                .collect(toList()))
        		.orElse(emptyList());
		return list;
    }

	public static List<String> memberNames() {
		log.debug("Gerando massa de dados para teste");
		log.debug("Gerando massa de nomes");
		List<String> names = ImmutableList
		.<String>builder()
			.add("Henrique")
			.add("Maria")
			.add("Cesar")
			.add("Cintia")
		.build();
		log.debug("Gerando massa de sobrenomes");
		List<String> lastNames = ImmutableList
		.<String>builder()
			.add("Souza")
			.add("Rodrigues")
			.add("Ferreira")
			.add("Alves")
		.build();
		log.debug("Combinando nomes");
		List<String> fullNames = DataUtils.product(names, lastNames);
		log.debug("Carregando dados dos membros");
		return fullNames;
	}

}
