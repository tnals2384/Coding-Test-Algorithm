WITH SUB AS (SELECT MAX(FAVORITES) AS MAX, FOOD_TYPE FROM REST_INFO GROUP BY FOOD_TYPE)
SELECT R.FOOD_TYPE,R.REST_ID,R.REST_NAME,R.FAVORITES FROM REST_INFO AS R JOIN SUB AS S ON FAVORITES = MAX AND R.FOOD_TYPE = S.FOOD_TYPE
    ORDER BY FOOD_TYPE DESC;