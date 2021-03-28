
package com.restapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByCustomerId", query = "SELECT c FROM Client c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name")
    , @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
    , @NamedQuery(name = "Client.findByCreditLimit", query = "SELECT c FROM Client c WHERE c.creditLimit = :creditLimit")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<SalesOrder> salesOrderCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Address address;
    @JoinColumn(name = "SALUTATION_ID", referencedColumnName = "SALUTATION_ID")
    @ManyToOne(optional = false)
    private Salutation salutationId;

    public Client() {
    }

    public Client(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @XmlTransient
    public Collection<SalesOrder> getSalesOrderCollection() {
        return salesOrderCollection;
    }

    public void setSalesOrderCollection(Collection<SalesOrder> salesOrderCollection) {
        this.salesOrderCollection = salesOrderCollection;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Salutation getSalutationId() {
        return salutationId;
    }

    public void setSalutationId(Salutation salutationId) {
        this.salutationId = salutationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.entity.Client[ customerId=" + customerId + " ]";
    }
    
}
