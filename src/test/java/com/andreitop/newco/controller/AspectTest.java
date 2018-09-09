package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AspectTest {
    @Autowired
    private TripRepository tripRepository;

    private TripDto tripDto;

    @Before
    public void setUp() {
        tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setDestination("SPB");
        tripDto.setOrigin("IZH");
        tripDto.setPrice(7800);
    }

    @Test
    public void saveAndFindAllTest() {
        tripRepository.save(tripDto);
        tripRepository.findAll();
        tripDto.setPrice(666);
        tripRepository.saveAndFlush(tripDto);
    }


}
