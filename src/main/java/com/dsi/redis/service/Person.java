package com.dsi.redis.service;

import com.dsi.redis.service.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String firstname;
    String lastname;
    Address address;
    Date date;
}
