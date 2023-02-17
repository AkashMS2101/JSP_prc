package jsp_employee_prc1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp_employee_prc1.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("akash").createEntityManager();
	}
	
	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
		return employee;
	}
	
	public Employee loginEmployee(String mail) {
		EntityManager entityManager = getEntityManager();
		
		String querry ="select e from Employee e where e.email=?1";
		
		Query query=entityManager.createQuery(querry);
		query.setParameter(1, mail);
		Employee employee= (Employee)query.getSingleResult();
		return employee;
	}
	
	public List<Employee> getListofEmployee() {
		EntityManager entityManager = getEntityManager();
		String querry="select e from Employee e";
		
		Query query = entityManager.createQuery(querry);
		
		List<Employee> e_list = query.getResultList();
		return e_list;
	}
	
	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public boolean deleteEmployee(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, id);
		
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public Employee getEmployeeByid(int id) {
		return getEntityManager().find(Employee.class, id);
	}
}
