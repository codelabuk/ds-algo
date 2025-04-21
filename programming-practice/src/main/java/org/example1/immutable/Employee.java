package org.example.immutable;

/**
 * Immutable implementation
 * For Date can use defensive copy , or we can use LocalDate
 */

import java.util.Date;

public final class Employee{
    final String id;
    final String name;
    final Date dob;

    public Employee(String id, String name, Date dob){
        this.id= id;
        this.name = name;
        this.dob = new Date(dob.getTime()); // Defensive Copy
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }
}