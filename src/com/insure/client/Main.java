package com.insure.client;


import com.insure.client.gen.Employee;
import com.insure.client.gen.EmployeeService;
import com.insure.client.gen.EmployeeServiceService;

import javax.xml.ws.BindingProvider;

public class Main {
    public static void main(String args[]){
        System.out.println("Project template - client");
        EmployeeServiceService service = new EmployeeServiceService();
        EmployeeService employeeStore = service.getEmployeeServicePort();

        String url = "http://localhost:8090/myservice";
        ((BindingProvider) employeeStore).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,url);

        // create an employee at the datastore and return an object of type Employee
        Employee e = employeeStore.addEmployee(1, "Daniel");
        System.out.println(e.getFirstName() + " id "+ e.getId());

        // retrieve an object of type employee from the data store and print it.
        e = employeeStore.getEmployee(1);
        System.out.println(e.getFirstName() + " id "+ e.getId());


    }

}