
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
@Table(name = "PRODUCT_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p")
    , @NamedQuery(name = "ProductCategory.findByCategoryCode", query = "SELECT p FROM ProductCategory p WHERE p.categoryCode = :categoryCode")
    , @NamedQuery(name = "ProductCategory.findByName", query = "SELECT p FROM ProductCategory p WHERE p.name = :name")})
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CATEGORY_CODE")
    private String categoryCode;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private Collection<ProductCatalog> productCatalogCollection;

    public ProductCategory() {
    }

    public ProductCategory(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<ProductCatalog> getProductCatalogCollection() {
        return productCatalogCollection;
    }

    public void setProductCatalogCollection(Collection<ProductCatalog> productCatalogCollection) {
        this.productCatalogCollection = productCatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryCode != null ? categoryCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategory)) {
            return false;
        }
        ProductCategory other = (ProductCategory) object;
        if ((this.categoryCode == null && other.categoryCode != null) || (this.categoryCode != null && !this.categoryCode.equals(other.categoryCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.entity.ProductCategory[ categoryCode=" + categoryCode + " ]";
    }
    
}
