## Tutorial 1

## Reflection 1

Beberapa standard clean code yang sudah saya terapkan:
- Penamaan variable dan method yang cukup menjelaskan fungsi dari variable dan method tersebut.
- Pembuatan method secara pendek, berisi 1 kegunaan saja sesuai namanya.
- beberapa comments
Adapun beberapa kesalahan yang saya jumpai:
- Membuat product tanpa di-set idnya -> solusi dengan melakukan setId di ProductRepository
- Kesalahan nama url di template -> memperbaiki penamaan url

## Reflection 2

https://eshop-nano141004.koyeb.app/product/list

1. Setelah membuat unit test pastinya saya merasa code saya lebih reliable dalam menghadapi edge case. Jika terdapat error maka tinggal di debug, dan jika ternyata berjalan dengan baik maka tentunya perasaan saya pun menjadi tenang dan bahagia.
Untuk dapat sepenuhnya yakin bahwa code sudah tercover oleh unit test tentunya dengan mengetahui code coverage.


# Tutorial 2

## Reflection

1. - menambahkan caption pada tag table di berkas productList.html
2. Sudah menerapkan CI/CD, dimana untuk CI nya sudah di atur di workflow khususnya untuk ci.yml dan sonarcloud.yml, dan untuk CD nya sudah menggunakan koyeb dengan automatic deploy setiap kali dilakukan push/pull req baru.