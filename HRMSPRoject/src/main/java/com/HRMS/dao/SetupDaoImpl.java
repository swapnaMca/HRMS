package com.HRMS.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.Projects;

@Repository("setupDao")
public class SetupDaoImpl implements SetupDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	 protected Session getSession() {
	        return sessionFactory.getCurrentSession();
	    }
	@Override
	public void addProjects(Projects p) {
		getSession().saveOrUpdate(p);

	}

	public void addDepartment(DepartmentVO e) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(e);
	}
	public List<DepartmentVO> listDepartments() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DepartmentVO> deptList = session.createQuery("from DepartmentVO").list();
		
		return deptList;
	}

}
