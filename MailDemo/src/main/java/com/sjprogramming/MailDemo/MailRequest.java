
//-----------------------------------------mail request-------------------------------------------------

package com.sjprogramming.MailDemo;

public class MailRequest {
    
    private String mail;
    private MailStructure mailStructure;
    public MailRequest() {
    	
    }
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public MailStructure getMailStructure() {
		return mailStructure;
	}
	public void setMailStructure(MailStructure mailStructure) {
		this.mailStructure = mailStructure;
	}
	public MailRequest(String mail, MailStructure mailStructure) {
		super();
		this.mail = mail;
		this.mailStructure = mailStructure;
	}

    
}
