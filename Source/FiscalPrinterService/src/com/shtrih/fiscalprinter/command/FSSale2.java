/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.fiscalprinter.command;

import com.shtrih.ej.EJDate;
import com.shtrih.util.BitUtils;

/**
 *
 * @author V.Kravtsov
 */
/**
�������� �� ��������, ���������� � ������� FF44H
��� ������� FF44h . ����� ���������:  254 ����.
������ ���������� ��������������: 4 �����
��� ��������: 1 ���� 
1 � ������, 
2 � ������� �������,
3 � ������,
4 � ������� ������� 
����������: 5 ���� 0000000000�9999999999
����:             5 ���� 0000000000�9999999999
������:         5 ���� 0000000000�9999999999
��������:    5 ���� 0000000000�9999999999
�����:           5 ���� 0000000000�9999999999
����� ������: 1 ����
0�16 � ����� ��������� �������, 255 � ����� ������� �� ���� ������
�����:  1 ����
��� 1 �0� � ���, �1� � 1 ��������� ������
��� 2 �0� � ���, �1� � 2 ��������� ������
��� 3 �0� � ���, �1� � 3 ��������� ������
��� 4 �0� � ���, �1� � 4 ��������� ������
�����-���: 5 ����  000000000000�999999999999
�����: 215 ����� ������ - �������� ������ � ������ 
����������: ���� ������ ���������� ��������� \\ �� ��� ��������� �� ������ ��� �� �� ���������� �� �����. �������� ������ � ������ ������ ������������� ���� (���� ��������������� ������).
����������: ����� �������� ���������� ����������� � ��������� ����� � ������, ����� ����� �� ����� ��� ���������� ����.


�����:    FF43h ����� ���������: 1 ����.
��� ������: 1 ����

 */
public class FSSale2 extends PrinterCommand {

    // in
    private int sysPassword; // System sdministrator password (4 bytes)
    private int operation;
    private long quantity;
    private long price;
    private long discount;
    private long charge;
    private long taxAmount;
    private int department;
    private int tax;
    private long barcode;
    private String text;

    public FSSale2() {
    }

    public final int getCode() {
        return 0xFF44;
    }

    public final String getText() {
        return "Fiscal storage: sale with tax";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(sysPassword);
        out.writeByte(operation);
        out.writeLong(quantity, 5);
        out.writeLong(price, 5);
        out.writeLong(discount, 5);
        out.writeLong(charge, 5);
        out.writeLong(taxAmount, 5);
        out.writeByte(department);
        out.writeByte(tax);
        out.writeLong(barcode, 5);
        out.writeString(text, 0);
    }

    public void decode(CommandInputStream in) throws Exception {
    }

    /**
     * @return the sysPassword
     */
    public int getSysPassword() {
        return sysPassword;
    }

    /**
     * @param sysPassword the sysPassword to set
     */
    public void setSysPassword(int sysPassword) {
        this.sysPassword = sysPassword;
    }

    /**
     * @return the operation
     */
    public int getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

    /**
     * @return the quantity
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * @return the discount
     */
    public long getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(long discount) {
        this.discount = discount;
    }

    /**
     * @return the charge
     */
    public long getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(long charge) {
        this.charge = charge;
    }

    /**
     * @return the taxAmount
     */
    public long getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount the taxAmount to set
     */
    public void setTaxAmount(long taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return the department
     */
    public int getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(int department) {
        this.department = department;
    }

    /**
     * @return the tax
     */
    public int getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(int tax) {
        this.tax = tax;
    }

    /**
     * @return the barcode
     */
    public long getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
