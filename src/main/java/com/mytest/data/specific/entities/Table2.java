package com.mytest.data.specific.entities;


import com.mytest.data.common.entities.AbstractIdEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "table_2")
@NamedQueries({@NamedQuery(name = Table2.NamedQueries.GetTable2.NAME, query = Table2.NamedQueries.GetTable2.QUERY)})
public class Table2 extends AbstractIdEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_1_id", referencedColumnName = "id")
    private Table1 table1;

    @Column(name = "some_info", nullable = false)
    private String someInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_2_id")
    private List<Table3> table3List;

    public Table1 getTable1() {
        return table1;
    }

    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    public String getSomeInfo() {
        return someInfo;
    }

    public void setSomeInfo(String someInfo) {
        this.someInfo = someInfo;
    }

    public List<Table3> getTable3List() {
        return table3List;
    }

    public void setTable3List(List<Table3> table3List) {
        this.table3List = table3List;
    }

    /**
     * The named queries.
     */
    public static final class NamedQueries {

        private NamedQueries() {
        }

        public static final class GetTable2 {

            /**
             * The query name.
             */
            public static final String NAME = "Table1.NamedQueries.GetTable2";
            /**
             * The query.
             **/
            public static final String QUERY = "SELECT t FROM Table2 t WHERE t.someInfo = :someInfo "
                    + "AND t.table1 = :table1";

            private GetTable2() {
            }
        }
    }
}