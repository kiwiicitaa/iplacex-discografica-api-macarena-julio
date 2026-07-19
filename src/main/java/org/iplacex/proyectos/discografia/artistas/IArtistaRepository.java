package org.iplacex.proyectos.discografia.artistas;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.iplacex.proyectos.discografia.artistas.Artista;

public interface IArtistaRepository extends MongoRepository<Artista, String> {
}
