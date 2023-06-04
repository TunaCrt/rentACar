package kodlama.io.rentACar.Entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Table(name="brands")
@Data//veya @Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Colmn(name="id")
    private int id;
    //@Colmn(name="isim")
    private String isim;
}
    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Brand() {

    }
    public Brand(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }*/
