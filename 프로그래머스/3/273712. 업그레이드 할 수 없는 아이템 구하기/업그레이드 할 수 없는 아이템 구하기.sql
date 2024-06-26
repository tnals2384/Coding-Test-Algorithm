SELECT A.ITEM_ID, A.ITEM_NAME, A.RARITY 
    FROM ITEM_INFO AS A 
    WHERE NOT EXISTS(
        SELECT * FROM ITEM_TREE
        WHERE A.ITEM_ID=PARENT_ITEM_ID)
    ORDER BY A.ITEM_ID DESC;