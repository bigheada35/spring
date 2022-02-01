package edu.kosmo.ex.service;

import java.sql.Timestamp;
import java.util.List;

import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public interface BoardService {
	List<BoardVO> getList();
}