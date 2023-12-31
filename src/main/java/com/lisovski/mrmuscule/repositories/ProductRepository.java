package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value="SELECT * FROM products WHERE type = cast(:type as product_type) LIMIT :limit OFFSET :offset",nativeQuery = true)
    List<Product> getProductsByCategory(@Param(value = "type") String productType,
                                        @Param(value = "limit") int limit,
                                        @Param(value = "offset") int offset);
}
