package org.liquibase.ext.harperdb.database;

import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

public class HarperDBDatabase extends AbstractJdbcDatabase {

    public static final String PRODUCT_NAME = "HarperDB";

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
        return PRODUCT_NAME;
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
}
