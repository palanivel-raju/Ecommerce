CREATE TABLE category
(
    id          BIGINT NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    status      SMALLINT NULL,
    name        VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE join_mentor
(
    user_id BIGINT NOT NULL,
    noofhrs INT    NOT NULL,
    CONSTRAINT pk_join_mentor PRIMARY KEY (user_id)
);

CREATE TABLE join_ta
(
    user_id   BIGINT NOT NULL,
    nofrating INT    NOT NULL,
    CONSTRAINT pk_join_ta PRIMARY KEY (user_id)
);

CREATE TABLE join_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_join_user PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    modified_at   datetime NULL,
    status        SMALLINT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image_url     VARCHAR(255) NULL,
    spec          VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_sc_instructor PRIMARY KEY (id)
);

CREATE TABLE sc_mentor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    noofhrs INT    NOT NULL,
    CONSTRAINT pk_sc_mentor PRIMARY KEY (id)
);

CREATE TABLE sc_ta
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    nofrating INT    NOT NULL,
    CONSTRAINT pk_sc_ta PRIMARY KEY (id)
);

CREATE TABLE singletable_user
(
    id        BIGINT NOT NULL,
    user_type INT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    noofhrs   INT    NOT NULL,
    nofrating INT    NOT NULL,
    company   VARCHAR(255) NULL,
    CONSTRAINT pk_singletable_user PRIMARY KEY (id)
);

CREATE TABLE test_model
(
    id          BIGINT NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    status      SMALLINT NULL,
    CONSTRAINT pk_testmodel PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    noofhrs INT    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    nofrating INT    NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE join_mentor
    ADD CONSTRAINT FK_JOIN_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE join_ta
    ADD CONSTRAINT FK_JOIN_TA_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);