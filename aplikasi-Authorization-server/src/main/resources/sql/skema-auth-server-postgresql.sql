CREATE TABLE role(
    idrole varchar(255) not null unique,
    name varchar(255) not null,
    description varchar(255) not null,

    CONSTRAINT pk_role_idrole PRIMARY KEY (idrole)
);

CREATE TABLE users(
    iduser varchar(255) not null unique,
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    activated boolean,

    CONSTRAINT pk_user_iduser PRIMARY KEY (iduser)
);

CREATE TABLE users_role(
    iduser varchar(255) not null,
    idrole varchar(255) not null,

    PRIMARY KEY (iduser, idrole),
    CONSTRAINT fk_users_role_iduser FOREIGN KEY (iduser)
    REFERENCES users (iduser) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_users_role_idrole FOREIGN KEY (idrole)
    REFERENCES role (idrole) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

