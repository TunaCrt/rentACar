package kodlama.io.rentACar.dataAcces.abstracts;

import kodlama.io.rentACar.Entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.stereotype.Repository;
import java.util.List;*/


public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
