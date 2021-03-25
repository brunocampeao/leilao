package br.projeto.leilao.model.entities;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import io.vavr.collection.HashSet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String name;
	private Long options;
	@Column(name = "start_date")
	private Date start;
	@Column(name = "end_date")
	private Date end;
	private Byte state;
	@Column(name = "max_offers")
	private Integer maxOffers;
	@OneToMany(mappedBy = "item")
	private Set<Offer> offers = Collections.emptySet();

}
