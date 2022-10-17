-- Modified the output of MySQL dump
--
-- Drop tables
DROP TABLE IF EXISTS `shared_media`;
DROP TABLE IF EXISTS `user`;

-- Create tables

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

CREATE TABLE `shared_media` (
    `user_id` int NOT NULL,
    `link` varchar(100) NOT NULL,
    `id` int NOT NULL AUTO_INCREMENT,
    `description` varchar(500) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `shared_media_user_null_fk` (`user_id`),
    CONSTRAINT `shared_media_user_null_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);