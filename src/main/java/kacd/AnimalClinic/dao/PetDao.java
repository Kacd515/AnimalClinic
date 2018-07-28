package kacd.AnimalClinic.dao;

import kacd.AnimalClinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetDao extends CrudRepository<Pet, Integer> {
}
