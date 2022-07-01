package com.example.datastore.repo;

import com.example.datastore.model.SpaceShip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SpaceShipRepositoryTest {
    @Autowired
    SpaceShipRepository spaceShipRepository;

    @Test
    public void spaceship() {
        System.out.println("test begin");
        spaceShipRepository.deleteAll();
        spaceShipRepository.save(new SpaceShip(null, "pyramid", "mike", 22, LocalDateTime.now()));
        spaceShipRepository.save(new SpaceShip(null, "pyramid", "john", 52, LocalDateTime.now()));
        spaceShipRepository.save(new SpaceShip(null, "ball", "susan", 72, LocalDateTime.now()));
        spaceShipRepository.save(new SpaceShip(null, "ball", "Vivian", 62, LocalDateTime.now()));
        spaceShipRepository.save(new SpaceShip(null, "box", "Charlotte", 31, LocalDateTime.now()));
        Iterable<SpaceShip> all = spaceShipRepository.findAll();
        System.out.println("All ships comes here!! ----");
        for (SpaceShip spaceShip : all) {
            System.out.println("Found: " + spaceShip);
        }

        System.out.println("Pyramid ships comes here!! ----");
        List<SpaceShip> pyramid = spaceShipRepository.findByModel("pyramid");
        for (SpaceShip spaceShip : pyramid) {
            System.out.println("pyramid: " + spaceShip);
        }

        System.out.println("Captain mike!! ----");
        List<SpaceShip> caps = spaceShipRepository.findByCaptain("mike");
        for (SpaceShip spaceShip : caps) {
            System.out.println("captain: " + spaceShip);
        }

        System.out.println("Fuel > 50 here!! ----");
        List<SpaceShip> fuels = spaceShipRepository.findByFuelGreaterThan(50);
        for (SpaceShip spaceShip : fuels) {
            System.out.println("fuel: " + spaceShip);
        }

        Pageable page = PageRequest.of(0, 3);
        Slice<SpaceShip> slices = spaceShipRepository.findAllSlice(page);
        System.out.println("All ships comes slices!! ----");
        for (SpaceShip spaceShip : slices) {
            System.out.println("Found: " + spaceShip);
        }
        System.out.println("getNumberOfElements: " + slices.getNumberOfElements());
        System.out.println("getNumber: " + slices.getNumber());
        System.out.println("hasNext: " + slices.hasNext());
        System.out.println("hasNext: " + slices.hasPrevious());

        System.out.println("test end");
    }
}