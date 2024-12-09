package com.dacs.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Estados;
import com.dacs.api.model.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Métodos personalizados opcionales
    List<Ticket> findByCreadoPorId(int creado_por_id);

    List<Ticket> findByDependenciaId(int dependencia_id);

    List<Ticket> findByEstado(Estados estado);
}
