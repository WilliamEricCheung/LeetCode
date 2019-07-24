package tech.wec.Facebook;

public class EmployeesEarningMoreThanTheirManagers_181 {
    /* SQl
    select a.Name as 'Employee'
    from Employee as a, Employee as b
    where a.ManagerId = b.Id and a.Salary > b.Salary;

     select a.Name as 'Employee'
     from Employee as a join Employee as b
     on a.ManagerId = b.Id ans a.salary > b.salary
     */
}
