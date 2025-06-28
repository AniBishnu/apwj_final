package com.example.Vitascript.Entity;

public class GenericMedicine {
    public int id;
    public String name;
    public String formula;

    public GenericMedicine(int id, String name, String formula) {
        this.id = id;
        this.name = name;
        this.formula = formula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
