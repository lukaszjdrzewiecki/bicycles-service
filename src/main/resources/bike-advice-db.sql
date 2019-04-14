DROP SCHEMA IF EXISTS `bike-advice`;

CREATE SCHEMA `bike-advice`;

use `bike-advice`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `cassette`;

CREATE TABLE `cassette` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `minimum` int(11) DEFAULT NULL,
  `maximum` int(11) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `crank`;

CREATE TABLE `crank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `arm_length` int(11) DEFAULT NULL,
  `number_of_gears` int(11) DEFAULT NULL,
  `big_gear` int(11) DEFAULT NULL,
  `medium_gear` int(11) DEFAULT NULL,
  `small_gear` int(11) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `bicycle`;

CREATE TABLE `bicycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  
  `casette_id` int(11) DEFAULT NULL,
  KEY `CS_idx` (`casette_id`),
  CONSTRAINT `CS` FOREIGN KEY (`casette_id`) 
  REFERENCES `cassette` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  `crank_id` int(11) DEFAULT NULL,
  KEY `CR_idx` (`crank_id`),
  CONSTRAINT `CR` FOREIGN KEY (`crank_id`) 
  REFERENCES `crank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `bicycle` VALUES 
	(1,'Scott','Scale','1','1');
    
INSERT INTO `cassette` VALUES
(1,'shimano m770','11','42','11');

INSERT INTO `crank` VALUES 
(1,'shimano m860','175','2','42','36', null, '11');

SET FOREIGN_KEY_CHECKS = 1;
