package gov.inl.generated.SGComponents;

import javax.persistence.*;

@Entity
@Table(name = "usecase_field", schema = "main", catalog = "")
public class UsecaseField {
    private Integer id;
    private Integer usecaseId;
    private Integer fieldId;
    private Usecase usecaseByUsecaseId;
    private Field fieldByFieldId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usecaseId", insertable = false, updatable = false)
    public Integer getUsecaseId() {
        return usecaseId;
    }

    public void setUsecaseId(Integer usecaseId) {
        this.usecaseId = usecaseId;
    }

    @Basic
    @Column(name = "fieldId", insertable = false, updatable = false)
    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsecaseField that = (UsecaseField) o;

        if (id != that.id) return false;
        if (usecaseId != that.usecaseId) return false;
        if (fieldId != that.fieldId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (int) usecaseId;
        result = 31 * result + (int) fieldId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "usecaseId", referencedColumnName = "id", nullable = false)
    public Usecase getUsecaseByUsecaseId() {
        return usecaseByUsecaseId;
    }

    public void setUsecaseByUsecaseId(Usecase usecaseByUsecaseId) {
        this.usecaseByUsecaseId = usecaseByUsecaseId;
    }

    @ManyToOne
    @JoinColumn(name = "fieldId", referencedColumnName = "id", nullable = false)
    public Field getFieldByFieldId() {
        return fieldByFieldId;
    }

    public void setFieldByFieldId(Field fieldByFieldId) {
        this.fieldByFieldId = fieldByFieldId;
    }
}
