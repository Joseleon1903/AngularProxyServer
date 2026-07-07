package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import javax.lang.model.type.UnionType;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Units", schema = "WebApp")
public class Unit {

    @Id
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Code", nullable = false, columnDefinition = "nvarchar(max)")
    private String code;

    @Column(name = "Name", nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(name = "UnitType", nullable = false)
    private String unitType;

    @Column(name = "ConversionFactorToBase", nullable = false, precision = 18, scale = 2)
    private BigDecimal conversionFactorToBase;

    @Column(name = "IsBaseUnit", nullable = false)
    private Boolean isBaseUnit;

    // ============================
    // CONSTRUCTORES
    // ============================

    public Unit() {
    }

    public Unit(Long id, String code, String name, String unitType,
                BigDecimal conversionFactorToBase, Boolean isBaseUnit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unitType = unitType;
        this.conversionFactorToBase = conversionFactorToBase;
        this.isBaseUnit = isBaseUnit;
    }

    // ============================
    // GETTERS Y SETTERS
    // ============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getConversionFactorToBase() {
        return conversionFactorToBase;
    }

    public void setConversionFactorToBase(BigDecimal conversionFactorToBase) {
        this.conversionFactorToBase = conversionFactorToBase;
    }

    public Boolean getIsBaseUnit() {
        return isBaseUnit;
    }

    public void setIsBaseUnit(Boolean baseUnit) {
        isBaseUnit = baseUnit;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitType='" + unitType + '\'' +
                ", conversionFactorToBase=" + conversionFactorToBase +
                ", isBaseUnit=" + isBaseUnit +
                '}';
    }
}
