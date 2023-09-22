package vn.week2_lab2_doanhoaian_20116041.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.joda.time.DateTime;
import vn.week2_lab2_doanhoaian_20116041.enums.EmployeeStatus;
import vn.week2_lab2_doanhoaian_20116041.models.Employee;
import vn.week2_lab2_doanhoaian_20116041.models.Order;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager entityManager;

    public EmployeeRepository() {
       entityManager = Persistence
               .createEntityManagerFactory("lab_week_2")
               .createEntityManager();
    }

    public void insertEmp(Employee employee){
        entityManager.persist(employee);
    }


    public  void setStatus(Employee employee, EmployeeStatus status){
        employee.setStatus(status);
    }

    public Optional<Employee> findById(long id){
      TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM emloyee e where e.emp_id = :id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        return employee != null ? Optional.of(employee) : Optional.empty();
    }

    public List<Employee> findAll(){
       return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public List<Order> getOrdersByPeriod(DateTime from, DateTime to){
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o where o.order_date between :from and :to", Order.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

}
