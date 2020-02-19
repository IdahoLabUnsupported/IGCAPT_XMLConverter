package gov.inl.generated.SGComponents;

import javax.persistence.*;

@Entity
public class CollapseIntoData {
    private Short id;
    private int componentId;
    private String guid;
    private Component componentByComponentId;

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "componentId", columnDefinition = "BigInt", insertable = false, updatable = false)
    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Basic
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollapseIntoData that = (CollapseIntoData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (componentId != that.componentId) return false;
        if (guid != null ? !guid.equals(that.guid) : that.guid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (((Integer) componentId).hashCode());
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "componentId", referencedColumnName = "id")
    public Component getComponentByComponentId() {
        return componentByComponentId;
    }

    public void setComponentByComponentId(Component componentByComponentId) {
        this.componentByComponentId = componentByComponentId;
    }
}
