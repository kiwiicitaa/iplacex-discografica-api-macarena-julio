package org.iplacex.proyectos.discografia.discos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.iplacex.proyectos.discografia.discos.Disco;
public interface IDiscoRepository extends MongoRepository<Disco, String> {
}
