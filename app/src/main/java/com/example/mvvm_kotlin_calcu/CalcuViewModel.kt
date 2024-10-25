package com.example.mvvm_kotlin_calcu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcuViewModel : ViewModel() {

    private val calculator = Calcu()

    /**
     * LiveData : 외부에서 데이터 읽기만 가능
     * MutableLiveData : 외부에서 데이터 읽기/쓰기 가능
     * postValue : WorkThread , UI Thread 둘다 사용 가능한 함수 , 해당 함수 호출 시 데이터를 메인 쓰레드로 전송
     * setValue : UI Thread에서만 동작 , UI 화면 업데이트 할떄 사용
     * IllegalArgumentException : 잘못된 파라미터를 넣었을 떄 적용되는 Exception
     * **/
    private val _result = MutableLiveData<Int>()
    // LiveData 로 view에서 데이터를 observe
    val result: LiveData<Int> = _result

    fun performOperation(a: Int, b: Int, operation: String) {
        val result = when (operation) {
            "+" -> calculator.add(a, b)
            "-" -> calculator.subtract(a, b)
            "*" -> calculator.multiply(a, b)
            "/" -> calculator.divide(a, b)
            else -> throw IllegalArgumentException("Invalid operation")
        }
        _result.value = result
    }
}