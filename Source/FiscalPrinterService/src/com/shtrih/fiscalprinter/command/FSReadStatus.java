/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.fiscalprinter.command;

import com.shtrih.util.BitUtils;

/**
 *
 * @author V.Kravtsov
 */
/**
 * **************************************************************************
 * ������ ������� ��
 * ��� ������� FF01h. ����� ���������: 6 ����.
 * ������ ���������� ��������������: 4 ����
 *
 * �����: FF01h	����� ���������: 31 ����.
 * ��� ������ (1 ����)
 * ��������� ���� ����� (1 ����)
 * ��� 0 � ��������� ��������� ��
 * ��� 1 � ������ ���������� �����
 * ��� 2 � ������ ���������� �����
 * ��� 3 � ��������� �������� ���������� ������ � ���
 * ������� �������� (1 ����)
 * 00h � ��� ��������� ���������
 * 01h � ����� � ������������
 * 02h � ����� �� �������� �����
 * 04h � �������� ���
 * 08h � ����� � �������� �����
 * 10h � ����� � �������� ����������� ������
 * ������ ��������� (1 ����)
 * 00 � ��� ������ ���������
 * 01 � �������� ������ ���������
 * ��������� ����� (1 ����)
 * 00 � ����� �������
 * 01 � ����� �������
 * ����� �������������� (1 ����)
 * ���� � ����� (5 ����)
 * ����� �� (16 ����) ASCII
 * ����� ���������� �� (4 ����)
 ***************************************************************************
 */
public class FSReadStatus extends PrinterCommand {

    // in
    private int sysPassword = 0;    // System sdministrator password (4 bytes)
    // out
    private FSStatus status;        // Status code
    private FSDocType docType;      // Document type
    private boolean isDocReceived;  // Document data received  
    private boolean isDayOpened;    // Fiscal day is opened
    private int flags;
    private PrinterDate date;
    private PrinterTime time;
    private String fsSerial;
    private long docNumber;
    
    public FSReadStatus() {
    }

    public final int getCode() {
        return 0xFF01;
    }

    public final String getText() {
        return "Fiscal storage: read status";
    }

    public void encode(CommandOutputStream out) throws Exception {
        out.writeInt(getSysPassword());
    }

    public void decode(CommandInputStream in) throws Exception {
        setStatus(new FSStatus(in.readByte()));
        setDocType(new FSDocType(in.readByte()));
        setIsDocReceived(in.readByte() != 0);
        setIsDayOpened(in.readByte() != 0);
        flags = in.readByte();
        date = in.readDateYMD();
        time = in.readTime2();
        fsSerial = in.readString(16);
        docNumber = in.readLong(4);
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
    public FSStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(FSStatus status) {
        this.status = status;
    }

    /**
     * @return the docType
     */
    public FSDocType getDocType() {
        return docType;
    }

    /**
     * @param docType the docType to set
     */
    public void setDocType(FSDocType docType) {
        this.docType = docType;
    }

    /**
     * @return the isDocReceived
     */
    public boolean isIsDocReceived() {
        return isDocReceived;
    }

    /**
     * @param isDocReceived the isDocReceived to set
     */
    public void setIsDocReceived(boolean isDocReceived) {
        this.isDocReceived = isDocReceived;
    }

    /**
     * @return the isDayOpened
     */
    public boolean isIsDayOpened() {
        return isDayOpened;
    }

    /**
     * @param isDayOpened the isDayOpened to set
     */
    public void setIsDayOpened(boolean isDayOpened) {
        this.isDayOpened = isDayOpened;
    }

    /**
     * @return the flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(int flags) {
        this.flags = flags;
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
     * @return the fsSerial
     */
    public String getFsSerial() {
        return fsSerial;
    }

    /**
     * @param fsSerial the fsSerial to set
     */
    public void setFsSerial(String fsSerial) {
        this.fsSerial = fsSerial;
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
    
}
