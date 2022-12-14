-- Modified the output of MySQL dump
--
-- Drop tables
DROP TABLE IF EXISTS `shared_media`;
DROP TABLE IF EXISTS `user`;

-- Create tables

CREATE TABLE `user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(128) NOT NULL,
    PRIMARY KEY (`id`),
    Unique (username)
);

CREATE TABLE `shared_media` (
    `user_id` int NOT NULL,
    `video_id` char(11) NOT NULL,
    `id` int NOT NULL AUTO_INCREMENT,
    `description` varchar(500) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `shared_media_user_null_fk` (`user_id`),
    CONSTRAINT `shared_media_user_null_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);