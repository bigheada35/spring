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
public class CartVO {
	int cart_product_id;
	int cart_product_quantity;
	String p2user_member_id;
	int p2product_product_id;
	int cart_product_total_price;
}

/*
cart_product_id          NOT NULL NUMBER       
cart_product_quantity             NUMBER       
p2user_member_id                  VARCHAR2(20) 
p2product_product_id              NUMBER       
cart_product_total_price          NUMBER 
*/
