package com.example.gestionnominas;

public class Empleado {
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private String cedula;
    private String area;
    private String banco;
    private double salarioBruto;
    private double salarioNeto;

    // Constructor
    public Empleado(String nombre, String apellido, String cargo, double salario, String cedula, String area, String banco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.cedula = cedula;
        this.area = area;
        this.banco = banco;
        this.salarioBruto = salario;
        this.salarioNeto = calcularSalarioNeto(salario);
    }

    // Método para calcular el ISR
    private static final double tramoExtento = 416220.0 / 12;
    private static final double tramo1 = 624329.0 / 12;
    private static final double tramo2 = 867123.0 / 12;

    private double calcularISR(double salario) {
        if (salario <= tramoExtento) {
            return 0;
        } else if (salario <= tramo1) {
            return (salario - tramoExtento) * 0.15;
        } else if (salario <= tramo2) {
            return (31216.0 / 12) + (salario - tramo1) * 0.20;
        } else {
            return (79776.0 / 12) + (salario - tramo2) * 0.25;
        }
    }

    public double calcularSalarioNeto(double salario) {
        double isr = calcularISR(salario);
        double afp = salario * 0.0287;
        double sfs = salario * 0.0304;
        return salario - isr - afp - sfs;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getCedula() {
        return cedula;
    }

    public String getArea() {
        return area;
    }

    public String getBanco() {
        return banco;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }
}
