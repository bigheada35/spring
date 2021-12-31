package edu.kosmo.ex.vo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVO {
/*
 BID      		NOT NULL NUMBER(4)     
BNAME             VARCHAR2(20)  
BTITLE            VARCHAR2(100) 
BCONTENT          VARCHAR2(300) 
BDATE             DATE          
BHIT              NUMBER(4)     
BGROUP            NUMBER(4)     
BSTEP             NUMBER(4)     
BINDENT           NUMBER(4)        
 */

	int bid;      
	String bname;    
	String btitle;   
	String bcontent; 
	Timestamp bdate;    
	int bhit;     
	int bgroup;   
	int bstep;    
	int bindent;
	
}
