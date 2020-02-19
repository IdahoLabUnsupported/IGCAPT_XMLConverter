package gov.inl.generated.SGComponents;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class ComponentList {
    private Short id;
    private Date date;
    private Collection<ComponentGroup> componentGroupsById;

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentList that = (ComponentList) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "componentListByComponentListId")
    public Collection<ComponentGroup> getComponentGroupsById() {
        return componentGroupsById;
    }

    public void setComponentGroupsById(Collection<ComponentGroup> componentGroupsById) {
        this.componentGroupsById = componentGroupsById;
    }
}
