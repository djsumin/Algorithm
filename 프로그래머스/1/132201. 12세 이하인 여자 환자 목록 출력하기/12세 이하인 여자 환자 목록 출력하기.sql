-- 코드를 입력하세요
select pt_name, pt_no, gend_cd, age, coalesce(tlno, 'NONE')
from patient
where age <= 12 and gend_cd = 'W'
order by age desc, pt_name asc;