package com.itwill.cafe.comment;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
/*
 * ´ñ±Û VOÅ¬·¡½º ¿µ¹ü
 */
public class Comment implements Serializable{
	private int cmtNo;				//´ñ±Û °íÀ¯¹øÈ£
	private String writerName;		//´ñ±Û ÀÛ¼ºÀÚ
	private Calendar writeTime;			//´ñ±Û ÀÛ¼º½Ã°£
	private String cmtContent;		//´ñ±Û ³»¿ë
	private int postNo;
	
	public Comment(int no, String writerName, String cmtContent, int postNo) {
		this.cmtNo = no;
		this.cmtContent = cmtContent;
		this.writeTime = Calendar.getInstance();
		this.writerName = writerName;
		this.postNo = postNo;
	}

	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public Calendar getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Calendar writeTime) {
		this.writeTime = writeTime;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	@Override
	public String toString() {
		return cmtNo+"``"+writerName+"``"+cmtContent+"``"+ postNo+"``"+writeTime+"``";
	}
	
	
	
}
