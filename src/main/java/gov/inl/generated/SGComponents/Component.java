package gov.inl.generated.SGComponents;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Component {
    private Integer id;
    private Boolean aggregate;
    private Integer componentGroupId;
    private String iconPath;
    private String name;
    private Boolean passthrough;
    private String uuid;
    private String description;
    private Collection<CollapseIntoData> collapseIntoDataById;
    private ComponentGroup componentGroupByComponentGroupId;
    private Collection<Field> fieldsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aggregate")
    public Boolean getAggregate() {
        return aggregate;
    }

    public void setAggregate(Boolean aggregate) {
        this.aggregate = aggregate;
    }

    @Basic
    @Column(name = "componentGroupId", insertable = false, updatable = false)
    public Integer getComponentGroupId() {
        return componentGroupId;
    }

    public void setComponentGroupId(Integer componentGroupId) {
        this.componentGroupId = componentGroupId;
    }

    @Basic
    @Column(name = "iconPath")
    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "passthrough")
    public Boolean getPassthrough() {
        return passthrough;
    }

    public void setPassthrough(Boolean passthrough) {
        this.passthrough = passthrough;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        if (!Objects.equals(id, component.id)) return false;
        if (!Objects.equals(aggregate, component.aggregate)) return false;
        if (!Objects.equals(componentGroupId, component.componentGroupId))
            return false;
        if (!Objects.equals(iconPath, component.iconPath)) return false;
        if (!Objects.equals(name, component.name)) return false;
        if (!Objects.equals(passthrough, component.passthrough))
            return false;
        if (!Objects.equals(uuid, component.uuid)) return false;
        if (!Objects.equals(description, component.description))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aggregate != null ? aggregate.hashCode() : 0);
        result = 31 * result + (componentGroupId != null ? componentGroupId.hashCode() : 0);
        result = 31 * result + (iconPath != null ? iconPath.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passthrough != null ? passthrough.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "componentByComponentId")
    public Collection<CollapseIntoData> getCollapseIntoDataById() {
        return collapseIntoDataById;
    }

    public void setCollapseIntoDataById(Collection<CollapseIntoData> collapseIntoDataById) {
        this.collapseIntoDataById = collapseIntoDataById;
    }

    @ManyToOne
    @JoinColumn(name = "componentGroupId", referencedColumnName = "id")
    public ComponentGroup getComponentGroupByComponentGroupId() {
        return componentGroupByComponentGroupId;
    }

    public void setComponentGroupByComponentGroupId(ComponentGroup componentGroupByComponentGroupId) {
        this.componentGroupByComponentGroupId = componentGroupByComponentGroupId;
    }

    @OneToMany(mappedBy = "componentByComponentId")
    public Collection<Field> getFieldsById() {
        return fieldsById;
    }

    public void setFieldsById(Collection<Field> fieldsById) {
        this.fieldsById = fieldsById;
    }
}
