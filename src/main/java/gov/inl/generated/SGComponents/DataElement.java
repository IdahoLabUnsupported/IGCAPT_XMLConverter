package gov.inl.generated.SGComponents;

import javax.persistence.*;

@Entity
@Table(name = "data_element", schema = "main", catalog = "")
public class DataElement {
    private short id;
    private String name;
    private short payload;
    private short maxLatency;
    private String source;
    private short fkUsecaseId;
    private Usecase usecaseByFkUsecaseId;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
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
    public short getPayload() {
        return payload;
    }

    public void setPayload(short payload) {
        this.payload = payload;
    }

    @Basic
    @Column(name = "maxLatency")
    public short getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(short maxLatency) {
        this.maxLatency = maxLatency;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "fk_usecase_id", insertable = false, updatable = false)
    public short getFkUsecaseId() {
        return fkUsecaseId;
    }

    public void setFkUsecaseId(short fkUsecaseId) {
        this.fkUsecaseId = fkUsecaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataElement that = (DataElement) o;

        if (id != that.id) return false;
        if (payload != that.payload) return false;
        if (maxLatency != that.maxLatency) return false;
        if (fkUsecaseId != that.fkUsecaseId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) payload;
        result = 31 * result + (int) maxLatency;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (int) fkUsecaseId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_usecase_id", referencedColumnName = "id", nullable = false)
    public Usecase getUsecaseByFkUsecaseId() {
        return usecaseByFkUsecaseId;
    }

    public void setUsecaseByFkUsecaseId(Usecase usecaseByFkUsecaseId) {
        this.usecaseByFkUsecaseId = usecaseByFkUsecaseId;
    }
}
