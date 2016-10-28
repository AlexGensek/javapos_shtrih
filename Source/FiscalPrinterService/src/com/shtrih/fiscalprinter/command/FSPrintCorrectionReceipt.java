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
������������ ��� ��������� FF36H
��� ������� FF36h . ����� ���������: 12 ����.
    ������ ���������� ��������������: 4 �����
    ���� ����:  5 ���� 0000000000�9999999999
    ��� �������� 1 ����
�����:	    FF36h ����� ���������: 11 ����.
    ��� ������: 1 ����
    ����� ����: 2 �����
    ����� ��: 4 �����
    ���������� �������: 4 ����
*/

public class FSPrintCorrectionReceipt extends PrinterCommand {

    // in
    private int sysPassword = 0; // System sdministrator password (4 bytes)
    private long total = 0; 
    private int operationType = 0; 
    // out
    private int receiptNumber;
    private int documentNumber;
    private int documentDigest;
     

    public FSPrintCorrectionReceipt() {
    }

    public final int getCode() {
        return 0xFF36;
    }

    public final String getText() {
        return "Fiscal storage: start correction receipt";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
        out.writeLong(getTotal(), 5);
        out.writeByte(getOperationType());
    }

    public void decode(CommandInputStream in) throws Exception {
        setReceiptNumber(in.readShort());
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
     * @return the total
     */
    public long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * @return the operationType
     */
    public int getOperationType() {
        return operationType;
    }

    /**
     * @param operationType the operationType to set
     */
    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    /**
     * @return the receiptNumber
     */
    public int getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * @param receiptNumber the receiptNumber to set
     */
    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
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
