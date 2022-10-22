-- 코드를 입력하세요
SELECT I.animal_id, I.animal_type, I.name 
from animal_ins as I,animal_outs as O
where I.sex_upon_intake Like('Intact%') 
and I.animal_id=O.animal_id
and sex_upon_outcome!=sex_upon_intake
order by animal_id;