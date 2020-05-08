package org.decimalbits.springdatarest.config;

import org.decimalbits.springdatarest.model.Activity;
import org.decimalbits.springdatarest.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StartupInit {

    private ActivityRepository activityRepository;

    @Autowired
    public StartupInit(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("Starting the initialization of data ...");
        activityRepository.saveAll(
                Stream.of(
                        new Activity().setName("Test 1").setDescription("This is the test-1.").setTargetDate(LocalDate.of(2017,06,19)),
                        new Activity().setName("Test 2").setDescription("This is the test-2.").setTargetDate(LocalDate.of(2017,07,20)),
                        new Activity().setName("Test 3").setDescription("This is the test-3.").setTargetDate(LocalDate.of(2017,8,21)),
                        new Activity().setName("Test 4").setDescription("This is the test-4.").setTargetDate(LocalDate.of(2017,9,22))
                ).collect(Collectors.toList()));
        System.out.println("Finishing the initialization of data ...");
    }
}
