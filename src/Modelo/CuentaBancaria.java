/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class CuentaBancaria {
    private String numeroCuenta;
    private String banco;
    private String tipoCuenta; // Ejemplo: Ahorros, Corriente
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String banco, String tipoCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}