package com.example.poc.mongocustomizedkey.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "day")
@Value
@Builder
public class Day {

    @Id
    String id;
    Instant date;
}
