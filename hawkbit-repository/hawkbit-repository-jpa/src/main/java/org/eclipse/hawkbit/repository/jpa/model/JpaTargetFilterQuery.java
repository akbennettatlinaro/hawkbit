/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.repository.jpa.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.eclipse.hawkbit.repository.model.DistributionSet;
import org.eclipse.hawkbit.repository.model.TargetFilterQuery;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Stored target filter.
 *
 */
@Entity
@Table(name = "sp_target_filter_query", indexes = {
        @Index(name = "sp_idx_target_filter_query_01", columnList = "tenant,name") }, uniqueConstraints = @UniqueConstraint(columnNames = {
                "name", "tenant" }, name = "uk_tenant_custom_filter_name"))
// exception squid:S2160 - BaseEntity equals/hashcode is handling correctly for
// sub entities
@SuppressWarnings("squid:S2160")
public class JpaTargetFilterQuery extends AbstractJpaTenantAwareBaseEntity implements TargetFilterQuery {
    private static final long serialVersionUID = 7493966984413479089L;

    @Column(name = "name", length = 64, nullable = false)
    @Size(max = 64)
    @NotEmpty
    private String name;

    @Column(name = "query", length = 1024, nullable = false)
    @Size(max = 1024)
    @NotEmpty
    private String query;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, targetEntity = JpaDistributionSet.class)
    @JoinColumn(name = "auto_assign_distribution_set", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_filter_auto_assign_ds"))
    private JpaDistributionSet autoAssignDistributionSet;

    public JpaTargetFilterQuery() {
        // Default constructor for JPA.
    }

    /**
     * Construct a Target filter query with auto assign distribution set
     * 
     * @param name
     *            of the {@link TargetFilterQuery}.
     * @param query
     *            of the {@link TargetFilterQuery}.
     * @param autoAssignDistributionSet
     *            of the {@link TargetFilterQuery}.
     */
    public JpaTargetFilterQuery(final String name, final String query,
            final DistributionSet autoAssignDistributionSet) {
        this.name = name;
        this.query = query;
        this.autoAssignDistributionSet = (JpaDistributionSet) autoAssignDistributionSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getQuery() {
        return query;
    }

    public void setQuery(final String query) {
        this.query = query;
    }

    @Override
    public DistributionSet getAutoAssignDistributionSet() {
        return autoAssignDistributionSet;
    }

    public void setAutoAssignDistributionSet(final JpaDistributionSet distributionSet) {
        this.autoAssignDistributionSet = distributionSet;
    }
}
