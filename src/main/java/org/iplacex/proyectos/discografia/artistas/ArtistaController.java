package org.iplacex.discografia.artistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArtistaController {

    @Autowired
    private IArtistaRepository artistaRepository;

    @PostMapping("/artista")
    public ResponseEntity<Artista> HandleInsertArtistaRequest(@RequestBody Artista artista) {
        return new ResponseEntity<>(artistaRepository.insert(artista), HttpStatus.CREATED);
    }

    @GetMapping("/artistas")
    public ResponseEntity<List<Artista>> HandleGetAristasRequest() {
        return new ResponseEntity<>(artistaRepository.findAll(), HttpStatus.OK);
    }
}