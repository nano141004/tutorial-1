https://eshop-nano141004.koyeb.app/product/list

<details>
<summary> Tutorial 1 </summary>

## Reflection 1

Beberapa standard clean code yang sudah saya terapkan:
- Penamaan variable dan method yang cukup menjelaskan fungsi dari variable dan method tersebut.
- Pembuatan method secara pendek, berisi 1 kegunaan saja sesuai namanya.
- beberapa comments
Adapun beberapa kesalahan yang saya jumpai:
- Membuat product tanpa di-set idnya -> solusi dengan melakukan setId di ProductRepository
- Kesalahan nama url di template -> memperbaiki penamaan url

## Reflection 2

1. Setelah membuat unit test pastinya saya merasa code saya lebih reliable dalam menghadapi edge case. Jika terdapat error maka tinggal di debug, dan jika ternyata berjalan dengan baik maka tentunya perasaan saya pun menjadi tenang dan bahagia.
Untuk dapat sepenuhnya yakin bahwa code sudah tercover oleh unit test tentunya dengan mengetahui code coverage.

</details>

<details>
<summary> Tutorial 2 </summary>

## Reflection

1. - menambahkan caption pada tag table di berkas productList.html
2. Sudah menerapkan CI/CD, dimana untuk CI nya sudah di atur di workflow khususnya untuk ci.yml dan sonarcloud.yml, dan untuk CD nya sudah menggunakan koyeb dengan automatic deploy setiap kali dilakukan push/pull req baru.

</details>

<details>
<summary> Tutorial 3 </summary>

1. - SRP: Setiap berkas file menjalankan satu tanggung jawab saja. Contohnya di direktori controller, sebelumnya berkas ProductController.java berisi dua kelas, sekarang sudah dipecah dan ditambah berkas baru CarController.java.
- OCP: Sudah implementasi OCP, misalnya di service, kita bisa melakukan pengembangan dengan menambahkan fungsi2 baru, tapi tidak bisa dilakukan modifikasi.
- LSP: Sudah terimplementasi, karena class ProductController yang sebelumnya adalah superclass dari CarController sudah dihilangkan hubungannya.
- ISP: Sudah terimplementasi, di service, interface CarService ProductService yang terpisah, masing - masing menjalankan method yang spesifik untuk modulnya.
- DIP: Sudah terimplementasi, CarService dan ProductService yang mengabstraksi implementasi dari CarServiceImpl dan ProductServiceImpl.

2. Membuat proyek menjadi mudah di-maintain dan dikelolah. Kualitas code yang meningkat juga dan proses debugging menjadi lebih mudah.

3. Proyek menjadi susah di-maintain dan dikelolah. Kualitas code yang jelek, sehingga code rawan error dan bug, dan proses debugging menjadi lebih sulit juga.

</details>