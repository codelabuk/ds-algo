package org.example.ds.interview;

import java.util.List;
import java.util.stream.Collectors;

class Person {
    int age;
    Address address;

    public Person(int age, Address address) {
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    String city;
    String lane;
    Integer postalCode;

    public Address(String city, String lane, Integer postalCode) {
        this.city = city;
        this.lane = lane;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}

public class JavaStream8 {

    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person(18, new Address("Mumbai", "lane1", 001)),
                new Person(17, new Address("Delhi", "lane1", 001)),
                new Person(40, new Address("Mumbai", "lane1", 001)),
                new Person(31, new Address("Bangalore", "lane1", 001)),
                new Person(42, new Address("Hyderabad", "lane1", 001))
        );

        List<String> distCities = personList.stream().filter(p -> p.getAge() >= 18)
                .map(q -> q.getAddress().getCity()).distinct().collect(Collectors.toList());
        System.out.println(distCities);

    }

}
