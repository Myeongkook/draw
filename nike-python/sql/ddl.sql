-- nike.draw definition

CREATE TABLE `draw` (
  `draw_id` int NOT NULL AUTO_INCREMENT,
  `date` char(100) DEFAULT NULL,
  `product` char(100) DEFAULT NULL,
  `url` char(100) DEFAULT NULL,
  `message` char(200) DEFAULT NULL,
  `is_sent` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`draw_id`),
  UNIQUE KEY `draw_UN` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;