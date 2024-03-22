package com.calendar.services;

import com.calendar.entities.Evento;
import com.calendar.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento addEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> getEventi() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEvento(Long id) {
        return eventoRepository.findById(id);
    }

    public Optional<Evento> updateEvento(Long id, Evento evento) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        Evento eventoUpdate;
        if (eventoOptional.isPresent()) {
            eventoOptional.get().setName(evento.getName());
            eventoOptional.get().setDescrizione(evento.getDescrizione());
            eventoOptional.get().setDataInizio(evento.getDataInizio());
            eventoOptional.get().setDataFine(evento.getDataFine());
            eventoUpdate = eventoRepository.save(eventoOptional.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(eventoUpdate);
    }

    public Optional<Evento> deleteEventiById(Long id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        if(eventoOptional.isPresent()) {
            eventoRepository.delete(eventoOptional.get());
            return eventoOptional;
        } else {
            return Optional.empty();
        }
        //return eventoOptional;
    }

//    public void Optional<Evento> delete (Long id) {
//        eventoRepository.deleteById(id);
//    }
}
