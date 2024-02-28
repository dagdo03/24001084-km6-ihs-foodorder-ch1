package app.datasource

import app.model.ListMenu


interface DataList {
    fun getFruitList() : List<ListMenu>
}

class DataSourceImpl() : DataList {
    override fun getFruitList(): List<ListMenu> {
        return listOf(
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
    }
}