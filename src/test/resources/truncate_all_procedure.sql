DROP PROCEDURE IF EXISTS TRUNCATE_ALL_TABLES;

CREATE PROCEDURE TRUNCATE_ALL_TABLES(IN tables_blacklist VARCHAR(1024))
BEGIN
    DECLARE current_table VARCHAR(255);
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE cursor_i CURSOR FOR
        SELECT t.table_name
        FROM information_schema.tables t
        WHERE table_schema NOT IN('mysql','information_schema',
                                  'performance_schema','sys')
          AND table_name NOT LIKE 'DATABASECHANGE%'
          AND NOT FIND_IN_SET(table_name, tables_blacklist);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    SET FOREIGN_KEY_CHECKS = 0;

    OPEN cursor_i;
    read_loop: LOOP
        FETCH cursor_i INTO current_table;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SET @sql = CONCAT('TRUNCATE TABLE ', current_table);
        PREPARE stmt FROM @sql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END LOOP;
    CLOSE cursor_i;

    SET FOREIGN_KEY_CHECKS = 1;
END;
