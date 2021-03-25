package br.projeto.leilao.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.leilao.model.entities.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {
	
}
