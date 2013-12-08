create table user(
	id_user int auto_increment,
	username varchar(256) not null,
	email varchar(256) not null,
	password varchar(256) not null,
	nama_lengkap varchar(256) not null,
	provinsi varchar(256) default null,
	kota varchar(256) default null,
	alamat varchar(32) default null,
	kode_pos varchar(32) default null,
	kontak varchar(32) default null,
	nomor_kartu varchar(256) default null,
	nama_kartu varchar(256) default null,
	ekspirasi_kartu date default null,
	primary key(user_id),
	unique(username),
	unique(email)
);

create table kategori(
	id_kategori int auto_increment,
	nama_kategori varchar(256) not null,
	primary key(id_kategori)
);

create table barang(
	id_barang int auto_increment,
	id_kategori int not null,
	nama_barang varchar(256) not null,
	harga int not null,
	satuan varchar(32) not null,
	deskripsi varchar(1024) default null,
	jumlah_pembelian int default 0,
	jumlah_stok int default 0,
	nama_gambar varchar(256) not null,
	nama_gambar_thumb varchar(256) not null,
	primary key(id_barang),
	foreign key(id_kategori) references kategori(id_kategori) on delete cascade on update cascade
);
