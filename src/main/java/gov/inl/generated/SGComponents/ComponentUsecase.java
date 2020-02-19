package gov.inl.generated.SGComponents;

import javax.persistence.*;

@Entity
@Table(name = "component_usecase", schema = "main", catalog = "")
public class ComponentUsecase {
    private Short id;
    private int usecaseId;
    private int componentId;

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }
    public void setId(Short id) {this.id = id;}

    @Basic
    @Column(name = "usecaseId")
    public int getUsecaseId() {
        return usecaseId;
    }

    public void setUsecaseId(int usecaseId) {
        this.usecaseId = usecaseId;
    }

    @Basic
    @Column(name = "componentId")
    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentUsecase that = (ComponentUsecase) o;

        if (usecaseId != that.usecaseId) return false;
        return componentId == that.componentId;
    }

    @Override
    public int hashCode() {
        int result = ((Integer)usecaseId).hashCode();
        result = 31 * result + ((Integer) componentId).hashCode();
        return result;
    }
}
