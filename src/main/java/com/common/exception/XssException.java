package com.common.exception;

public class XssException extends Exception
{


	private static final long serialVersionUID = -227961057827878851L;
	

	public XssException()
	{
	}

	public XssException(String arg0)
	{
		super(arg0);
	}

	public XssException(Throwable arg0)
	{
		super(arg0);
	}

	public XssException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
	}

	public XssException(String arg0, Throwable arg1, int exceptionCode)
	{
		super(arg0, arg1);
	}
}
