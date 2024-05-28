CREATE TABLE test_model
(
    id          BIGINT NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    status      SMALLINT NULL,
    CONSTRAINT pk_testmodel PRIMARY KEY (id)
);