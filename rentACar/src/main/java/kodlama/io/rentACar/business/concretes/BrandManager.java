package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.dataAcces.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service//bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    //@Autowired
    //public BrandManager(BrandRepository brandRepository) {this.brandRepository = brandRepository;}


    @Override
    public List<GetAllBrandsResponse> getAll() {//mapping

        List<Brand> brands=brandRepository.findAll();

      /* List<GetAllBrandsResponse> brandsResponse=new ArrayList<>();
        for (Brand brand:brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getIsim());
            brandsResponse.add(responseItem);
        }*/
        List<GetAllBrandsResponse> brandsResponse=brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                .map(brand,GetAllBrandsResponse.class))
                .collect(Collectors.toList());
                //yukarıdaki for'un yaptığını yapar


        return brandsResponse;
    }


    @Override
    public void add(CrateBrandRequest creatBrandRequest) {
        //Brand brand=new Brand();
        //brand.setIsim(creatBrandRequest.getName()); bunun yerine
        Brand brand=this.modelMapperService.forRequest().map(creatBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response =this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
