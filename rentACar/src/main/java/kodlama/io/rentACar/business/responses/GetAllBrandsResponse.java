package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {//request apiye gönderilen data response ise bizim ona verdiğimiz yanıt
    private int id;
    private  String name;
}
/*
  Brand --> id,name,quantity
  GetAllBrandsResponse--> id,name
  buna maping denir
 */
