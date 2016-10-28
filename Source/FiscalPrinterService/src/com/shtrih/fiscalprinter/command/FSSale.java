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
 * �������� �� �������� � ����������
 * ��� ������� FF0Dh . ����� ���������: 98 ����.
 * ������ ���������� ��������������: 4 �����
 * ��� �������� ( 1 ����)
 * 1 � ������,
 * 2 � ������� �������,
 * 3 � ������,
 * 4 � ������� �������
 * ���������� (5 ����) 0000000000�9999999999
 * ���� (5 ����) 0000000000�9999999999
 * ������ (5 ����) 0000000000�9999999999
 * �������� (5 ����) 0000000000�9999999999
 * ����� ������ (1 ����)
 * 0�16 � ����� ��������� �������, 255 � ����� ������� �� ���� ������
 * ����� (1 ����)
 * ��� 1 �0� � ���, �1� � 1 ��������� ������
 * ��� 2 �0� � ���, �1� � 2 ��������� ������
 * ��� 3 �0� � ���, �1� � 3 ��������� ������
 * ��� 4 �0� � ���, �1� � 4 ��������� ������
 * �����-��� (5 ����) 000000000000�999999999999
 * ����� (64 �����) ������ �������� ������
 * �����: FF0Dh ����� ��������� 1 ����.
 * ��� ������ (1 ����)
 *
 *
 */
public class FSSale extends PrinterCommand {

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

    // in
    private int sysPassword; // System sdministrator password (4 bytes)
    private int operation;
    private long quantity;
    private long price;
    private long discount;
    private long charge;
    private int department;
    private int tax;
    private long barcode;
    private String text;

    public FSSale() {
    }

    public final int getCode() {
        return 0xFF0D;
    }

    public final String getText() {
        return "Fiscal storage: sale";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
        out.writeByte(operation);
        out.writeLong(quantity, 5);
        out.writeLong(price, 5);
        out.writeLong(discount, 5);
        out.writeLong(charge, 5);
        out.writeByte(department);
        out.writeByte(tax);
        out.writeLong(barcode, 5);
        out.writeString(text, 0);
    }

    public void decode(CommandInputStream in) throws Exception {
    }

}
