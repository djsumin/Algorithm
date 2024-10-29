-- 코드를 입력하세요
SELECT b.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.address, round(avg(b.review_score),2) as SCORE
from rest_info a join rest_review b on a.rest_id = b.rest_id
group by b.rest_id
having a.address like '서울%'
order by score desc, a.favorites desc;