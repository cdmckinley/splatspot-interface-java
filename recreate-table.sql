-- Modified the output of MySQL dump
--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `nickname` varchar(25) DEFAULT NULL,
                        `friend_code` varchar(17) DEFAULT NULL,
                        `splash_tag_name` varchar(10) DEFAULT NULL,
                        `splash_tag_number` varchar(4) DEFAULT NULL,
                        `share_info_with_users` char(1) NOT NULL,
                        `share_when_ready_to_play` char(1) NOT NULL,
                        PRIMARY KEY (`id`)
);