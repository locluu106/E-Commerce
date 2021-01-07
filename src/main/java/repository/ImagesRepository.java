package repository;

import entity.ImagesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImagesRepository extends CrudRepository<ImagesEntity, Integer> {

    ImagesEntity findByImagesId(int imagesId);
    

    //List<ImagesEntity> getListImagesByProductDetailsId(int productDetailsId);

    @Query(value = "SELECT * FROM fashiondb.images ORDER BY imagesId DESC limit ?1,?2", nativeQuery = true)
    List<ImagesEntity> getAllImages(int pageImagesId, int limitImages);

    @Query(value = "SELECT * FROM fashiondb.images ORDER BY imagesId DESC limit 10", nativeQuery = true)
    List<ImagesEntity> getAllImages1();

    @Query(value = "select count(*) from images", nativeQuery = true)
    int getCountImages();
}
