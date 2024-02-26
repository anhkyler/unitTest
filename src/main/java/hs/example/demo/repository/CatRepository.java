package hs.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hs.example.demo.entity.CatEntity;

@Repository
public interface CatRepository extends CrudRepository<CatEntity, Long>{

    @Query(value = "select * from cat where cat_name =?1", nativeQuery = true)
    CatEntity findCatname(String catName);
    
}
