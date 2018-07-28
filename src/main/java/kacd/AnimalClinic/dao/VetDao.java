package kacd.AnimalClinic.dao;

import kacd.AnimalClinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetDao extends CrudRepository<Vet,Integer> {

}
