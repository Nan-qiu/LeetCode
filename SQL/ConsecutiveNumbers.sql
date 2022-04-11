select distinct l1.num ConsecutiveNums
from Logs l1
         join Logs l2
         join Logs l3
              on l1.id = l2.id + 1 and l2.id = l3.id + 1
where l1.num = l2.num
  and l2.num = l3.num;