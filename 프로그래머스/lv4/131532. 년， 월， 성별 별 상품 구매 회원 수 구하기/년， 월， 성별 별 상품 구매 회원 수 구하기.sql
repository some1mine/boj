-- 코드를 입력하세요
SELECT YEAR(O.SALES_DATE) YEAR, MONTH(O.SALES_DATE) MONTH, U.GENDER, COUNT(DISTINCT O.USER_ID)
FROM USER_INFO U JOIN ONLINE_SALE O USING(USER_ID)
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;