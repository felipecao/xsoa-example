package br.unirio.xsoa.dbunit;

import java.sql.Connection;

/**
 * @author https://github.com/rgalba
 * @see https://github.com/rgalba/BlankProject
 * @see https://github.com/rgalba/BlankProject/blob/master/test/testing/DbUnitManager.java
 */
public interface DbUnitManager {

    /**
     * Atualiza o banco com os dados do arquivo xml, porém não altera os
     * registros anteriormente inseridos no banco e que não existem no arquivo
     * xml.
     */
    void refresh(String dbUnitXmlPath);

    /**
     * Deleta todos os dados de cada tabela e em seguida insere os registros encontrados no arquivo xml.
     */
    void cleanAndInsert(String dbUnitXmlPath);

    /**
     * @author uq4m
     */
    void cleanAndInsert(Class classe);

    /**
     * Insere os dados encontrados no arquivo xml.
     */
    void insert(String dbUnitXmlPath);

    /**
     * Atualiza os registros encontrados no arquivo xml.
     */
    void update(String dbUnitXmlPath);

    /**
     * Deleta os registros encontrados no arquivo xml.
     */
    void delete(String dbUnitXmlPath);

    /**
     * Deleta todos os dados de cada tabela encontrada no arquivo xml.
     */
    void deleteAll(String dbUnitXmlPath);

    /**
     * Limpa o banco e popula apenas com os dados básicos.
     */
    void clear();

    void dump(String dbUnitXmlPath);

    public Connection getConnection();

}
