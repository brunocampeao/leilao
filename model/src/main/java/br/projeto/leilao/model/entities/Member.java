package br.projeto.leilao.model.entities;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString(includeFieldNames=true)
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) private final long id = 0L;
	private String code;
	private String name;
	@OneToMany(mappedBy = "member")
	private Set<Offer> offers = Collections.emptySet();

}