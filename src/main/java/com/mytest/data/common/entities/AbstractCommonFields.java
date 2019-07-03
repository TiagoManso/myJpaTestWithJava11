package com.mytest.data.common.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigInteger;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractCommonFields extends AbstractIdEntity {

    @Column(name = "some_string")
    private String someString;

    @Column(name = "some_big_int")
    private BigInteger someBigInt;

    @Column(name = "receive_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDateTime;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(final String requestingPartyId) {
        this.someString = requestingPartyId;
    }

    public BigInteger getSomeBigInt() {
        return someBigInt;
    }

    public void setSomeBigInt(final BigInteger mcfCounter) {
        this.someBigInt = mcfCounter;
    }

    public Date getReceiveDateTime() {
        return receiveDateTime;
    }

    public void setReceiveDateTime(final Date receiveDateTime) {
        this.receiveDateTime = receiveDateTime;
    }

}
