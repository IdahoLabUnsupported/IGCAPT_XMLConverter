package gov.inl.generated.SGComponents;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class EndPoint {
    private Integer id;
    private Integer componentDataId;
    private String endpoint;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "componentDataId")
    public Integer getComponentDataId() {
        return componentDataId;
    }

    public void setComponentDataId(Integer componentDataId) {
        this.componentDataId = componentDataId;
    }

    @Basic
    @Column(name = "endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EndPoint endPoint = (EndPoint) o;

        if (!Objects.equals(id, endPoint.id)) return false;
        if (!Objects.equals(componentDataId, endPoint.componentDataId))
            return false;
        if (!Objects.equals(endpoint, endPoint.endpoint)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (componentDataId != null ? componentDataId.hashCode() : 0);
        result = 31 * result + (endpoint != null ? endpoint.hashCode() : 0);
        return result;
    }
}
