package app.controller

import app.model.ListMenu

class MenuController(val name : String? = "Ihsan") {
    private val menu = listOf(
        ListMenu(
            Name = "Ayam Bakar",
            Price = 50000,
        ), // menu 1
        ListMenu(
            Name = "Ayam Goreng",
            Price = 40000,
        ), // menu 2
        ListMenu(
            Name = "Ayam Geprek",
            Price = 40000,
        ), // menu 3
        ListMenu(
            Name = "Kulit Ayam Crispy",
            Price = 15000,
        ), // menu 4
        ListMenu(
            Name = "Sate Usus Ayam",
            Price = 5000,
        ), // menu 5
    )
    // function to print header
    private fun printHeader(){
        println("=====================================")
        println("Selamat datang di Warung Binar $name")
        println("=====================================")
        printMenu()
    }
    // function to print menu
    private fun printMenu(){
        menu.forEachIndexed{index, data ->
            println("${index + 1}. ${data.Name} : ${formatPrice(data.Price)}")
        }
    }
    // function to choose food
    private fun userInput(){
        println("Pilih menu makanan:")
        try {
            val opt = readln().toInt()
            if (opt >= 1 && opt <= menu.size) {
                val menu = menu[opt - 1]
                val formattedPrice = formatPrice(menu.Price)
                println("Kamu memilih menu $opt")
                println("Nama Menu: ${menu.Name}\nHarga: $formattedPrice")
                payment(menu.Price)
            } else {
                println("Pilihan menu yang anda masukkan tidak valid")
                userInput()
            }
        }catch (e: NumberFormatException){
            println("Inputan tidak valid")
            userInput()
        }
    }
    // function to input amount of money
    private fun payment(price : Int){
        try {
            println("Masukkan Pembayaran :")
            val money = readln().toInt()
            if (money < price){
                println("Pembayaran anda gagal")
                payment(price)
            }
            else{
                println("Terima kasih anda berhasil melakukan pembayaran")
                order()
            }

        }catch (e: NumberFormatException){
            println("Masukan salah")
            payment(price)
        }
    }
    // function to order wanna delivery or take away
    private fun order(){
        println("Metode Pengiriman Makanan")
        println("1. Take Away\n2. Delivery")
        try {
            val opt = readln().toInt()
            if (opt >= 1 && opt <= menu.size) {
                if(opt == 1) {
                    println("Makananmu sedang dimasak (5 detik) .....")
                    Thread.sleep(5000)
                    println("Makananmu sudah siap! Silakan ambil di resto ya! (5 detik) .....")
                    Thread.sleep(5000)
                    println("Pesanan selesai! (3 detik) .....")
                    Thread.sleep(5000)
                }
                else if (opt == 2){
                    println("Makananmu sedang dimasak (5 detik) .....")
                    Thread.sleep(5000)
                    println("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) .....")
                    Thread.sleep(5000)
                    println("Driver sampai! Pesanan Selesai! (3 detik) .....")
                    Thread.sleep(5000)
                }
                else{
                    println("Inputan salah")
                    order()
                }
            } else {
                println("Pilihan menu yang anda masukkan tidak valid")
                order()
            }
        }catch (e: NumberFormatException){
            println("Inputan tidak valid")
            order()
        }
    }
    // function to show price with format price like this : Rp 50.000
    private fun formatPrice(price: Int): String {
        val priceString = price.toString()
        val length = priceString.length
        return if (length <= 3) {
            "Rp. $priceString"
        } else {
            val builder = StringBuilder()
            var dotPosition = length % 3
            if (dotPosition == 0) dotPosition = 3
            for (i in 0 until length) {
                builder.append(priceString[i])
                if (i + 1 == dotPosition && i != length - 1) {
                    builder.append('.')
                    dotPosition += 3
                }
            }
            "Rp. ${builder.toString()}"
        }
    }
    fun run(){
        printHeader()
        userInput()
    }
}