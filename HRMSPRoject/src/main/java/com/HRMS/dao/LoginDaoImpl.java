package com.HRMS.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;


@Repository("loginDao")
public class LoginDaoImpl implements LoginDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	 protected Session getSession() {
	        return sessionFactory.getCurrentSession();
	    }
	
	 public EmployeeVO validateUser(String uname, String password) {
			System.out.println("DAOIMPL");
			EmployeeVO employeeData=null;
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EmployeeVO e where e.id=e.employeeLogin.id and e.employeeLogin.userName='"+uname+"' and e.employeeLogin.password='"+password+"'");
		    List<EmployeeVO> resultList=query.list();	
		    for(EmployeeVO emp:resultList)
		    	 employeeData=emp;
			return employeeData;
			
			
		}

	@Override
	public EmployeeVO AuthenticateUser(String uname, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public EmployeeVO validateUser(String uname, String password) {
		// TODO Auto-generated method stub
		System.out.println("DAOIMPL");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeVO_Login.class);
		criteria.add(Restrictions.eq("userName", uname));
		criteria.add(Restrictions.eq("password", password));
		EmployeeVO employee = (EmployeeVO) criteria.uniqueResult();
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&"+employee.getRole());
		SQLQuery query = session.createSQLQuery("select emp_id, emp_name, emp_salary from Employee");
List<Object[]> rows = query.list();
      EmployeeVO employee=null;
		Query query = session.createQuery("from EmployeeVO e,EmployeeVO_Login l where e.id=l.id and l.userName='"+uname+"' and l.password='"+password+"'");

		 List<Object[]> employees = query.list();
	Iterator iterator = employees.iterator();
	while ( iterator.hasNext()){
		
		 employee = (EmployeeVO) iterator.next(); 
        System.out.print("First Name: " + employee.getFirstName()); 
        System.out.print("  Last Name: " + employee.getLastName()); 
        System.out.println("  Salary: " + employee.getSalary()); 
     }
	//System.out.println("from dAOOOOOOO"+employee1.getFirstName());
		return employee;
	}
*/
}
