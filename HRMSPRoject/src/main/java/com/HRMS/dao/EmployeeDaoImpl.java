package com.HRMS.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Leaves;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	 protected Session getSession() {
	        return sessionFactory.getCurrentSession();
	    }
	
	

	
	public EmployeeVO getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		EmployeeVO p = (EmployeeVO) session.load(EmployeeVO.class, new Integer(id));
		logger.info("EmployeeVO loaded successfully, Person details="+p);
		return p;
	}

	public List<DepartmentVO> listDepartments() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DepartmentVO> deptList = session.createQuery("from DepartmentVO").list();
		for(DepartmentVO p : deptList){
			logger.info("dept List::::::::::"+p.getDepartmentId());
		}
		return deptList;
	}

	public void addDepartment(DepartmentVO e) {
		getSession().saveOrUpdate(e);
	}

	@Override
	public void updateEmployeePassword(EmployeeVO_Login employeeLogin) {
		/*TO Update particular column*/
		String hql = "update EmployeeVO_Login set password = :password ,confirmPassword = :confirmPassword where id =:id";
        Query query = getSession().createQuery(hql);
        query.setString("password",employeeLogin.getPassword());
        query.setString("confirmPassword",employeeLogin.getPassword());
        query.setInteger("id",employeeLogin.getId());
        query.executeUpdate();
	}
	public void addLeaves(Leaves l) {
		Session session=sessionFactory.getCurrentSession();
		
		session.persist(l);

	}

	public void sendLeaveRequest(Employee_Leaves employeeLeave) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(employeeLeave);
		
	}

	@Override
	public List<Leaves> getAllLeaves() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Leaves> leavesList = session.createQuery("from Leaves").list();
		System.out.println("From DaoIMPLLLLLLLLLLLL"+leavesList.get(0));
		return leavesList;
	}

	@Override
	public void updateEmployeeProfilePic(EmployeeVO_Login employeeLogin) {
		String hql = "update EmployeeVO_Login set photo = :image  where id =:id";
        Query query = getSession().createQuery(hql);
        byte[] photo=employeeLogin.getPhoto();
        query.setBinary("image", photo);
        query.setInteger("id",employeeLogin.getId());
        query.executeUpdate();
		
	}

	
}
