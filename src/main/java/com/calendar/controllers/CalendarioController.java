package com.calendar.controllers;

import com.calendar.entities.Calendario;
import com.calendar.entities.Evento;
import com.calendar.services.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @PostMapping("/create")
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario) {
        return ResponseEntity.ok(calendarioService.addCalendario(calendario));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Calendario>> findAllCalendario() {
        return ResponseEntity.ok(calendarioService.getListaCalendario());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Calendario>> findByIdCalendario(@RequestParam Long id) {
        Optional<Calendario> calendarioOpt = calendarioService.getCalendarioById(id);
        if (calendarioOpt.isPresent()) {
            return ResponseEntity.ok(calendarioOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Calendario> modifyCalendario(@PathVariable Long id, @RequestBody Calendario calendario) {
        Optional<Calendario> calendarioOpt = calendarioService.updateCalendario(id, calendario);
        if (calendarioOpt.isPresent()) {
            return ResponseEntity.ok(calendarioOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Calendario> deleteCalendario(Long id) {
        Optional<Calendario> calendarioOpt = calendarioService.deleteCalendarioById(id);
        if (calendarioOpt.isPresent()) {
            return ResponseEntity.ok(calendarioOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
