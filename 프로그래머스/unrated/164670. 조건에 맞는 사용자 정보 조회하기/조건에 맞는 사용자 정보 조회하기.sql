-- 코드를 입력하세요
SELECT USER_ID, 
    NICKNAME, 
    (CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2) 전체주소,
    CASE LENGTH(TLNO)
       WHEN 11 THEN (SUBSTR(TLNO, 0, 3) || '-' || SUBSTR(TLNO, 4, 4) || '-' || SUBSTR(TLNO, 8))
       WHEN 10 THEN (SUBSTR(TLNO, 0, 3) || '-' || SUBSTR(TLNO, 4, 3) || '-' || SUBSTR(TLNO, 7))
        END 전화번호
FROM USED_GOODS_USER
WHERE USER_ID IN (SELECT WRITER_ID FROM USED_GOODS_BOARD
                 GROUP BY WRITER_ID HAVING COUNT(*) >= 3)
ORDER BY USER_ID DESC;