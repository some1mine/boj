-- 코드를 입력하세요
SELECT EXTRACT(YEAR FROM O.SALES_DATE) YEAR, EXTRACT(MONTH FROM O.SALES_DATE) MONTH, U.GENDER, COUNT(DISTINCT O.USER_ID) USERS
FROM USER_INFO U JOIN ONLINE_SALE O ON(U.USER_ID = O.USER_ID)
WHERE GENDER IS NOT NULL
GROUP BY (EXTRACT(YEAR FROM O.SALES_DATE), EXTRACT(MONTH FROM O.SALES_DATE), GENDER)
ORDER BY YEAR, MONTH, GENDER;