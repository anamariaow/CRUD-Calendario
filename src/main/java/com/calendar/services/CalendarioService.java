package com.calendar.services;

import com.calendar.entities.Calendario;
import com.calendar.repositories.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {
    @Autowired
    private CalendarioRepository calendarioRepository;

    public Calendario addCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> getListaCalendario() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getCalendarioById(Long id) {
        return calendarioRepository.findById(id);
    }

    public Optional<Calendario> updateCalendario(Long id, Calendario calendario) {
        Optional<Calendario> calendarioOpt = calendarioRepository.findById(id);
        Calendario calendarioUpdate;
        if (calendarioOpt.isPresent()) {
            calendarioOpt.get().setName(calendario.getName());
            calendarioOpt.get().setDescrizione(calendario.getDescrizione());
            calendarioUpdate = calendarioRepository.save(calendarioOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(calendarioUpdate);
    }

    public Optional<Calendario> deleteCalendarioById(Long id) {
        Optional<Calendario> calendarioOpt = calendarioRepository.findById(id);
        if(calendarioOpt.isPresent()) {
            calendarioRepository.delete(calendarioOpt.get());
            return calendarioOpt;
        } else {
            return Optional.empty();
        }
    }
}
