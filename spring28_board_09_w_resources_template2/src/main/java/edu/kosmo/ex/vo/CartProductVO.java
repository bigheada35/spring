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
public class CartProductVO {
	private CartVO cartVO;
	private ProductVO productVO;
	
	private int cart_product_id;
	
	
}

