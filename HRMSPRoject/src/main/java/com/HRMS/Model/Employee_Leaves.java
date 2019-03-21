package com.HRMS.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "hrms_employee_leaves")
public class Employee_Leaves implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int empId;
	private Date start_date;
	private Date end_date;
	private int total_days;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="leaveId" )
	private Leaves leaves;

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getTotal_days() {
		return total_days;
	}

	public void setTotal_days(int total_days) {
		this.total_days = total_days;
	}

	@Override
	public String toString() {
		return "Employee_Leaves [Id=" + Id + ", empId=" + empId + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", total_days=" + total_days + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + empId;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + total_days;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee_Leaves other = (Employee_Leaves) obj;
		if (Id != other.Id)
			return false;
		if (empId != other.empId)
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (total_days != other.total_days)
			return false;
		return true;
	}
	public Leaves getLeaves() {
		return leaves;
	}

	public void setLeaves(Leaves leaves) {
		this.leaves = leaves;
	}


}
