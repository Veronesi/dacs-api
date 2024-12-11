package com.dacs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import com.dacs.api.dto.EstadoDTO;
import com.dacs.api.dto.TicketDTO;
import com.dacs.api.model.entity.Dependencia;
import com.dacs.api.model.entity.Estado;
import com.dacs.api.model.entity.Estados;
import com.dacs.api.model.entity.Prioridad;
import com.dacs.api.model.entity.Ticket;
import com.dacs.api.model.repository.DependenciaRepository;
import com.dacs.api.model.repository.EstadoRepository;
import com.dacs.api.model.repository.PrioridadRepository;
import com.dacs.api.model.repository.TicketRepository;
import com.dacs.api.model.entity.Usuario;
import com.dacs.api.model.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Autowired
    private PrioridadRepository prioridadRepository;

    @GetMapping("/ticket")
    public List<Ticket> obtenerTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/ticket/dependencia/{id}")
    public List<Ticket> obtenerTicketsPorDependencia(@PathVariable Integer id) {
        return ticketRepository.findByDependenciaId(id);
    }

    @GetMapping("/ticket/estado/{estado}")
    public List<Ticket> obtenerTicketsPorEstado(@PathVariable Estados estado) {
        return ticketRepository.findByEstado(estado);
    }

    @GetMapping("/my-ticket")
    @PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
    public List<Ticket> obtenerMisTickets(Authentication authentication) {
        // buscamos al usuario
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaim("sub"); // Obtener el ID del usuario (sub)

        Usuario creadoPor = usuarioRepository.findByUuid(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return ticketRepository.findByCreadoPorId(creadoPor.getId());
    }

    @PostMapping("/ticket/state")
    @PreAuthorize("hasRole('admin_client')")
    public Estado actualizarEstadoTicket(Authentication authentication, @RequestBody EstadoDTO estadoDTO) {
        // buscamos al usuario
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaim("sub"); // Obtener el ID del usuario (sub)

        Usuario autor = usuarioRepository.findByUuid(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ticket ticket = ticketRepository.findById(estadoDTO.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado: " + estadoDTO.getTicketId()));

        Estado estado = new Estado();
        estado.setAutor(autor);
        estado.setTicket(ticket);
        estado.setEstado(estadoDTO.getEstado());
        estado.setFecha(new Date());
        estadoRepository.save(estado);

        ticket.setEstado(estadoDTO.getEstado());

        ticketRepository.save(ticket);

        return estado;
    }

    @GetMapping("/ticket/{id}")
    public Optional<Ticket> obtenerTicket(@PathVariable Integer id) {
        return ticketRepository.findById(id);
    }

    @PostMapping("/ticket")
    @PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
    public ResponseEntity<Ticket> crearTicket(Authentication authentication, @RequestBody TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setDescripcion(ticketDTO.getDescripcion());
        ticket.setLatitud(ticketDTO.getLatitud());
        ticket.setLongitud(ticketDTO.getLongitud());
        ticket.setCostoFinal((float) 0);
        ticket.setFechaHora(new Date()); // Asignar fecha actual

        // buscamos al usuario
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaim("sub"); // Obtener el ID del usuario (sub)

        Usuario creadoPor = usuarioRepository.findByUuid(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ticket.setCreadoPor(creadoPor);

        Dependencia dependencia = dependenciaRepository.findById(ticketDTO.getDependenciaId())
                .orElseThrow(() -> new RuntimeException("Dependencia no encontrada"));
        ticket.setDependencia(dependencia);

        Prioridad prioridad = prioridadRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));

        Estado estado = new Estado();

        ticket.setEstado(Estados.EN_REVISION);

        ticket.setPrioridad(prioridad);

        // Guardar el ticket
        Ticket nuevoTicket = ticketRepository.save(ticket);

        estado.setAutor(creadoPor);
        estado.setTicket(ticket);
        estado.setEstado(Estados.EN_REVISION);
        estado.setFecha(new Date());
        estadoRepository.save(estado);

        return ResponseEntity.ok(nuevoTicket);
    }

}