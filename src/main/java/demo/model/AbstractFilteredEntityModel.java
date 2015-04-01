package demo.model;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = AbstractFilteredEntityModel.NAME)
public abstract class AbstractFilteredEntityModel extends AbstractEntityModel {

    /**
     * The name of the model.
     */
    public final static String NAME = "abstract_filtered_entity";

    /**
     * The filters of the AbstractFilteredEntityModel
     */
    @ManyToMany(targetEntity = AbstractFilterModel.class, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(indexes = { @Index(unique = false, columnList = "entity_pk") }, inverseJoinColumns = {
                    @JoinColumn(unique = false, nullable = true, insertable = true, updatable = true, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), name = "filter_pk") }, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), joinColumns = {
                    @JoinColumn(unique = false, nullable = true, insertable = true, updatable = true, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), name = "entity_pk") }, inverseForeignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), name = "entity_filters")
    private Collection<AbstractFilterModel> filters;

    /**
     * A setter method for the filters
     *
     * @param filters
     */
    public void setFilters(final Collection<AbstractFilterModel> filters) {
        this.filters = filters;
    }

    /**
     * A getter method for the filters
     *
     * @return {@link Collection }{@code <}{@link AbstractFilterModel }{@code >}
     */
    public Collection<AbstractFilterModel> getFilters() {
        return this.filters;
    }
}

