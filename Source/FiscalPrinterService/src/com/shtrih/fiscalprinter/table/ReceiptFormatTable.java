/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shtrih.fiscalprinter.table;

/**
 *
 * @author V.Kravtsov
 */
public class ReceiptFormatTable {
    
    class FieldFormat
    {
        private final int line;
        private final int offset;
        private final int size;
        private final int alignment;
        
        public FieldFormat(){
            line = 0;
            offset = 0;
            size = 0;
            alignment = 0;
        }
        
        public FieldFormat(int line, int offset, int size, int alignment)
        {
            this.line = line;
            this.offset = offset;
            this.size = size;
            this.alignment = alignment;
        }
    }
            
    private FieldFormat itemName; // ������������ � ��������
    private FieldFormat itemQuantity; // ���������� X ���� � ��������
    private FieldFormat itemDepartment; // ������ � ��������
    private FieldFormat itemAmount; // ��������� � ��������
    private FieldFormat itemVoidText; // ������� ������ � ��������
    private FieldFormat discountText; // ����� � ������
    private FieldFormat discountCaption; // ������� ������
    private FieldFormat discountAmount; // ����� ������
    private FieldFormat chargeText; // ����� � ��������
    private FieldFormat chargeName; // ������� ��������
    private FieldFormat chargeAmount; // ����� ��������
    private FieldFormat discountVoidText; // ����� � ������ ������
    private FieldFormat discountVoidName; // ������� ������ ������
    private FieldFormat discountVoidAmount; // ����� ������ ������
    private FieldFormat chargeVoidText; // ����� � ������ ��������
    private FieldFormat chargeVoidName; // ������� ������ ��������
    private FieldFormat chargeVoidAmount; // ����� ������ ��������
}
