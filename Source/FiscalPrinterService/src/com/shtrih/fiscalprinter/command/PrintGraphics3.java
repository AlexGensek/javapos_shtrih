/*
 * PrintExtendedGraphics.java
 *
 * Created on April 2 2008, 21:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.shtrih.fiscalprinter.command;

/**
 *
 * @author V.Kravtsov
 */

/****************************************************************************
 * ������ ����������� ������� 512 � ����������������1 �������: 4DH. �����
 * ���������: 12 ����. ������ ��������� (4 �����) ��������� ����� (2 �����)
 * 1�600 �������� ����� (2 �����) 1�600 ����������� ��������������� ����� ��
 * ��������� (1 ����) 1�6 ����������� ��������������� ����� �� ����������� (1
 * ����) 1�6 ����� (1 ����) ��� 0 � ����������� �����2, ��� 1 � ������� �����,
 * ��� 23 � ���������� ��������, ��� 34 � ���� ���; ��� 75 � ���������� ������
 * ������� �����: 4DH. ����� ���������: 3 �����. ��� ������ (1 ����) ����������
 * ����� ��������� (1 ����) 1�30 ����������: 1 � � ����������� �� ������ ���
 * (��� ��������� ������ ��� 42, ��. ������� F7H); 2 � � ����������� �� ������
 * ��� (��� ��������� ������ ��� 20, ��. ������� F7H); 3 � � ����������� ��
 * ������ ��� (��� ��������� ������ ��� 21, ��. ������� F7H); 4 � � �����������
 * �� ������ ��� (��� ��������� ������ ��� 34, ��. ������� F7H); ���� ��� 7
 * ���������� � ���������� ��� ������ � ����������� ���������
 * "������ ���� �� ��������" � ������� 1, �� ������� ����� ����������� �����
 * ���������� �����; ���� �� ���������� ��� 7, �� ������� ���������� ����������;
 * ��������� ������ ����� ��������� �������� 10H; 5 � � ����������� �� ������
 * ��� (��� ��������� ������ ��� 23, ��. ������� F7H).
 ****************************************************************************/

public final class PrintGraphics3 extends PrinterCommand {
	// in
	private int password; // Operator password
	private int line1; // Number of first line
	private int line2; // Number of last line
	private int vscale;
	private int hscale;
	private int flags;
	// out
	private int operator = 0;

	/**
	 * Creates a new instance of PrintExtendedGraphics
	 */
	public PrintGraphics3() throws Exception {
	}

	public final int getCode() {
		return 0x4D;
	}

	public final String getText() {
		return "Print graphics 512";
	}

	public final void encode(CommandOutputStream out) throws Exception {
		out.writeInt(getPassword());
		out.writeShort(getLine1());
		out.writeShort(getLine2());
		out.writeByte(getVscale());
		out.writeByte(getHscale());
		out.writeByte(getFlags());
	}

	public final void decode(CommandInputStream in) throws Exception {
		operator = in.readByte();
	}

	public int getOperator() {
		return operator;
	}

	public int getLine1() {
		return line1;
	}

	public void setLine1(int line1) {
		this.line1 = line1;
	}

	public int getLine2() {
		return line2;
	}

	public void setLine2(int line2) {
		this.line2 = line2;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getVscale() {
		return vscale;
	}

	public void setVscale(int vscale) {
		this.vscale = vscale;
	}

	public int getHscale() 
        {
		return hscale;
	}

	public void setHscale(int hscale) {
		this.hscale = hscale;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}
}
