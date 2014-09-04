/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encapsulationlab;

import java.util.Date;

/**
 *
 * @author eennis
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;

    public Employee() {

    }
    
    public Employee(String firstName, String lastName, String ssn, Date birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
    }
    
    public void createEmployee(String firstName, String lastName, String ssn, int birthYear,
            int birthMonth, int birthDay){
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setBirthDate(birthYear, birthMonth, birthDay);
    }
    
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(firstName.length() == 0 || firstName == null){
            System.out.println("First Name not entered");
            System.exit(0);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if(lastName.length() == 0 || lastName == null){
            System.out.println("Last Name not entered");
            System.exit(0);
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        if(ssn.length() == 0 || ssn == null){
            System.out.println("Social Security Number not entered");
            System.exit(0);
        }
        this.ssn = ssn;
    }
    
    private void setBirthDate(int birthYear, int birthMonth, int birthDay){
        Date birthDate = new Date(birthYear, birthMonth, birthDay);
        this.birthDate = birthDate;
    }
    
    public String getCubeId(){
        return cubeId;
    }
        
    public void doOrientation(String cubeId){
        meetWithHrForBenefitAndSalaryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
        System.out.println("The employee's status is: " + getStatus());
    }
    
    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalaryInfo() {
        metWithHr = true;
    }
    
    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        if(metWithHr) {
            metDeptStaff = true;
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
        if(metWithHr && metDeptStaff) {
            reviewedDeptPolicies = true;
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies) {
            this.cubeId = cubeId;
            this.movedIn = true;
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    public String getStatus() {
        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is complete";
        } else {
            return "Orientation in progress...";
        }
    }
    
}
