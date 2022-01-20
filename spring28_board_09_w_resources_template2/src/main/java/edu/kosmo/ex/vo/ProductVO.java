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
public class ProductVO {
	int product_id;
	String product_name;
	int product_amount;
	int product_price;
	String product_category;
	String product_gender;
	int product_size;
	String product_color;
	String product_img;
	Timestamp supply_date;
	int supply_amount;
	String p2vendor_vendor_name;
}

/*
PRODUCT_ID           NOT NULL NUMBER       
PRODUCT_NAME                  VARCHAR2(20) 
PRODUCT_AMOUNT                NUMBER       
PRODUCT_PRICE                 NUMBER       
PRODUCT_CATEGORY              VARCHAR2(20) 
PRODUCT_GENDER                VARCHAR2(20) 
PRODUCT_SIZE                  NUMBER       
PRODUCT_COLOR                 VARCHAR2(20) 
PRODUCT_IMG                   VARCHAR2(20) 
SUPPLY_DATE                   DATE         
SUPPLY_AMOUNT                 NUMBER       
P2VENDOR_VENDOR_NAME          VARCHAR2(20) 
*/
