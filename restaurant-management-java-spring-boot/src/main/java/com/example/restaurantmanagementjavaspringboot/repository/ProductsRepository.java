package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query(value = "select * from Products p order by id offset ?1 rows fetch next ?2 rows only", nativeQuery = true)
    List<Products> fetchProducts(Long startRow, Long countItem);

    @Query(value = "select p.numRow from (select rownum numRow, p.* from Products p) p where p.id=?1", nativeQuery = true)
    Long rowNumById(Long id);

    @Query(value = "select p.* from Products p where rownum=1", nativeQuery = true)
    Long firstRowId();
}
