package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //annotation
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<GetAllBrandsResponse>getAll(){
        return brandService.getAll();
    };

    @PostMapping("/add")
    public void add(CrateBrandRequest crateBrandRequest){
        this.brandService.add(crateBrandRequest);
    }
}
