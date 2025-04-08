package org.example.immutable;

public class CopyCheck {

    public static void main(String[] args) {
        Person original = new Person();
        original.name = "anc";
        original.address = new Address();
        original.address.city = "xyz";


        Person deepCopy = original.deepCopy();
        deepCopy.address.city = "abc";
        System.out.println(deepCopy.address.city);  // deep copy example
        System.out.println(original.address.city);

        Person shallowCopy = original;
        shallowCopy.address.city = "yzx";

        System.out.println(shallowCopy.address.city);
        System.out.println(original.address.city);

    }
}


class Person{
    String name;
    Address address;

    public Person deepCopy(){
        Person copy = new Person();
        copy.name = this.name;
        copy.address = new Address();
        copy.address.city = this.address.city;
        return copy;

    }
}

class Address{
    String city;
}