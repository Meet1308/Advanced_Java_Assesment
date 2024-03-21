package model;

public class Product {
	
	private int pid;
	private String pname,pcategory,pmodel,pdesc,image;
	private long pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPmodel() {
		return pmodel;
	}
	public void setPmodel(String pmodel) {
		this.pmodel = pmodel;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getPprice() {
		return pprice;
	}
	public void setPprice(long pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcategory=" + pcategory + ", pmodel=" + pmodel
				+ ", pdesc=" + pdesc + ", image=" + image + ", pprice=" + pprice + "]";
	}
	
	
	
}
