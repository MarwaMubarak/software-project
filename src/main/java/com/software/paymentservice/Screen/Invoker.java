package com.software.paymentservice.Screen;

public class Invoker {
	Command command;
	public void setCommand(Command command)
	{
		this.command=command;
		
	}
	public String doAction()
	{
		return command.excute();
	}
}
