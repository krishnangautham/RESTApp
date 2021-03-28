
package com.restapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "SALUTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salutation.findAll", query = "SELECT s FROM Salutation s")
    , @NamedQuery(name = "Salutation.findBySalutationId", query = "SELECT s FROM Salutation s WHERE s.salutationId = :salutationId")
    , @NamedQuery(name = "Salutation.findBySalutation", query = "SELECT s FROM Salutation s WHERE s.salutation = :salutation")})
public class Salutation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALUTATION_ID")
    private Integer salutationId;
    @Size(max = 10)
    @Column(name = "SALUTATION")
    private String salutation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salutationId")
    private Collection<Client> clientCollection;

    public Salutation() {
    }

    public Salutation(Integer salutationId) {
        this.salutationId = salutationId;
    }

    public Integer getSalutationId() {
        return salutationId;
    }

    public void setSalutationId(Integer salutationId) {
        this.salutationId = salutationId;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salutationId != null ? salutationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salutation)) {
            return false;
        }
        Salutation other = (Salutation) object;
        if ((this.salutationId == null && other.salutationId != null) || (this.salutationId != null && !this.salutationId.equals(other.salutationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.entity.Salutation[ salutationId=" + salutationId + " ]";
    }
    
}
