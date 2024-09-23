package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
public class Address {

    String country;
    String state;
    String city;
    String pinCode;
}
