-- 코드를 입력하세요
SELECT I.name, I.datetime from animal_ins as I
where not exists(select * from animal_outs as O where O.animal_id=I.animal_id) order by I.datetime limit 3;