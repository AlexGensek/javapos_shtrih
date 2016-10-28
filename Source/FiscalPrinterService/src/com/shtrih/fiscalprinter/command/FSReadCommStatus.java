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
�������� ������ ���������������  ������ FF39H
��� ������� FF39h . ����� ���������: 6 ����.
    ������ ���������� ��������������: 4 �����
�����:	    FF39h ����� ���������: 14 ����.
    ��� ������: 1 ����
    ������ ��������������� ������: 1 ����
    (0 � ���, 1 � ��)
��� 0 � ������������ ���������� �����������
��� 1 � ���� ��������� ��� �������� � ���
��� 2 � �������� ��������� ��������� (���������) �� ���
��� 3 � ���� ������� �� ���
��� 4 � ���������� ��������� ���������� � ���
��� 5 � �������� ������ �� ������� �� ���
��������� ������ ���������: 1 ���� 1 � ��, 0 -���
���������� ��������� ��� ���: 2 �����
����� ��������� ��� ��� ������� � �������: 4 �����
���� � ����� ��������� ��� ��� ������� � �������: 5 ����

*/

public class FSReadCommStatus extends PrinterCommand {

    // in
    private int sysPassword = 0; // System sdministrator password (4 bytes)
    // out
    private int status = 0; 
    private int readStatus = 0; 
    private int queueSize = 0; 
    private int documentNumber = 0; 
    private PrinterDate documentDate; 
    private PrinterTime documentTime; 

    public FSReadCommStatus() {
    }

    public final int getCode() {
        return 0xFF39;
    }

    public final String getText() {
        return "Fiscal storage: read communication status";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(sysPassword);
    }

    public void decode(CommandInputStream in) throws Exception {
        status = in.readByte(); 
        readStatus = in.readByte(); 
        queueSize = in.readShort();
        documentNumber = in.readInt(); 
        documentDate = in.readDate(); 
        documentTime = in.readTime2(); 
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the readStatus
     */
    public int getReadStatus() {
        return readStatus;
    }

    /**
     * @param readStatus the readStatus to set
     */
    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * @return the queueSize
     */
    public int getQueueSize() {
        return queueSize;
    }

    /**
     * @param queueSize the queueSize to set
     */
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
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
     * @return the documentDate
     */
    public PrinterDate getDocumentDate() {
        return documentDate;
    }

    /**
     * @param documentDate the documentDate to set
     */
    public void setDocumentDate(PrinterDate documentDate) {
        this.documentDate = documentDate;
    }

    /**
     * @return the documentTime
     */
    public PrinterTime getDocumentTime() {
        return documentTime;
    }

    /**
     * @param documentTime the documentTime to set
     */
    public void setDocumentTime(PrinterTime documentTime) {
        this.documentTime = documentTime;
    }
}
