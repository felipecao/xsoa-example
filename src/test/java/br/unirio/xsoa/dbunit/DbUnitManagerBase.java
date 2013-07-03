package br.unirio.xsoa.dbunit;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @author https://github.com/rgalba
 * @see https://github.com/rgalba/BlankProject
 * @see https://github.com/rgalba/BlankProject/blob/master/test/testing/DbUnitManagerBase.java
 */
public class DbUnitManagerBase implements DbUnitManager {

    public static final String XML_COM_DADOS_BASICOS = "";
    private boolean loadDefaultDataSet = true;
    DataSource dataSource;

    public DbUnitManagerBase() {
        this(true);
    }

    public DbUnitManagerBase(boolean loadDefaultDataSet) {
        this.loadDefaultDataSet = loadDefaultDataSet;
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Erro ao tentar obter uma conexão com o banco: "
                            + e.getMessage());
        }
        return conn;
    }

    public void refresh(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.CLEAN_INSERT.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void cleanAndInsert(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.CLEAN_INSERT.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void cleanAndInsert(Class classe){
        try {

            String className = classe.getName().toString();
            String classXmlPath = className.replace(".", "/") + ".xml";

            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.CLEAN_INSERT.execute(dbconn, this
                    .getDataSetFrom(classXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void insert(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.INSERT.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.UPDATE.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.DELETE.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteAll(String dbUnitXmlPath) {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.DELETE_ALL.execute(dbconn, this
                    .getDataSetFrom(dbUnitXmlPath));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void clear() {
        try {
            IDatabaseConnection dbconn = this.getDbUnitConnection();
            DatabaseOperation.CLEAN_INSERT.execute(dbconn, new FlatXmlDataSet(
                    new FileInputStream(XML_COM_DADOS_BASICOS)));
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private IDataSet getDataSetFrom(String dbUnitXmlPath) throws IOException,
            DataSetException {
        String classDatasetXmlFullPath = "./src/test/resources/" + dbUnitXmlPath;
        File classDataset = new File(classDatasetXmlFullPath);
        return new FlatXmlDataSet(classDataset);
    }

    private IDatabaseConnection getDbUnitConnection()
            throws DatabaseUnitException, SQLException {
        return new DatabaseConnection(this.getConnection());
    }

    public void dump(String dbUnitXmlPath) {
        try {
            IDatabaseConnection connection = new DatabaseConnection(
                    getConnection());
            IDataSet iDataSet = connection.createDataSet();
            FlatXmlDataSet.write(iDataSet, new FileOutputStream(dbUnitXmlPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
