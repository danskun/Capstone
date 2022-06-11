package com.example.w3c.models

import com.example.w3c.Post
import com.example.w3c.R


object DummyData {
    private val postNames = arrayOf(
        "Andika Rahmat",
        "Budianto",
        "Cindi Lela",
        "David Bekam",
        "Ega Saputra",
        "Fiona Falala",
        "George Slamet",
        "Hendra Hap",
        "Iin Tan",
        "Joko Nawar"
    )



    private val postSingkat = arrayOf(
        "Saya akan membantu belanja ke pasar",
        "Saya akan membantu belanja ke pasar",
        "Saya akan membantu anak Anda dalam belajar",
        "Saya akan mengirimkan barang Anda",
        "Saya akan membantu belanja ke pasar",
        "Saya akan membantu belanja ke pasar",
        "Saya akan membantu belajar ke pasar",
        "Saya akan membantu mengirimkan barang Anda",
        "Saya akan membantu anak Anda dalam belajar",
        "Saya akan membantu mengirimkan barang Anda"
    )

    private val postDescription = arrayOf(
        "Perkenalkan nama saya Andika Rahmat bisa juga dipanggil Dika, " +
                "Selama masa pandemi ini saya dikeluarkan dari pekerjaan saya sebelumnya. " +
                "Untuk tetap dapat melanjutkan hidup, saya berniat untuk mencari kerja sampingan yang halal. " +
                "Saya dapat membantu anda untuk belanja ke pasar. " +
                "Saya sudah terbiasa belanja sendiri, mengenai proses tawar menawar harga dapat anda percayakan kepada saya.",
        "Hai, nama saya Budi, " +
                "selama masa pandemi ini saya memutuskan untuk mencari pekerjaan sampingan setelah saya terpaksa dikeluarkan dari tempat kerja saya sebelumnya. " +
                "Sebelum bergabung dengan platform ini, saya sudah melakukan pembelanjaan ke pasar untuk orang yang menyewa jasa saya. " +
                "Saya belanja di pasar pilihan klien. Harga bisa menyesuaikan" +
                "Mari lindungi diri anda dan keluarga dengan menggunakan jasa saya untuk berbelanja ke pasar.",
        "Halo halo, nama saya Cindi" +
                "Dikarenakan pandemi COVID-19 saya terpaksa dikeluarkan dari pekerjaan saya sebelumnya sebagai guru les di salah satu bimbel private di Jaksel. " +
                "Disini saya mau tawarkan jasa saya untuk membantu anak-anak bapak/ibu dalam belajar. " +
                "Saya sudah berpengalaman lebih dari 5 tahun dalam mengajar. " +
                "Saya siap dihubungi kapanpun untuk menentukan waktu dan platform yang digunakan untuk berkomunikasi dengan anak anda saat belajar.",
        "Saya David Bekam, " +
                "dan saya menyewakan jasa saya untuk mengirimkan barang-barang anda dengan harga yang lebih murah dibandingkan penyedia jasa pengiriman barang lainnya. " +
                "Selain mengirim barang, saya juga dapat membantu hal-hal lain yang mungkin anda butuhkan selama masa pandemi ini. " +
                "Jangan ragu-ragu untuk menghubungi saya. " +
                "Saya akan sangat senang.",
        "Perkenalkan nama aku Ega Saputra, " +
                "Bisa juga dipanggil Ega. " +
                "Baru saja lulus dari salah satu universitas swasta di kota Medan. " +
                "Adanya COVID-19 menyebabkan sulit mendapatkan pekerjaan." +
                "Platform digunakan untuk membantu mendapatkan pekerjaan sampingan. Saya bisa membantu untuk belanja ke pasar dan bahkan melakukan proses tawar menawar harga dengan penjual",
        "Halo semuanya, nama saya Fiona " +
                "Jika sekiranya ada teman/saudara/kerabat kalian yang butuh jasa belanja ke pasar di sekitar area kota Bogor saya akan sangat bersedia. " +
                "Keberadaan COVID-19 ini memaksakan saya harus mencari pekerjaan sampingan setelah dikeluarkan dari perusahaan saya bekerja sebelumnya. " +
                "Jangan ragu-ragu untuk menghubungi saya. " +
                "Saya siap.",
        "Perkenalkan nama saya George, " +
                "saya akan membantu anda berbelanja kebutuhan dapur seperti bahan masakan di sekitar kecamatan Lowokwaru. " +
                "Saya sudah terbiasa melakukan tawar menawar harga. " +
                "Saya tersedia kapanpun anda butuhkan. " +
                "Segera hubungi saya.",
        "Haii, perkenalkan nama saya Hendra! " +
                "Adanya pandemi covid-19 ini menyebabkan saya harus kehilangan pekerjaan saya " +
                "Jika teman-teman membutuhkan jasa untuk mengirimkan barang yang lebih murah, " +
                "saya bersedia untuk membantu. " +
                "Silakan hubungi saya dengan menekan tombol di bawah ya.",
        "Hai semuanya, nama saya Iin " +
                "Meskipun dikeluarkan dari pekerjaan sebelumnya akibat COVID-19 ini tapi saya mau tetap berusaha mendapatkan " +
                "pemasukan dengan cara yang benar. Saya sudah terbiasa mengajar anak SD-SMA. " +
                "Jika bapak/ibu/kakak/adik/teman-teman disini ada yang mau menggunakan jasa mengajar saya, saya sangat bersedia. " +
                "Saya bisa mengajar subjek mata pelajaran apapun. Terimakasih banyak.",
        "Perkenalkan nama saya Joko, " +
                "jika anda membutuhkan jasa pengiriman barang yang lebih murah, anda dapat menghubungi saya. " +
                "Saya akan memastikan barang anda tiba dengan tepat waktu (bahkan lebih cepat jika diperlukan). " +
                "Silakan hubungi saya dengan menekan tombol di bawah. " +
                "Harga sangat bisa dinegosiasikan."
    )


    private val postImages = intArrayOf(
        R.drawable.andika_rahmat,
        R.drawable.budianto,
        R.drawable.cindi_lela,
        R.drawable.david_bekam,
        R.drawable.ega_saputra,
        R.drawable.fiona_falala,
        R.drawable.george_slamet,
        R.drawable.hendra_hap,
        R.drawable.iin_tan,
        R.drawable.joko_nawar
    )


    val listData: ArrayList<Post>
        get() {
            val list = arrayListOf<Post>()
            for (position in postNames.indices) {
                val posting = Post()
                posting.user = postNames[position]
                posting.singkat = postSingkat[position]
                posting.description = postDescription[position]
                posting.photo = postImages[position]
                list.add(posting)
            }
            return list
        }
}