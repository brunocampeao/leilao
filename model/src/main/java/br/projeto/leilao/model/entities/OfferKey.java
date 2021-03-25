package br.projeto.leilao.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class OfferKey  implements Serializable {

	@Column(name = "item_id")
	private Long itemId;
	@Column(name = "member_id")
	private Long memberId;

}
