package com.mytest.data.specific.entities;

import com.mytest.data.common.entities.AbstractIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Table4
 */
@Entity
@Table(name = "table_4")
public class Table4 extends AbstractIdEntity {

    /**
     * field file_id in DB, is a FK to the MigrationValidationFile ID
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_3_id", referencedColumnName = "id")
    private Table3 table3;

    @Column(name = "one_last_string", nullable = false)
    private String oneLastString;

    public Table3 getTable3() {
        return table3;
    }

    public void setTable3(final Table3 table3) {
        this.table3 = table3;
    }

    public String getOneLastString() {
        return oneLastString;
    }

    public void setOneLastString(final String oneLastString) {
        this.oneLastString = oneLastString;
    }
}
