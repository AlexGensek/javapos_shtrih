/*
 * LoadExtendedGraphics.java
 *
 * Created on April 2 2008, 21:24
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
 * �������� ����������� ������� 512 �������: 4EH. ����� ���������: 11+X2 ����.
 * ������ ��������� (4 �����) ����� ����� (1 ����) L = 1�64 ����� ���������
 * ����� (2 �����) 1�600 ���������� ����������� �����3 (2 �����) N = 1�600 ���
 * ������������ ������ (1 ����) 0 - ��� ������ ����������� ��� �����������
 * ������� (320), 1 - ��� ������ ����������� ������� 512 ����������� ����������
 * (X2 = N*L ����) �����: 4EH. ����� ���������: 3 �����. ��� ������ (1 ����)
 * ���������� ����� ��������� (1 ����) 1�30
 * 
 * ����������: 1 � � ����������� �� ������ ��� (��� ��������� ������ ��� 42, ��.
 * ������� F7H); 2 � ������������ ������ ����������� ������ (����) ������� ��
 * ����� ��������� (��. ���� "������������ ����� ������� (N/LEN16)" � �������
 * F7H); 3 � ��� L = 64 ��� ������������ ����� ��������� 255 ������������ ������
 * ����� ������� ����� 3 ������; ��� ������������ ����� ��������� 1455
 * ������������ ������ ����� ������� ����� 22 ������.
 ****************************************************************************/
public final class LoadGraphics3 extends PrinterCommand {
	// in

	private int password; // Operator password (4 bytes)
	private int lineLength; // Graphics line length
	private int lineNumber; // Graphics line number (2 bytes) 0�1199
	private int lineCount; // Graphics line count
	private int bufferType; // Graphics line count
	private byte[] data; // Graphical data (40 bytes)
	// out
	private int operator;

	/**
	 * Creates a new instance of LoadExtendedGraphics
	 */
	public LoadGraphics3() {
		super();
	}

	public final int getCode() {
		return 0x4E;
	}

	public final String getText() {
		return "Load graphics 512";
	}

	public final void encode(CommandOutputStream out) throws Exception {
		out.writeInt(getPassword());
		out.writeByte(getLineLength());
		out.writeShort(getLineNumber());
		out.writeShort(getLineCount());
		out.writeByte(getBufferType());
		out.writeBytes(getData());
	}

	public static int getMaxDataLength(int commandLength) {
		return commandLength - 10;
	}

	public final void decode(CommandInputStream in) throws Exception {
		setOperator(in.readByte());
	}

	public int getOperator() {
		return operator;
	}

	public int getPassword() {
		return password;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public byte[] getData() {
		return data;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public void setLineNumber(int lineNumber) throws Exception {
		this.lineNumber = lineNumber;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getBufferType() {
		return bufferType;
	}

	public void setBufferType(int bufferType) {
		this.bufferType = bufferType;
	}
}
