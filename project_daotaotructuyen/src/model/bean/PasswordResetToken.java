package model.bean;

import java.util.Calendar;
import java.util.Date;

//@Entity
public class PasswordResetToken {

	private Long id;
    private String token;
    private Account account;
    private Date expiryDate;
	public PasswordResetToken() {
		super();
	}
	public PasswordResetToken(Long id, String token, Account account, Date expiryDate) {
		super();
		this.id = id;
		this.token = token;
		this.account = account;
		this.expiryDate = expiryDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
    
}
