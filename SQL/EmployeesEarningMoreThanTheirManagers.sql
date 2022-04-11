select e1.name Employee
from Employee e1
         join Employee e2 on e2.id = e1.managerId
where e1.salary > e2.salary;