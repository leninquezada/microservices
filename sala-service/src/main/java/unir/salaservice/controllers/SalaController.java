package unir.salaservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unir.salaservice.model.dto.SalaRequest;
import unir.salaservice.model.dto.SalaResponse;
import unir.salaservice.model.entities.Sala;
import unir.salaservice.servicies.ISalaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaController {
    @Qualifier("ISalaService")
    private final ISalaService service;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Sala> getById (@PathVariable Integer id){
        return this.service.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> remove(@PathVariable Integer id){
        boolean Ok = this.service.remove(id);
        String response;
        if (Ok){
            response = "Movie con Id " + id + " eliminado exitosamente";
        }else{
            response = "Error al eliminar Movie con id " + id;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("Respuesta", response);
        return map;
    }

    @PostMapping(path = "/sala")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object>  save(@RequestBody SalaRequest salaRequest){
        boolean response = false;
        boolean Ok = this.service.addSala(salaRequest);
        if(Ok)
        {
            response = true;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("Respuesta", response);
        return map;
    }

    @GetMapping(path = "/salas")
    @ResponseStatus(HttpStatus.OK)
    public List<SalaResponse> getAllSalas(){
        return this.service.getAllSalas();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sala updateProduct(@PathVariable Integer id, @RequestBody Sala sala) {
        return service.updateProduct(id, sala);
    }
}
