-- 코드를 입력하세요
SELECT I.animal_id, I.name from animal_ins as I,animal_outs as O where I.animal_id=O.animal_id and I.datetime > O.datetime order by I.datetime;