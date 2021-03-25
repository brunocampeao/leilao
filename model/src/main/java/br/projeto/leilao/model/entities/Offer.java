package br.projeto.leilao.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
@ToString(includeFieldNames = true)
public class Offer {

	@EmbeddedId
	private OfferKey id;
	@ManyToOne
	@MapsId("memberId")
	@JoinColumn(name = "member_id")
	private Member member;
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	@Column(name="Offer", precision=16, scale=2)
    private BigDecimal offer;

}
