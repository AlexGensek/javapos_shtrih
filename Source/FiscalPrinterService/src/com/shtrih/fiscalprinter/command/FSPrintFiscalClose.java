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
������� ���������� ����� FF3EH
��� ������� FF3Eh . ����� ���������: 6 ����.
    ������ ���������� ��������������: 4 �����
�����:	    FF3Eh ����� ���������: 9 ����.
    ��� ������: 1 ����
    ����� �� : 4 �����
    ���������� �������: 4 �����
 */

public class FSPrintFiscalClose extends PrinterCommand {

    // in
    private int sysPassword; // System sdministrator password (4 bytes)
    // out
    private int documentNumber;
    private int documentDigest;

    public FSPrintFiscalClose() {
    }

    public final int getCode() {
        return 0xFF3E;
    }

    public final String getText() {
        return "Fiscal storage: close fiscal";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(sysPassword);
    }

    public void decode(CommandInputStream in) throws Exception {
        documentNumber = in.readInt();
        documentDigest = in.readInt();
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
