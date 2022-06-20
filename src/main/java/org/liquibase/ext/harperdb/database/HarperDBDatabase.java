package org.liquibase.ext.harperdb.database;

import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;
import liquibase.statement.SqlStatement;
import liquibase.statement.core.RawCallStatement;

public class HarperDBDatabase extends AbstractJdbcDatabase {

    public static final String PRODUCT_NAME = "CData JDBC Driver for HarperDB 2021";

    @Override
    protected String getDefaultDatabaseProductName() {
        return PRODUCT_NAME;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection databaseConnection) throws DatabaseException {
        String databaseProductName = databaseConnection.getDatabaseProductName();
        return PRODUCT_NAME.equalsIgnoreCase(databaseProductName);
    }

    @Override
    public String getDefaultDriver(String s) {
        return "cdata.jdbc.harperdb.HarperDBDriver";
    }

    @Override
    public String getShortName() {
        return "harperdb";
    }

    @Override
    public Integer getDefaultPort() {
        return 80;
    }

    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DEFAULT;
    }

    @Override
    protected String getConnectionSchemaName(){
        //TODO: implement sane way to query for schema name
        //  use connection.getMetaData().getSchemas() - returns ResultSet
        return "lbcat";
    }



}
