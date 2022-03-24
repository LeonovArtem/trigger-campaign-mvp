SET @tables_blacklist = 'config';
CALL TRUNCATE_ALL_TABLES(@tables_blacklist);
