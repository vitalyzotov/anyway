-- -----------------------------------------------------
-- Table `person_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `person_` (
                                         `PERSON_UID` VARCHAR(64) NOT NULL,
                                         `FIRST_NAME` VARCHAR(255) NOT NULL,
                                         `LAST_NAME` VARCHAR(255) NOT NULL,
                                         `BIRTH_DATE` DATE NULL DEFAULT NULL,
                                         `CITY` VARCHAR(255) NULL DEFAULT NULL,
                                         `COUNTRY` VARCHAR(255) NULL DEFAULT NULL,
                                         `PLACE_OF_WORK` VARCHAR(255) NULL DEFAULT NULL,
                                         `PHONE_MOBILE` VARCHAR(45) NULL DEFAULT NULL,
                                         `EDUCATION` VARCHAR(255) NULL DEFAULT NULL,
                                         `LANGUAGES` VARCHAR(1024) NULL,
                                         PRIMARY KEY (`PERSON_UID`));

CREATE UNIQUE INDEX `PERSON_UID_UNIQUE` ON `person_` (`PERSON_UID` ASC);


-- -----------------------------------------------------
-- Table `person_photo_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `person_photo_` (
                                               `PERSON_UID` VARCHAR(64) NOT NULL,
                                               `PHOTO_` MEDIUMBLOB NULL DEFAULT NULL,
                                               PRIMARY KEY (`PERSON_UID`),
                                               CONSTRAINT `FK_PERSON_PHOTO_UID`
                                                   FOREIGN KEY (`PERSON_UID`)
                                                       REFERENCES `person_` (`PERSON_UID`)
                                                       ON DELETE CASCADE
                                                       ON UPDATE CASCADE);

CREATE UNIQUE INDEX `PERSON_PHOTO_UID_UNIQUE` ON `person_photo_` (`PERSON_UID` ASC);


-- -----------------------------------------------------
-- Table `community_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `community_` (
                                            `COMMUNITY_UID` VARCHAR(64) NOT NULL,
                                            `ADMIN_UID` VARCHAR(64) NOT NULL,
                                            `DESCRIPTION` MEDIUMTEXT NULL,
                                            `TITLE` VARCHAR(255) NOT NULL,
                                            `SUBJECT` VARCHAR(255) NULL,
                                            PRIMARY KEY (`COMMUNITY_UID`));

CREATE UNIQUE INDEX `COMMUNITY_UID_UNIQUE` ON `community_` (`COMMUNITY_UID` ASC);


-- -----------------------------------------------------
-- Table `community_photo_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `community_photo_` (
                                                  `COMMUNITY_UID` VARCHAR(64) NOT NULL,
                                                  `PHOTO_` MEDIUMBLOB NULL DEFAULT NULL,
                                                  CONSTRAINT `FK_COMMUUNITY_PHOTO_UID`
                                                      FOREIGN KEY (`COMMUNITY_UID`)
                                                          REFERENCES `community_` (`COMMUNITY_UID`)
                                                          ON DELETE CASCADE
                                                          ON UPDATE CASCADE);

CREATE UNIQUE INDEX `COMMUNITY_PHOTO_UID_UNIQUE` ON `community_photo_` (`COMMUNITY_UID` ASC);


-- -----------------------------------------------------
-- Table `c_event_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c_event_` (
                                          `C_EVENT_UID` VARCHAR(64) NOT NULL,
                                          `COMMUNITY_UID` VARCHAR(64) NOT NULL,
                                          `TITLE` VARCHAR(255) NOT NULL,
                                          `DESCRIPTION` MEDIUMTEXT NULL,
                                          `MEETING_TIME` DATETIME NOT NULL,
                                          PRIMARY KEY (`C_EVENT_UID`),
                                          CONSTRAINT `FK_C_EVENT_COMMUNITY_UID`
                                              FOREIGN KEY (`COMMUNITY_UID`)
                                                  REFERENCES `community_` (`COMMUNITY_UID`)
                                                  ON DELETE CASCADE
                                                  ON UPDATE CASCADE);

