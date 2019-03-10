package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Modifying
    @Transactional
    @Query("update Consulta c set c.status = 'ATRASADA' where c.horario < ?1 and c.status in ('MARCADA', 'REMARCADA')")
    void atualizarStatusConsultasAtrasadas(LocalDateTime horarioAtual);
}
