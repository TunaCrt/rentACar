package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);
    void add(CrateBrandRequest creatBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);


}
