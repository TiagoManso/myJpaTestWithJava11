package com.mytest.data.specific.entities;

import com.mytest.data.common.entities.AbstractIdEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "table_3")
public class Table3 extends AbstractIdEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_2_id", referencedColumnName = "id")
    private Table2 table2;

    @Lob
    @Column(name = "some_bytes", nullable = false)
    private byte[] someBytes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_3_id")
    private List<Table4> table4List;

    public Table2 getInstallationId() {
        return table2;
    }

    public void setInstallationId(Table2 installationId) {
        this.table2 = installationId;
    }

    public byte[] getSomeBytes() {
        return someBytes;
    }

    public void setSomeBytes(byte[] someBytes) {
        this.someBytes = someBytes;
    }

    public List<Table4> getTable4List() {
        return table4List;
    }

    public void setTable4List(final List<Table4> table4List) {
        this.table4List = table4List;
    }
}
