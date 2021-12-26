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
				Integer.valueOf(mat);
		
		double average = total/3.0f;
		
		tot = String.valueOf(total);
		avg = String.valueOf(average);
		if(total>= 90)
			gra= "수";
		else if(total>= 80)
			gra= "우";
		else if(total>= 70)
			gra= "미";
		else if(total>= 60)
			gra= "양";
		else
			gra= "가";
		
	}
	
	
}
