package com.example.webservice.repository;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    @Query("SELECT c FROM Computer c WHERE screenResolution LIKE %?1%")
    public List<Computer> getComputersByScreenResolution(String screenResolution);

    @Query("SELECT c FROM Computer c WHERE storageCapacity LIKE %?1%")
    public List<Computer> getComputersByStorageCapacity(String storageCapacity);

    @Query("SELECT c FROM Computer c WHERE memory LIKE %?1%")
    public List<Computer> getComputersByMemory(String memory);

    @Query("SELECT c FROM Computer c WHERE processor LIKE %?1%")
    List<Computer> getComputersByProcessor(String processor);

    @Query("SELECT c FROM Computer c WHERE model LIKE %?1%")
    List<Computer> getComputerByModel(String model);

    @Query("SELECT c FROM Computer c WHERE price LIKE ?1")
    List<Computer> getComputerByPrice(int price);

    @Query("SELECT c FROM Computer c WHERE label LIKE %?1%")
    List<Computer> getComputerByLabel(String label);

    @Query("SELECT c FROM Computer c WHERE screensize LIKE ?1")
    List<Computer> getComputerByScreensize(int screensize);

    @Query("SELECT c FROM Computer c INNER JOIN Brand b ON c.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    List<Computer> getComputersByBrand(String name);

    @Query("SELECT c FROM Computer c INNER JOIN CommentAndRate cr ON c.product_id = cr.comment_id WHERE cr.comment LIKE %?1%")
    List<Computer> getComputersByComment(String comment);

    @Query("SELECT c FROM Computer c INNER JOIN CommentAndRate cr ON c.product_id = cr.comment_id WHERE cr.rate LIKE ?1")
    List<Computer> getComputersByRate(int rate);

    @Query("SELECT c FROM Computer c INNER JOIN AdditionalFeatures f ON c.product_id = f.afs_id WHERE f.afs_name LIKE %?1%")
    List<Computer> getComputersByAdditionalFeature(String additionalfeature);

}
