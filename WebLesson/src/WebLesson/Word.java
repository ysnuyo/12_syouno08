package WebLesson;


public class Word{

	private String english;
	private String japanese;

	public Word(){

	}

	public Word(String eng, String jp) {
		this.english = eng;
		this.japanese = jp;
	}

	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getJapanese() {
		return this.japanese;
	}

	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}

	@Override
	public String toString() {
		return "英単語:" + this.english + "　日本語:" + this.japanese;
	}



}