CREATE UNIQUE INDEX `C_EVENT_UID_UNIQUE` ON `c_event_` (`C_EVENT_UID` ASC);

CREATE INDEX `FK_C_EVENT_COMMUNITY_UID_idx` ON `c_event_` (`COMMUNITY_UID` ASC);


-- -----------------------------------------------------
-- Table `c_event_member_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c_event_member_` (
                                                 `C_EVENT_UID` VARCHAR(64) NOT NULL,
                                                 `PERSON_UID` VARCHAR(64) NOT NULL,
                                                 CONSTRAINT `FK_C_EVENT_MEMBERS_EVENT`
                                                     FOREIGN KEY (`C_EVENT_UID`)
                                                         REFERENCES `c_event_` (`C_EVENT_UID`)
                                                         ON DELETE CASCADE
                                                         ON UPDATE CASCADE,
                                                 CONSTRAINT `FK_C_EVENT_MEMBERS_PERSON`
                                                     FOREIGN KEY (`PERSON_UID`)
                                                         REFERENCES `person_` (`PERSON_UID`)
                                                         ON DELETE CASCADE
                                                         ON UPDATE CASCADE);

CREATE UNIQUE INDEX `IDX_MEMBER` ON `c_event_member_` (`C_EVENT_UID` ASC, `PERSON_UID` ASC);

CREATE INDEX `FK_C_EVENT_MEMBERS_PERSON_idx` ON `c_event_member_` (`PERSON_UID` ASC);


-- -----------------------------------------------------
-- Table `message_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `message_` (
                                          `MESSAGE_UID` VARCHAR(64) NOT NULL,
                                          `AUTHOR_UID` VARCHAR(64) NOT NULL,
                                          `RECIPIENT_UID` VARCHAR(64) NOT NULL,
                                          `TYPE` CHAR(1) NOT NULL,
                                          `CREATED` DATETIME NULL,
                                          `TEXT` MEDIUMTEXT NULL,
                                          PRIMARY KEY (`MESSAGE_UID`),
                                          CONSTRAINT `FK_MESSAGE_AUTHOR`
                                              FOREIGN KEY (`AUTHOR_UID`)
                                                  REFERENCES `person_` (`PERSON_UID`)
                                                  ON DELETE CASCADE
                                                  ON UPDATE CASCADE,
                                          CONSTRAINT `FK_MESSAGE_RECIPIENT`
                                              FOREIGN KEY (`RECIPIENT_UID`)
                                                  REFERENCES `person_` (`PERSON_UID`)
                                                  ON DELETE CASCADE
                                                  ON UPDATE CASCADE);

CREATE UNIQUE INDEX `MESSAGE_UID_UNIQUE` ON `message_` (`MESSAGE_UID` ASC);

CREATE INDEX `FK_MESSAGE_AUTHOR_idx` ON `message_` (`AUTHOR_UID` ASC);

CREATE INDEX `FK_MESSAGE_RECIPIENT_idx` ON `message_` (`RECIPIENT_UID` ASC);


-- -----------------------------------------------------
-- Table `message_data_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `message_data_` (
                                               `MESSAGE_UID` VARCHAR(64) NOT NULL,
                                               `DATA` MEDIUMBLOB NOT NULL,
                                               PRIMARY KEY (`MESSAGE_UID`),
                                               CONSTRAINT `FK_MESSAGE_DATA_MESSAGE`
                                                   FOREIGN KEY (`MESSAGE_UID`)
                                                       REFERENCES `message_` (`MESSAGE_UID`)
                                                       ON DELETE CASCADE
                                                       ON UPDATE CASCADE);

CREATE UNIQUE INDEX `MESSAGE_DATA_UID_UNIQUE` ON `message_data_` (`MESSAGE_UID` ASC);
