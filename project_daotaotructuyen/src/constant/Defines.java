package constant;

public class Defines {
	// định nghĩa các thông số cho ứng dụng web
	private String urlAdmin;
	private String urlPublic;
	
	public static final String SUCCESS = "Xử lý thành công!";
	public static final String ERROR = "Có lỗi xảy ra trong quá trình xử lý!";
	
	public static final String DIR_UPLOAD = "files";
	
	public String getUrlAdmin() {
		return urlAdmin;
	}
	public void setUrlAdmin(String urlAdmin) {
		this.urlAdmin = urlAdmin;
	}
	public String getUrlPublic() {
		return urlPublic;
	}
	public void setUrlPublic(String urlPublic) {
		this.urlPublic = urlPublic;
	}
}
