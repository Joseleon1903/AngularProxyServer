package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Units", schema = "Catalog")
public class Unit {

    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Code", nullable = false, columnDefinition = "nvarchar(max)")
    private String code;

    @Column(name = "Name", nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(name = "UnitType", nullable = false)
    private Integer unitType;

    @Column(name = "ConversionFactorToBase", nullable = false, precision = 18, scale = 2)
    private BigDecimal conversionFactorToBase;

    @Column(name = "IsBaseUnit", nullable = false)
    private Boolean isBaseUnit;

    // ============================
    // CONSTRUCTORES
    // ============================

    public Unit() {
    }

    public Unit(UUID id, String code, String name, Integer unitType,
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
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
}
