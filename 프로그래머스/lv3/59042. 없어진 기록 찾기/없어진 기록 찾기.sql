-- 코드를 입력하세요
SELECT animal_id, name from animal_outs AS O where not exists(select * from animal_ins as I where O.animal_id=I.animal_id) order by animal_id;