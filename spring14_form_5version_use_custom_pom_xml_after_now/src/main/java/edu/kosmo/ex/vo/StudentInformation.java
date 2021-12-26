package edu.kosmo.ex.vo;

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
public class StudentInformation {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
}
