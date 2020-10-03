package ru.hotel.management.central.repository

import org.hibernate.dialect.PostgreSQL95Dialect
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor
import java.sql.Types

class FixedPostgreSQLDialect : PostgreSQL95Dialect() {
    override fun remapSqlTypeDescriptor(sqlTypeDescriptor: SqlTypeDescriptor): SqlTypeDescriptor {
        return if (sqlTypeDescriptor.getSqlType() === Types.BLOB) {
            BinaryTypeDescriptor.INSTANCE
        } else super.remapSqlTypeDescriptor(sqlTypeDescriptor)
    }

    init {
        registerColumnType(Types.BLOB, "bytea")
    }
}