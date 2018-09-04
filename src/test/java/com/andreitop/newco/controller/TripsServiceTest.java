package com.andreitop.newco.controller;


import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
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
public class TripsServiceTest {

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
}
