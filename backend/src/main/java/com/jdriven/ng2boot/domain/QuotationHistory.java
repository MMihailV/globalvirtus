package com.jdriven.ng2boot.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quotation_history")
public class QuotationHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Double open;

    @Column(nullable = false)
    private Double high;

    @Column(nullable = false)
    private Double low;

    @Column(nullable = false)
    private Double close;

    @Column(nullable = false)
    private Integer volume;

    @Column(nullable = false)
    private Long FK_Quotation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Long getFK_Quotation() {
        return FK_Quotation;
    }

    public void setFK_Quotation(Long FK_Quotation) {
        this.FK_Quotation = FK_Quotation;
    }
}
