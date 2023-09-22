package vn.week2_lab2_doanhoaian_20116041.services;

import org.joda.time.DateTime;
import vn.week2_lab2_doanhoaian_20116041.enums.EmployeeStatus;
import vn.week2_lab2_doanhoaian_20116041.models.Employee;
import vn.week2_lab2_doanhoaian_20116041.models.Order;
import vn.week2_lab2_doanhoaian_20116041.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;





public class EmplooyeService {
    private EmployeeRepository employeeRepository;
    
    public EmplooyeService(){
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee){
        employeeRepository.insertEmp(employee);
    }

    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }
    
    public boolean deleteEmp(long id){
        Optional<Employee> employee = findById(id);
        if(employee.isPresent()){
            employeeRepository.setStatus(employee.get(), EmployeeStatus.IN_ACTIVE);
            return true;
        }
        return false;
    }
    
    public boolean activeEmp(long id){
        Optional<Employee> op = findById(id);
        if(op.isPresent()){
            Employee employee = op.get();
            employeeRepository.setStatus(op.get(), EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List <Employee> getAll(){
        return employeeRepository.findAll();
    }

   public List<Order> getOrdersByPeriod(DateTime from, DateTime to){
         return employeeRepository.getOrdersByPeriod(from, to);
   }


   
}
