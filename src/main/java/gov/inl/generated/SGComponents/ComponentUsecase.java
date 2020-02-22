package gov.inl.generated.SGComponents;

import javax.persistence.*;

@Entity
@Table(name = "component_usecase", schema = "main", catalog = "")
public class ComponentUsecase {
    private Integer id;
    private Integer usecaseId;
    private Integer componentId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {this.id = id;}

    @Basic
    @Column(name = "usecaseId")
    public Integer getUsecaseId() {
        return usecaseId;
    }

    public void setUsecaseId(Integer usecaseId) {
        this.usecaseId = usecaseId;
    }

    @Basic
    @Column(name = "componentId")
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
