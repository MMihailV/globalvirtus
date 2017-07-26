package com.jdriven.ng2boot.domain;

import javax.persistence.*;

@Entity
@Table(name = "quotation")
public class Quotation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String quotationName;

    @Column(nullable = false)
    private String quotationLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuotationName() {
        return quotationName;
    }

    public void setQuotationName(String quotationName) {
        this.quotationName = quotationName;
    }

    public String getQuotationLink() {
        return quotationLink;
    }

    public void setQuotationLink(String quotationLink) {
        this.quotationLink = quotationLink;
    }
}
