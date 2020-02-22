package gov.inl.generated.SGComponents;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Field {
    private Integer id;
    private String name;
    private Integer payload;
    private Integer componentId;
    private Component componentByComponentId;
    private Collection<UsecaseField> usecaseFieldsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "payload")
    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    @Basic
    @Column(name = "componentId", insertable = false, updatable = false)
    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (id != field.id) return false;
        if (payload != field.payload) return false;
        if (name != null ? !name.equals(field.name) : field.name != null) return false;
        if (componentId != null ? !componentId.equals(field.componentId) : field.componentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) payload;
        result = 31 * result + (componentId != null ? componentId.hashCode() : 0);
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

    @OneToMany(mappedBy = "fieldByFieldId")
    public Collection<UsecaseField> getUsecaseFieldsById() {
        return usecaseFieldsById;
    }

    public void setUsecaseFieldsById(Collection<UsecaseField> usecaseFieldsById) {
        this.usecaseFieldsById = usecaseFieldsById;
    }
}
