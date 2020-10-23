package com.example.demo8.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ThreeTenBackPortConverters;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String model;
    Integer price;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Tire> tireList;

    //need to override to make @OneToMany to work correctly
    @Override
    public String toString() {
        return String.format("id: %d, model: %s, price: %d", id, model, price);
    }
}
