CREATE SCHEMA learn_jdbc;

use learn_jdbc;

CREATE TABLE pemilik_kucing(
id_kucing int(11) not null primary key auto_increment,
jenis varchar(255) not null,
nama varchar(255) not null,
is_liar bit(1) not null,
tanggal_lahir date not null
);

CREATE TABLE kucing_liar(
id_kucing_liar int(11) not null primary key auto_increment,
id_kucing int(11) not null
);

ALTER TABLE kucing_liar
    add constraint fk_kucing_liar_kucing foreign key (id_kucing)
references kucing (id_kucing);
