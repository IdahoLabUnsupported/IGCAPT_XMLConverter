package gov.inl.generated.SGComponents;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ComponentGroup {
    private Integer id;
    private int componentListId;
    private Object display;
    private String groupName;
    private Collection<Component> componentsById;
    private ComponentList componentListByComponentListId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "componentListId", columnDefinition = "BigInt", insertable = false, updatable = false)
    public int getComponentListId() {
        return componentListId;
    }

    public void setComponentListId(int componentListId) {
        this.componentListId = componentListId;
    }

    @Basic
    @Column(name = "groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentGroup that = (ComponentGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (componentListId != that.componentListId)
            return false;
        if (display != null ? !display.equals(that.display) : that.display != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (((Integer) componentListId).hashCode());
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "componentGroupByComponentGroupId")
    public Collection<Component> getComponentsById() {
        return componentsById;
    }

    public void setComponentsById(Collection<Component> componentsById) {
        this.componentsById = componentsById;
    }

    @ManyToOne
    @JoinColumn(name = "componentListId", referencedColumnName = "id")
    public ComponentList getComponentListByComponentListId() {
        return componentListByComponentListId;
    }

    public void setComponentListByComponentListId(ComponentList componentListByComponentListId) {
        this.componentListByComponentListId = componentListByComponentListId;
    }
}
