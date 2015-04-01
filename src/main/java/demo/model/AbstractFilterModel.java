package demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Cacheable
@Entity(name = AbstractFilterModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = AbstractFilterModel.NAME)
public class AbstractFilterModel extends AbstractEntityModel {

    /**
     * The type code of the model.
     */
    public final static Integer TYPE_CODE = 100;

    /**
     * The name of the model.
     */
    public final static String NAME = "abstract_filter";

    /**
     * The entity of the AbstractFilterModel
     */
    @Column(precision = 0, unique = false, nullable = true, insertable = true, updatable = true, name = "entity_name", length = 255, scale = 0)
    private String entity;

    /**
     * The description of the AbstractFilterModel
     */
    @Column(precision = 0, unique = false, nullable = true, insertable = true, updatable = true, name = "description", length = 255, scale = 0)
    private String description;

    /**
     * A setter method for the entity
     *
     * @param entity
     */
    public void setEntity(final String entity) {
        this.entity = entity;
    }

    /**
     * A getter method for the entity
     *
     * @return {@link String }
     */
    public String getEntity() {
        return this.entity;
    }

    /**
     * A setter method for the description
     *
     * @param description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * A getter method for the description
     *
     * @return {@link String }
     */
    public String getDescription() {
        return this.description;
    }
}
