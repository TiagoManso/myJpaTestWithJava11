package com.mytest.data.common.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "audit_create_date_time", nullable = false)
    private Long auditCreateDateTime;

    @Column(name = "audit_update_date_time", nullable = false)
    private Long auditUpdateDateTime;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    public Long getAuditCreateDateTime() {
        return auditCreateDateTime;
    }

    public void setAuditCreateDateTime(final Long auditCreateDateTime) {
        this.auditCreateDateTime = auditCreateDateTime;
    }

    public Long getAuditUpdateDateTime() {
        return auditUpdateDateTime;
    }

    public void setAuditUpdateDateTime(final Long auditUpdateDateTime) {
        this.auditUpdateDateTime = auditUpdateDateTime;
    }

    @PrePersist
    private void updateCreateAuditData() {
        final long currentDatetime = System.currentTimeMillis();
        auditCreateDateTime = currentDatetime;
        auditUpdateDateTime = currentDatetime;
    }

    @PreUpdate
    private void updateChangeAuditData() {
        auditUpdateDateTime = System.currentTimeMillis();
    }

}
