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
public class FSDocType {

    //////////////////////////////////////////////////////////////////////
    // 
    // 00h � ��� ��������� ���������
    public static final int FS_DOCTYPE_NONE = 0;
    // 01h � ����� � ������������
    public static final int FS_DOCTYPE_FISCAL_OPEN = 1;
    // 02h � ����� �� �������� �����
    public static final int FS_DOCTYPE_DAYOPEN = 2;
    // 04h � �������� ���
    public static final int FS_DOCTYPE_RECEIPT = 4;
    // 08h � ����� � �������� �����
    public static final int FS_DOCTYPE_DAYCLOSE = 8;
    // 10h � ����� � �������� ����������� ������
    public static final int FS_DOCTYPE_FISCAL_CLOSE = 16;

    private final int docType;

    public FSDocType(int docType) {
        this.docType = docType;
    }

    public int getValue() {
        return docType;
    }

    public String getText() {
        switch (docType) {
            case FS_DOCTYPE_NONE:
                return "None";
            case FS_DOCTYPE_FISCAL_OPEN:
                return "Open fiscal mode";
            case FS_DOCTYPE_DAYOPEN:
                return "Open fiscal day";
            case FS_DOCTYPE_RECEIPT:
                return "Fiscal receipt";
            case FS_DOCTYPE_DAYCLOSE:
                return "Close fiscal day";
            case FS_DOCTYPE_FISCAL_CLOSE:
                return "Close fiscal mode";

            default:
                return "Unknown document type";
        }

    }
}
