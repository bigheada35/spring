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
public class OrderVO {
	int order_id;
	int order_amount;
	String order_address;
	Timestamp order_date;
	String p2user_member_id;
	int p2product_product_id;
	int order_check_out;
}

/*
order_id             not null number       
order_amount                  number       
order_address                 varchar2(20) 
order_date                    date         
p2user_member_id              varchar2(20) 
p2product_product_id          number     
order_check_out               number 
*/
