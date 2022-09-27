package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@Entity
@Table(name="product_category")
// @Data -- known bug
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private Set<Product> products;

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + "]";
	}
    
    

}







