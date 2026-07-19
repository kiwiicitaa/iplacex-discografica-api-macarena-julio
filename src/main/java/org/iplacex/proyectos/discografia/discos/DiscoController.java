package org.iplacex.discografia.discos;
package org.iplacex.proyectos.discografia.discos;

import org.iplacex.proyectos.discografia.discos.Disco;
import org.iplacex.proyectos.discografia.discos.IDiscoRepository;

import org.iplacex.discografia.artistas.IArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DiscoController {

    @Autowired
    private IDiscoRepository discoRepository;

    @Autowired
    private IArtistaRepository artistaRepository;

    @PostMapping("/disco")
    public ResponseEntity<Object> HandlePostDiscoRequest(@RequestBody Disco disco) {
        if (!artistaRepository.existsById(disco.idArtista)) {
            return new ResponseEntity<>("Artista no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discoRepository.insert(disco), HttpStatus.CREATED);
    }

    @GetMapping("/artista/{id}/discos")
    public ResponseEntity<List<Disco>> HandleGetDiscosByArtistaRequest(@PathVariable("id") String id) {
        return new ResponseEntity<>(discoRepository.findDiscosByIdArtista(id), HttpStatus.OK);
    }
}
