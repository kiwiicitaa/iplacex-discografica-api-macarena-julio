package org.iplacex.proyectos.discografia.discos;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.iplacex.proyectos.discografia.discos.Disco;

public interface IDiscoRepository extends MongoRepository<Disco, String> {
    
    public List<Disco> findDiscosByIdArtista(String idArtista);
    
}
