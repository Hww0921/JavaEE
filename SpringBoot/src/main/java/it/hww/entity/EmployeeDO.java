package it.hww.entity;

import java.util.Date;

public class EmployeeDO {
    /**
     * 部门名
     */
    private String dName;
    /**
     * 员工id
     */
    private String eId;
    /**
     * 员工姓名
     */
    private String eName;
    /**
     * 入职日期
     */
    private Date hiredate;
    /**
     *
     */
    private Double salary;

    public EmployeeDO() {
    }

    public EmployeeDO(String dName, String eId, String eName, Date hiredate, Double salary) {
        this.dName = dName;
        this.eId = eId;
        this.eName = eName;
        this.hiredate = hiredate;
        this.salary = salary;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dName='" + dName + '\'' +
                ", eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                '}';
    }
}
