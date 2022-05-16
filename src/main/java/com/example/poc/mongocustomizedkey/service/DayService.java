package com.example.poc.mongocustomizedkey.service;

import com.example.poc.mongocustomizedkey.model.Day;
import com.example.poc.mongocustomizedkey.model.DayRequest;
import com.example.poc.mongocustomizedkey.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.random.RandomGenerator;

@Slf4j
@Service
@RequiredArgsConstructor
public class DayService {

    private final DayRepository dayRepository;
    private final RandomGenerator randomGenerator = new Random();

    public Day saveTheDay(DayRequest dayRequest) {
        Day result = null;
        do {
            int generatedValue = randomGenerator.nextInt();
            String convertedValue = String.format("%6.6s", Integer.toUnsignedString(generatedValue));
            String newId = "Day".concat(dayRequest.userId()).concat(convertedValue);
            log.info(newId);
            try {
                result = dayRepository.insert(Day.builder()
                        .id(newId)
                        .date(dayRequest.date())
                        .build());
            } catch (DuplicateKeyException e){
                log.debug("Id {} already exists. Try again", newId);
            } catch (Exception e){
                throw new RuntimeException();
            }
        } while (result == null);
        return result;
    }

}
