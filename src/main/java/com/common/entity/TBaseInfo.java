package com.common.entity;                                    
import java.util.Date;                                 
/**                                                    
 * generate by neatbooktools                           
 * 2016-5-1 9:45:41                                             
 * @author                                             
 *                                                     
 */                                                    
public class TBaseInfo {                           
	private long id ;                  
	private String username ;                  
	private String realname ;                  
	private String tel ;                  
	private String email ;                  
	private Date creatTime ;                  
	private String url ;                  
	private String code ;                  
	private String qq ;                  
	private String qq2 ;                  
	private String notice ;                  
	private String keyword ;                  
	                                                     
public TBaseInfo() {                               
		super();                                           
	}                                                    
public TBaseInfo(                                  
	  long id ,
	  String username ,
	  String realname ,
	  String tel ,
	  String email ,
	  Date creatTime ,
	  String url ,
	  String code ,
	  String qq ,
	  String qq2 ,
	  String notice ,
	  String keyword 
	) {                                                  
	  super();                                           
	  this.id =id;                   
	  this.username =username;                   
	  this.realname =realname;                   
	  this.tel =tel;                   
	  this.email =email;                   
	  this.creatTime =creatTime;                   
	  this.url =url;                   
	  this.code =code;                   
	  this.qq =qq;                   
	  this.qq2 =qq2;                   
	  this.notice =notice;                   
	  this.keyword =keyword;                   
	}                                                    
	                                                     
public void setId (long id){ 
	   this.id=id;                   
}                                                      
public long getId() {                 
	   return id;                              
}                                                      
public void setUsername (String username){ 
	   this.username=username;                   
}                                                      
public String getUsername() {                 
	   return username;                              
}                                                      
public void setRealname (String realname){ 
	   this.realname=realname;                   
}                                                      
public String getRealname() {                 
	   return realname;                              
}                                                      
public void setTel (String tel){ 
	   this.tel=tel;                   
}                                                      
public String getTel() {                 
	   return tel;                              
}                                                      
public void setEmail (String email){ 
	   this.email=email;                   
}                                                      
public String getEmail() {                 
	   return email;                              
}                                                      
public void setCreatTime (Date creatTime){ 
	   this.creatTime=creatTime;                   
}                                                      
public Date getCreatTime() {                 
	   return creatTime;                              
}                                                      
public void setUrl (String url){ 
	   this.url=url;                   
}                                                      
public String getUrl() {                 
	   return url;                              
}                                                      
public void setCode (String code){ 
	   this.code=code;                   
}                                                      
public String getCode() {                 
	   return code;                              
}                                                      
public void setQq (String qq){ 
	   this.qq=qq;                   
}                                                      
public String getQq() {                 
	   return qq;                              
}                                                      
public void setQq2 (String qq2){ 
	   this.qq2=qq2;                   
}                                                      
public String getQq2() {                 
	   return qq2;                              
}                                                      
public void setNotice (String notice){ 
	   this.notice=notice;                   
}                                                      
public String getNotice() {                 
	   return notice;                              
}                                                      
public void setKeyword (String keyword){ 
	   this.keyword=keyword;                   
}                                                      
public String getKeyword() {                 
	   return keyword;                              
}                                                      
	                                                     
}                                                      
