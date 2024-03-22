package com.calendar.controllers;

import com.calendar.entities.Evento;
import com.calendar.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping("/createevento")
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.addEvento(evento));
    }

    @GetMapping("/allevento")
    public ResponseEntity<List<Evento>> findAllEvento() {
        return ResponseEntity.ok(eventoService.getEventi());
    }

    @GetMapping("/findevento/{id}")
    public ResponseEntity<Optional<Evento>> findByIdEvento(@RequestParam Long id) {
        Optional<Evento> eventoOpt = eventoService.getEvento(id);
        if (eventoOpt.isPresent()) {
            return ResponseEntity.ok(eventoOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateevento")
    public ResponseEntity<Evento> modifyEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Optional<Evento> foundEventOpt = eventoService.updateEvento(id, evento);
        if (foundEventOpt.isPresent()) {
            return ResponseEntity.ok(foundEventOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteevento")
    public ResponseEntity<Evento> deleteEvento(Long id) {
        Optional<Evento> foundEventOpt = eventoService.deleteEventiById(id);
        if (foundEventOpt.isPresent()) {
            return ResponseEntity.ok(foundEventOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
