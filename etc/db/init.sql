CREATE DATABASE `trigger-campaign`;

CREATE USER 'trigger-campaign'@'localhost' IDENTIFIED BY 'trigger-campaign';
GRANT ALL PRIVILEGES ON *.* TO 'trigger-campaign'@'%' WITH GRANT OPTION;
