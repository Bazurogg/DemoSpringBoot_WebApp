CREATE DATABASE IF NOT EXISTS springboot;
use springboot;
DROP TABLE IF EXISTS `Person`;

CREATE TABLE `Person` (
  `id` int unsigned NOT NULL auto_increment,
  `Lastname` varchar(50) default NULL,
  `Firstname` varchar(50) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `Person` (id, Lastname, Firstname)
VALUES
    (1, "Hyde", "Jemima"),
    (2, "Thornton", "Adele"),
    (3, "Ramirez", "Shellie"),
    (4, "Pennington", "Kelly"),
    (5, "Forbes", "Bruno"),
    (6, "Britt", "Quinn"),
    (7, "Glass", "Jescie"),
    (8, "Booker", "Thane"),
    (9, "Riddle", "Lance"),
    (10, "Kline", "Rylee"),
    (11, "Neal", "Sonia"),
    (12, "Mitchell", "Neil"),
    (13, "Saunders", "Alexis"),
    (14, "Watkins", "Branden"),
    (15, "Vaughan", "Emi"),
    (16, "Hancock", "Palmer"),
    (17, "Holloway", "Isabella"),
    (18, "Cotton", "Silas"),
    (19, "Wong", "Ryder"),
    (20, "Cooper", "Nero"),
    (21, "Delacruz", "Tallulah"),
    (22, "Sullivan", "Imelda"),
    (23, "Stewart", "Orlando"),
    (24, "Drake", "Thor"),
    (25, "Strickland", "Adrienne");