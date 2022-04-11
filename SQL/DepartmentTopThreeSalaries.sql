select B.dname Department, B.name Employee, B.salary Salary
from (select f.dname                                                         dname,
             f.name                                                          name,
             f.salary                                                        salary,
             dense_rank() over (partition by f.dname order by f.salary desc) ranks
      from (select d.name dname, e.name, e.salary
            from Employee e
                     join Department d on d.id = e.departmentId) f) B
where B.ranks <= 3;