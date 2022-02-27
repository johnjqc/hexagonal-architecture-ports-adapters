
DROP SEQUENCE IF EXISTS message_id;
CREATE SEQUENCE message_id;

DROP TABLE IF EXISTS message;
CREATE TABLE message (
    id int default message_id.nextval PRIMARY KEY,
    message VARCHAR(250) NOT NULL
);
