select c.name Customers
from Customers c
         left join Orders o on c.id = o.CustomerId
where o.CustomerId is null;