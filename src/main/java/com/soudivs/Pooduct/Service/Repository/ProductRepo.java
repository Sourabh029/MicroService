package com.soudivs.Pooduct.Service.Repository;

import com.soudivs.Pooduct.Service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {


}
