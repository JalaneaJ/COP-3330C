package org.example;

//Purpose: Info for ArtStudents
public class ArtStudents {
    private int studentId;
    private String department;
    private String firstName;
    private String lastName;
    private int passOutYear;
    private int universityRank;

    // Constructor
    public ArtStudents(int studentId, String department, String firstName, String lastName, int passOutYear, int universityRank) {
        this.studentId = studentId;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passOutYear = passOutYear;
        this.universityRank = universityRank;
    }

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear(int passOutYear) {
        this.passOutYear = passOutYear;
    }

    public int getUniversityRank() {
        return universityRank;
    }

    public void setUniversityRank(int universityRank) {
        this.universityRank = universityRank;
    }

    // Override toString(): For easy printing
    @Override
    public String toString() {
        return "//Student Information \n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Student ID: " + studentId + "\n" +
                "Department: " + department + "\n" +
                "Passout Year: " + passOutYear + "\n" +
                "University Ranking: " + universityRank;
    }
}

