package weekly_challenge;

import java.util.HashMap;

public class week4th {

	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7,5, 5};

		String answer = "ZZZZZZZZ";
		int bigPoint = 0;
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<languages.length; i++) {
			map.put(languages[i], preference[i]);
		}

		for(int i=0; i<table.length; i++) {
			String[] job = table[i].split(" ");
			int point=0;

			for(int j=1; j<job.length; j++) {
				if( map.containsKey(job[j]) ) {
					point += (6-j)*map.get(job[j]);
				}
			}

			if(point > bigPoint) {
				bigPoint = point;
				answer = answer.compareTo(job[0]) < 0 ? answer : job[0];
				//str1.compareTo(str2) = str1 - str2 아스키코드 값임
			}
		}

		System.out.print(answer);

	}

}
