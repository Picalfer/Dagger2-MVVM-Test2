package com.example.dagger2test2.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.dagger2test2.data.BaseDataBase

class MainViewModel(val dataBase: BaseDataBase) {
    //Создаем обозреваемый объект, когда в нем будут изменения, все подсписчики будут уведомлены
    val lifeData = MutableLiveData<List<String>>()
    //Забираем из базы данных список
    fun getDB() {
        lifeData.postValue(dataBase.returnBase())
    }
    //Добавляем в бд элемент
    fun putToDB(string: String) {
        dataBase.add(string)
    }
}