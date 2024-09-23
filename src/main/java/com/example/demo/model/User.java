package com.example.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "user")
@Data
@NoArgsConstructor      // Allows no-argument constructor
@AllArgsConstructor
@Builder
public class User {

    String name;
    int age;
    String gender;

    Address address;
}
