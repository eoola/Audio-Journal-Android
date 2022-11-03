package com.wpi.audiojournal.models

import com.squareup.moshi.*
import com.squareup.moshi.internal.Util
import java.lang.reflect.Type
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@Retention(RUNTIME)
@JsonQualifier
@Target(FUNCTION, CLASS, PROPERTY, VALUE_PARAMETER)
annotation class Nested(val key: String)

@Retention(RUNTIME)
@JsonQualifier
@Target(FUNCTION, CLASS, PROPERTY, VALUE_PARAMETER)
annotation class Mapped


internal class NestedFactory : JsonAdapter.Factory {
    companion object {
        val INSTANCE = NestedFactory()
    }


    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        val delegateAnnotations = Types.nextAnnotations(
            annotations,
            Nested::class.java
        ) ?: return null
        val annotation = annotations.toMutableSet().apply {
            removeAll(delegateAnnotations)
        }.first() as Nested

        val delegate = moshi.nextAdapter<Any?>(
            this,
            type,
            delegateAnnotations
        )
        return NestedJsonAdapter(delegate, Nested::key.get(annotation))
    }

    private class NestedJsonAdapter<T>(
        val delegate: JsonAdapter<T>,
        val key: String
    ) : JsonAdapter<T>() {
        override fun fromJson(reader: JsonReader): T? {
            reader.beginObject()
            while (reader.hasNext()) {
                if (reader.nextName().equals(key)) {
                    val nested = delegate.fromJson(reader)
                    reader.endObject()
                    return nested
                }
                reader.skipValue()
            }
            return null
        }

        override fun toJson(writer: JsonWriter, value: T?) =
            throw UnsupportedOperationException(
            "@Nested is only used to deserialize objects."
        )
    }
}

internal class MappedFactory : JsonAdapter.Factory {
    companion object {
        val INSTANCE = MappedFactory()
    }

    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        val delegateAnnotations = Types.nextAnnotations(
            annotations,
            Mapped::class.java
        ) ?: return null
        type as Util.ParameterizedTypeImpl
        val newType = Types.newParameterizedType(
            Map::class.java,
            Any::class.java,
            type.typeArguments.first()
        )
        val delegate = moshi.nextAdapter<Map<*,*>>(
            this,
            newType,
            delegateAnnotations
        )
        return MappedJsonAdapter(delegate)
    }

    private class MappedJsonAdapter<T>(
        val delegate: JsonAdapter<Map<*, T>>
        ) : JsonAdapter<List<T>>() {
        override fun fromJson(reader: JsonReader): List<T> {
            return delegate.fromJson(reader)?.values?.toList() ?: listOf()
        }

        override fun toJson(writer: JsonWriter, value: List<T>?) =
            throw UnsupportedOperationException(
            "@Mapped is only used to deserialize objects."
        )
    }
}