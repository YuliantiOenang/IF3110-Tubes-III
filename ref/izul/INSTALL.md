Berikut ini adalah langkah-langkah untuk menginstall secara lokal di platform Windows. Untuk platform yang berbeda tidak dibahas di sini, namun secara umum sama.

1. Install XAMPP dan buka XAMPP Control Panel. Jalankan service Apache dan MySQL.
2. Buka folder C:\xampp\htdocs\ dan copy keseluruhan folder project.
3. Buka folder src\app\config.php
5. Isi ENVIRONMENT sesuai petunjuk dan kebutuhan, misal PRODUCTION
6. Isi SITEURL dengan alamat situs, misal //localhost/project/src
7. Isi $CONFIG['mysql']['database'] dengan nama database, begitu pula dengan host, user, dan password
8. Buka localhost/project/src/install/clean untuk memastikan database
9. Selanjutnya buka localhost/project/src/install/make yang secara otomatis akan membuat tabel
10. Jalankan bagian home aplikasi di localhost/project/src/