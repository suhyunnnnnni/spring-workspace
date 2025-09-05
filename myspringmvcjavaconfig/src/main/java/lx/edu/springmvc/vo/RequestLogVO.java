package lx.edu.springmvc.vo;


public class RequestLogVO {
	
	public int id;
	public String reqClass;
	public String reqMethod;
	public String reqTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReqClass() {
		return reqClass;
	}
	public void setReqClass(String reqClass) {
		this.reqClass = reqClass;
	}
	public String getReqMethod() {
		return reqMethod;
	}
	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	
	@Override
	public String toString() {
		return "RequestLogVO [id=" + id + ", reqClass=" + reqClass + ", reqMethod=" + reqMethod + ", reqTime=" + reqTime
				+ "]";
	}
	
	
}
