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
 * ������ ������ ��
 * ��� ������� FF04h . ����� ���������: 6 ����.
 * ������ ���������� ��������������: 4 ����
 * �����:	FF04h ����� ���������: 18 ����.
 * ��� ������ (1 ����)
 * ������ ������ ������������ ����������� �� ASCII (16 ����)
 * ��� ������������ ����������� �� (1 ����)
 * 0 � ���������� ������
 * 1 � �������� ������  *
 */
public class FSReadVersion extends PrinterCommand {

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
    private String version; // Firmware version
    private boolean isDebug; // Debug version

    public FSReadVersion() {
    }

    public final int getCode() {
        return 0xFF04;
    }

    public final String getText() {
        return "Fiscal storage: read version";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
    }

    public void decode(CommandInputStream in) throws Exception {
        setVersion(in.readString(16));
        setIsDebug(in.readByte() == 0);
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the isDebug
     */
    public boolean isIsDebug() {
        return isDebug;
    }

    /**
     * @param isDebug the isDebug to set
     */
    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

}
