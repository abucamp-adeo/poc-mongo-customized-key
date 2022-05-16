package com.example.poc.mongocustomizedkey.model;

import java.time.Instant;

public record DayRequest(String userId, Instant date) {

}
