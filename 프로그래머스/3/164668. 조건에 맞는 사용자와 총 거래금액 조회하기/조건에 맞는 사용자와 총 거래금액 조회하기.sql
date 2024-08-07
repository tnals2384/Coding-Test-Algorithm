-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, SUM(PRICE) AS TOTAL_SALES
    FROM USED_GOODS_BOARD AS B, USED_GOODS_USER AS U
    WHERE B.WRITER_ID = U.USER_ID
    AND STATUS = 'DONE'
    GROUP BY USER_ID
    HAVING TOTAL_SALES >= 700000
    ORDER BY TOTAL_SALES;