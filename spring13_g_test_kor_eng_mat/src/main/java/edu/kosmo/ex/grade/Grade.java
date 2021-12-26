package edu.kosmo.ex.grade;

import lombok.Data;

@Data
public class Grade {
	private String kor;
	private String eng;
	private String mat;
	private String tot;
	private String avg;
	private String gra;
	
	public void makeGrade() {
		

		double total = Integer.valueOf(kor) +
						Integer.valueOf(eng) +
						Integer.valueOf(mat) ;
		tot = String.valueOf(total);
		double average = total/3.0f;
		avg = String.valueOf(average);
		
		if(average >= 90)
			gra="수";
		else if(average >= 80)
			gra="우";
		else if(average >= 70)
			gra="미";
		else if(average >= 60)
			gra="양";
		else
			gra="가";
		
		
	}
	
	
	
}
