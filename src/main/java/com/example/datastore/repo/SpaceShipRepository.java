package com.example.datastore.repo;

import com.example.datastore.model.SpaceShip;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SpaceShipRepository extends DatastoreRepository<SpaceShip, Long> {

    @Query("select * from |com.example.datastore.model.SpaceShip| where model = @model")
    List<SpaceShip> findByModel(@Param("model") String model);

    @Query("select * from |com.example.datastore.model.SpaceShip| where captain = @captain")
    List<SpaceShip> findByCaptain(String captain);

    List<SpaceShip> findByFuelGreaterThan(Integer fuel);

    @Query("select * from |com.example.datastore.model.SpaceShip|")
    Slice<SpaceShip> findAllSlice(Pageable pageable);
}