package gov.inl.generated.SGComponents;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Usecase {
    private Integer id;
    private String name;
    private Integer latency;
    private String description;
    private Collection<DataElement> dataElementsById;
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
    @Column(name = "latency")
    public Integer getLatency() {
        return latency;
    }

    public void setLatency(Integer latency) {
        this.latency = latency;
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

        Usecase usecase = (Usecase) o;

        if (id != usecase.id) return false;
        if (name != null ? !name.equals(usecase.name) : usecase.name != null) return false;
        if (latency != null ? !latency.equals(usecase.latency) : usecase.latency != null) return false;
        if (description != null ? !description.equals(usecase.description) : usecase.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latency != null ? latency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usecaseByFkUsecaseId")
    public Collection<DataElement> getDataElementsById() {
        return dataElementsById;
    }

    public void setDataElementsById(Collection<DataElement> dataElementsById) {
        this.dataElementsById = dataElementsById;
    }

    @OneToMany(mappedBy = "usecaseByUsecaseId")
    public Collection<UsecaseField> getUsecaseFieldsById() {
        return usecaseFieldsById;
    }

    public void setUsecaseFieldsById(Collection<UsecaseField> usecaseFieldsById) {
        this.usecaseFieldsById = usecaseFieldsById;
    }
}
