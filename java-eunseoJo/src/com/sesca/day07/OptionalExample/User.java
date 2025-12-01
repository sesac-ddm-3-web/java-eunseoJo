package com.sesca.day07.OptionalExample;

import java.util.Optional;

class User {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public User(Address address) {
        this.address = address;
    }


    public Optional<Address> getOptionalAddress() {
        return Optional.ofNullable(address);
    }



}