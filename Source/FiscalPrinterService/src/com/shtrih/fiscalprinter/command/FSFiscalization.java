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
 * ������������ ��
 * ��� ������� FF06h . ����� ���������: 45 ����.
 * ������ ���������� ��������������: 4 ����
 * ���� � ����� DATE_TIME (5 ����)
 * ��� ASCII (12 ����)
 * ��������������� ����� ��� ASCII (20 ����)
 * ��� ��������������� ( 1 ����)
 * ����� ������ ( 1 ����)
 * �����:	FF06h ����� ���������: 9 ����.
 * ��� ������ (1 ����)
 * ����� �� (4 �����)
 * ���������� ������� ( 4 ����)
 *
 *
 */
public class FSFiscalization extends PrinterCommand {

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
    private PrinterDate date;
    private PrinterTime time;
    private String taxID;
    private String regID;
    private int taxSystemCode;
    // out
    private long docNumber;
    private long macNumber;

    public FSFiscalization() {
    }

    public final int getCode() {
        return 0xFF05;
    }

    public final String getText() {
        return "Fiscal storage: start fiscalization";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
        out.writeDate(getDate());
        out.writeTime(getTime());
        out.writeString(getTaxID(), 12);
        out.writeString(getRegID(), 20);
        out.writeByte(getTaxSystemCode());
    }

    public void decode(CommandInputStream in) throws Exception {
        setDocNumber(in.readLong(4));
        setMacNumber(in.readLong(4));
    }

    /**
     * @return the date
     */
    public PrinterDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(PrinterDate date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public PrinterTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(PrinterTime time) {
        this.time = time;
    }

    /**
     * @return the taxID
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * @param taxID the taxID to set
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {
        this.regID = regID;
    }

    /**
     * @return the taxSystemCode
     */
    public int getTaxSystemCode() {
        return taxSystemCode;
    }

    /**
     * @param taxSystemCode the taxSystemCode to set
     */
    public void setTaxSystemCode(int taxSystemCode) {
        this.taxSystemCode = taxSystemCode;
    }

    /**
     * @return the docNumber
     */
    public long getDocNumber() {
        return docNumber;
    }

    /**
     * @param docNumber the docNumber to set
     */
    public void setDocNumber(long docNumber) {
        this.docNumber = docNumber;
    }

    /**
     * @return the macNumber
     */
    public long getMacNumber() {
        return macNumber;
    }

    /**
     * @param macNumber the macNumber to set
     */
    public void setMacNumber(long macNumber) {
        this.macNumber = macNumber;
    }

}
