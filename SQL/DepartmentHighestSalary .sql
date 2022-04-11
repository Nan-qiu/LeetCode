select d.name Department, e.name Employee, e.salary Salary
from Employee e
         join Department d on e.departmentId = d.id
where (e.salary, e.departmentId) in (
    select MAX(salary), departmentId
    from Employee
    group by departmentId
);