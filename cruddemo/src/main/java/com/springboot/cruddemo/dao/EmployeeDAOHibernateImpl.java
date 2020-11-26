package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entitymanager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	
	
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session currentsession=entitymanager.unwrap(Session.class);
		Query<Employee> theQuery=currentsession.createQuery("from Employee",Employee.class);
		List<Employee> employee=theQuery.getResultList();
		return employee;
	}


	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Session currentsession=entitymanager.unwrap(Session.class);
		Employee theEmployee=currentsession.get(Employee.class, theId);
		
		return theEmployee;
	}


	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Session currentsession=entitymanager.unwrap(Session.class);
		currentsession.saveOrUpdate(theEmployee);
	}


	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Session currentsession=entitymanager.unwrap(Session.class);
		Query<Employee> theQuery=currentsession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
		
	}

}
