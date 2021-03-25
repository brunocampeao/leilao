package br.projeto.leilao.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.leilao.model.entities.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
	
}
