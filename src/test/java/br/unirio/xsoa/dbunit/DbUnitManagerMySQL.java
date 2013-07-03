package br.unirio.xsoa.dbunit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author https://github.com/rgalba
 * @see https://github.com/rgalba/BlankProject
 * @see https://github.com/rgalba/BlankProject/blob/master/test/testing/DbUnitManagerOracle.java
 */
@Component
public class DbUnitManagerMySQL extends DbUnitManagerBase {

    @Autowired
    public DbUnitManagerMySQL(DataSource dataSource) {
        this();
        this.dataSource = dataSource;
    }

    public DbUnitManagerMySQL() {
        super(false);
    }
}
