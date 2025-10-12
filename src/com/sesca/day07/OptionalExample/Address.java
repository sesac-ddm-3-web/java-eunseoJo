package com.sesca.day07.OptionalExample;

import java.util.Optional;

class Address {
    private String city;
    public String getCity() { return city; }
    public Address(String city) { this.city = city; }

    public Optional<String> getOptionalCity() {
        return Optional.ofNullable(this.city);
    }
}
