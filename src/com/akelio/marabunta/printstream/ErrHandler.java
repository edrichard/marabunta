package com.akelio.marabunta.printstream;

import java.io.OutputStream;
import java.io.PrintStream;

public class ErrHandler {

	
	private static final OutputStreamNull nullOutput = new OutputStreamNull();
	
	private static class OutputStreamNull extends OutputStream
	{
		public OutputStreamNull(){} 
		public void write(int b){}
	}
	
	
	public static class PrintStream1 extends PrintStream
	{
		public PrintStream1()
		{super(nullOutput);}
		
		public void println()				{println("");}
		public void println(char[] val)		{println(new String(val));}
		public void println(boolean val)	{println(""+val);}
		public void println(char val)		{println(""+val);}
		public void println(double val)		{println(""+val);}
		public void println(float val)		{println(""+val);}
		public void println(int val)		{println(""+val);}
		public void println(long val)		{println(""+val);}
		public void println(Object val)		{println(""+val);}
		
		public void print(char[] val)		{print(new String(val));}
		public void print(boolean val)		{print(""+val);}
		public void print(char val)			{print(""+val);}
		public void print(double val)		{print(""+val);}
		public void print(float val)		{print(""+val);}
		public void print(int val)			{print(""+val);}
		public void print(long val)			{print(""+val);}
		public void print(Object val)		{print(""+val);}
		
		public void print(String m)			{System.out.print(m);}
		public void println(String m)		{System.out.println(": "+m);}
		
		public void close(){}
		public void flush(){}
	}
}
