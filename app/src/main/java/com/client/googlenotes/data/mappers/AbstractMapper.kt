package com.client.googlenotes.data.mappers

import java.lang.reflect.ParameterizedType

abstract class AbstractMapper <Q, V> {

    abstract fun map(value: Q) : V

    fun reverseMap(value: V): Q {
        val t1 = ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<*>).simpleName

        val t2 = ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<*>).simpleName

        throw UnsupportedOperationException(String.format("Unsupported conversion from %s to %s", t1, t2))
    }

    fun map(values: List<Q>?): List<V>? {
        if(values == null){
            return null
        }

        val returnedValues: MutableList<V> = ArrayList(values.size)

        for(value: Q in values) {
            returnedValues.add(map(value))
        }

        return returnedValues
    }

    fun reverseMap(values: List<V>?): List<Q>? {

        if (values == null) {
            return null
        }


        val returnedValues: MutableList<Q> = ArrayList(values.size)

        for(value: V in values) {
            returnedValues.add(reverseMap(value))
        }

        return returnedValues
    }
}