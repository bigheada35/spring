package edu.kosmo.ex.grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter*/

@Data
public class Grade {
	private String kor;
	private String eng;
	private String mat;
	private String tot;
	private String avg;
	private String gra;
	
	
	public void makeGrade() {
		if(kor == null || eng == null || mat == null) {
			System.out.println("------null-------");	
			return;
			
		}
		System.out.println("---kor length--- : " + kor.length());
		System.out.println("---kor length--- : " + eng.length());
		System.out.println("---kor length--- : " + mat.length());
	
		double total = (double)(Integer.valueOf(kor) + Integer.valueOf(eng)	+ Integer.valueOf(mat));
	
		
		tot = String.valueOf(total);
		avg = String.valueOf(total/3.0f);
		
		if(total >= 90)
			gra = "수"; 
		if(total >= 80)
			gra = "우";
		if(total >= 70)
			gra = "미";
		if(total >= 60)
			gra = "양";
		else
			gra = "가"; 
	
	}
}
