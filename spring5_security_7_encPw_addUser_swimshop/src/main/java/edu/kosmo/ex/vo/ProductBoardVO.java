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
public class ProductBoardVO {
	
	int board_id;             		//NOT NULL NUMBER        
	String board_title;              //VARCHAR2(20)  
	String board_content;            //VARCHAR2(200) 
	Timestamp board_date;            //DATE          
	String p2user_member_id;         //VARCHAR2(20)  
	int p2product_product_id;        //NUMBER        
	String p2user_member_name;       //VARCHAR2(20)  
	int board_hit;                   //NUMBER        
	int board_group;                 //NUMBER        
	int board_step;                  //NUMBER        
	int board_indent;                //NUMBER             
	
}
