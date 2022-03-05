package edu.kosmo.kbat.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NBoardVO {

	private int board_id;
	private String board_title;
	private String board_content;
	private Timestamp board_date;
	private int board_hit;
	private int boardtype_id;
	private int member_number;
	private String member_id;
	
	//조인할거. 외래키 가져올것	
	private List<BoardtypeVO> boardtypeList;

	
}
