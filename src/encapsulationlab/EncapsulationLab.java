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
public class EncapsulationLab {

    /*
            Are we violating SRP (Single Responsibility Principle)?
        
            HINT: think about what we are trying to do ... hire an employee.
            Whose job is it to do this? The current class? Or, a new class?
            Should we do the work here or delegate to the new class? You
            may need to create a new class that talks to Employee. This does
            not have to be a GUI class.
        */
    
    public static void main(String[] args){
        
        Employee employee = new Employee();
        
        employee.createEmployee("Peter", "Piper", "333-1234", 1994, 11, 7);
        
        employee.doOrientation("1234");

       
    }
    
}
