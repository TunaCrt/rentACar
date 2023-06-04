package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CrateBrandRequest creatBrandRequest);
}
