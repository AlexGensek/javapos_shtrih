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
 * ������ ����� �������� ��
 * ��� ������� FF03h . ����� ���������: 6 ����.
 * ������ ���������� ��������������: 4 ����
 * �����:	FF03h ����� ���������: 4 ����.
 * ��� ������ (1 ����)
 * ���� �������� (3 ����) BCD ���, �����, ����
 */
public class FSReadExpDate extends PrinterCommand {

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
    private int sysPassword = 0; // System sdministrator password (4 bytes)
    // out
    private EJDate date; // Serial number

    public FSReadExpDate() {
    }

    public final int getCode() {
        return 0xFF03;
    }

    public final String getText() {
        return "Fiscal storage: read expiration date";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
    }

    public void decode(CommandInputStream in) throws Exception {
        setDate(in.readEJDate());
    }

    /**
     * @return the date
     */
    public EJDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(EJDate date) {
        this.date = date;
    }

}
