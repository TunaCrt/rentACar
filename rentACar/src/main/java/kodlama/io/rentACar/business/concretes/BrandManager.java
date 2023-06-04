package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAcces.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;
import java.util.ArrayList;
import java.util.List;

@Service//bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<GetAllBrandsResponse> getAll() {//mapping
        List<Brand> brands=brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse=new ArrayList<>();
        for (Brand brand:brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getIsim());
            brandsResponse.add(responseItem);
        }
        return brandsResponse;
    }

    @Override
    public void add(CrateBrandRequest creatBrandRequest) {
        Brand brand=new Brand();
        brand.setIsim(creatBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
