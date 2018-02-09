create table categories(

    idcategories bigint auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    makedate date not null,
    disabled int,

    constraint pk_categories_idcategories primary key (idcategories)
);

create table product(

    idproduct varchar(255) not null,
    name varchar(255) not null,
    quantity int not null,
    price int not null,
    idcategories bigint not null,
    disabled int,
    image longblob,

    constraint pk_product_idproduct primary key (idproduct),
    constraint fk_product_idcategories foreign key (idcategories)
    references categories (idcategories)
);

