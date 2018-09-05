package com.andreitop.newco.service;


import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(TripService.class)
public class TripServiceTest {

    @MockBean
    private TripRepository tripRepository;

    @Test
    public void whenFindAll_thenReturnListOfTrips() throws Exception{
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        List<TripDto> allTrips = Collections.singletonList(tripDto);
        given(tripRepository.findAll()).willReturn(allTrips);
    }

    @Test
    public void whenFindById_thenReturnTrip() throws Exception{
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);
        given(tripRepository.findById(1L)).willReturn(tripDto);
    }
}
