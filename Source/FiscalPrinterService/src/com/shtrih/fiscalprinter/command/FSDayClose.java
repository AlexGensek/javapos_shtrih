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
������� ����� � �� FF43H
��� ������� FF43h . ����� ���������: 6 ����.
    ������ ���������� ��������������: 4 ����
�����:    FF43h ����� ���������: 11 ����.
��� ������: 1 ����
    ����� ������ ��� �������� �����: 2 �����
    ����� �� :4 �����
    ���������� �������: 4 �����
*/
public class FSDayClose extends PrinterCommand {

    // in
    private int sysPassword; // System sdministrator password (4 bytes)
    // out
    private int dayNumber;
    private int documentNumber;
    private int documentDigest;

    public FSDayClose() {
    }

    public final int getCode() {
        return 0xFF43;
    }

    public final String getText() {
        return "Fiscal storage: day close";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
    }

    public void decode(CommandInputStream in) throws Exception {
        setDayNumber(in.readShort());
        setDocumentNumber(in.readInt());
        setDocumentDigest(in.readInt());
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
     * @return the dayNumber
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * @param dayNumber the dayNumber to set
     */
    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    /**
     * @return the documentNumber
     */
    public int getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber the documentNumber to set
     */
    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     * @return the documentDigest
     */
    public int getDocumentDigest() {
        return documentDigest;
    }

    /**
     * @param documentDigest the documentDigest to set
     */
    public void setDocumentDigest(int documentDigest) {
        this.documentDigest = documentDigest;
    }

} 
