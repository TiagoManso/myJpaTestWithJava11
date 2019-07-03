package com.mytest.data.specific.entities;

import com.mytest.data.common.entities.AbstractCommonFields;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "table_1")
@NamedQueries({@NamedQuery(name = Table1.NamedQueries.GetUnprocessed.NAME, query = Table1.NamedQueries.GetUnprocessed.QUERY),
        @NamedQuery(name = Table1.NamedQueries.GetProcessed.NAME, query = Table1.NamedQueries.GetProcessed.QUERY),
        @NamedQuery(name = Table1.NamedQueries.GetSpecific.NAME, query = Table1.NamedQueries.GetSpecific.QUERY)})
public class Table1 extends AbstractCommonFields {

    @Column(name = "other_big_int", nullable = false)
    private BigInteger otherBigInt;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_1_id")
    private List<Table2> table2List;

    public BigInteger getOtherBigInt() {
        return otherBigInt;
    }

    public void setOtherBigInt(BigInteger mefCounter) {
        this.otherBigInt = mefCounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusLoaded() {
        status = "LOADED";
    }

    public void setStatusProcessed() {
        status = "PROCESSED";
    }

    public List<Table2> getTable2List() {
        return table2List;
    }

    public void setTable2List(List<Table2> table2List) {
        this.table2List = table2List;
    }

    /**
     * The named queries.
     */
    public static final class NamedQueries {

        private NamedQueries() {
        }

        public static final class GetUnprocessed {

            /**
             * The query name.
             */
            public static final String NAME = "File.NamedQueries.GetUnprocessed";
            /**
             * The query.
             **/
            public static final String QUERY = "SELECT t FROM Table1 t WHERE t.status != 'PROCESSED'";

            private GetUnprocessed() {
            }
        }

        public static final class GetProcessed {

            /**
             * The query name.
             */
            public static final String NAME = "File.NamedQueries.GetProcessed";
            /**
             * The query.
             **/
            public static final String QUERY = "SELECT t FROM Table1 t WHERE t.status = 'PROCESSED'";

            private GetProcessed() {
            }
        }

        public static final class GetSpecific {

            /**
             * The query name.
             */
            public static final String NAME = "File.NamedQueries.GetSpecific";
            /**
             * The query.
             **/
            public static final String QUERY = "SELECT t FROM Table1 t WHERE t.someString = :someString AND "
                    + "t.someBigInt = :someBigInt";

            private GetSpecific() {
            }
        }
    }
}