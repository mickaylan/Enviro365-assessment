create table ACCOUNT_PROFILETB (
    id BIGINT auto_increment,
    ACCOUNT_HOLDER_NAME varchar(255) not null,
    ACCOUNT_HOLDER_SURNAME varchar(255) not null,
    HTTP_IMAGE_LINK varchar(255) not null,
    PRIMARY KEY (id)
);