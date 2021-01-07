
package repository;

import entity.ColorEntity;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<ColorEntity, Integer>{
    ColorEntity findByColorId(int colorId);
}
