-- 코드를 입력하세요
SELECT Concat('/home/grep/src/',A.Board_id,'/',file_id,file_name,file_ext) as FILE_PATH     from used_goods_file as A, used_goods_board as B 
    where A.Board_id=B.Board_id and B.views= (select max(views) from used_goods_board)
    order by file_id desc;