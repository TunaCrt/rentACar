package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CrateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse>getAll(){
        return brandService.getAll();
    };

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);}

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }




    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CrateBrandRequest crateBrandRequest){
        this.brandService.add(crateBrandRequest);
    }
}
