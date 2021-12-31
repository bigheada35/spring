package edu.kosmo.ex.vo;

import java.sql.Timestamp;

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
	int bid;		//NOT NULL NUMBER(4)
	String bname;	//VARCHAR2(20)
	String btitle;	//VARCHAR2(100)
	String bcontent;//VARCHAR2(300)
	Timestamp bdate;//DATE		
	int bhit;		//NUMBER(4)	
	int bgroup;		//NUMBER(4)	
	int bstep;		//NUMBER(4)	
	int bindent;	//NUMBER(4)

	
}
